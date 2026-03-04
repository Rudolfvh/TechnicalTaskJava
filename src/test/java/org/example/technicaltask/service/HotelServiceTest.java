package org.example.technicaltask.service;

import org.example.technicaltask.config.AppProperties;
import org.example.technicaltask.entity.Hotel;
import org.example.technicaltask.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelServiceTest {

    @Mock
    private HotelRepository repository;

    @Mock
    private AppProperties appProperties;

    @InjectMocks
    private HotelService service;

    @Test
    void testGetAll_ReturnsAllHotels() {
        List<Hotel> hotels = List.of(new Hotel(), new Hotel());
        when(repository.findAll()).thenReturn(hotels);

        List<Hotel> result = service.getAll();

        assertEquals(2, result.size());
        verify(repository).findAll();
    }

    @Test
    void testGetById_ExistingId_ReturnsHotel() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(hotel));

        Hotel result = service.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(repository).findById(1L);
    }

    @Test
    void testCreate_SavesHotel() {
        Hotel hotel = new Hotel();
        when(repository.save(hotel)).thenReturn(hotel);

        Hotel result = service.create(hotel);

        assertNotNull(result);
        verify(repository).save(hotel);
    }

    @Test
    void testAddAmenities_AddsAmenitiesToHotel() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setAmenities(new HashSet<>());
        when(repository.findById(1L)).thenReturn(Optional.of(hotel));
        when(repository.save(any())).thenReturn(hotel);

        Set<String> newAmenities = Set.of("Pool", "WiFi");
        service.addAmenities(1L, newAmenities);

        assertTrue(hotel.getAmenities().containsAll(newAmenities));
        verify(repository).save(hotel);
    }

    @Test
    void testHistogram_ByBrand_ReturnsCounts() {
        Hotel h1 = new Hotel(); h1.setBrand("A");
        Hotel h2 = new Hotel(); h2.setBrand("A");
        Hotel h3 = new Hotel(); h3.setBrand("B");

        when(repository.findAll()).thenReturn(List.of(h1, h2, h3));

        AppProperties.Histogram histogram = mock(AppProperties.Histogram.class);
        when(appProperties.getHistogram()).thenReturn(histogram);
        when(histogram.getAllowed()).thenReturn(List.of("brand"));

        Map<String, Long> result = service.histogram("brand");

        assertEquals(2L, result.get("A"));
        assertEquals(1L, result.get("B"));
    }

    @Test
    void testGetById_NonExistingId_ThrowsException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.getById(1L));

        assertEquals("Hotel not found", ex.getMessage());
    }

    @Test
    void testHistogram_UnsupportedParameter_ThrowsIllegalArgumentException() {
        AppProperties.Histogram histogram = mock(AppProperties.Histogram.class);
        when(appProperties.getHistogram()).thenReturn(histogram);
        when(histogram.getAllowed()).thenReturn(List.of("brand", "city"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.histogram("unknown"));

        assertEquals("Unsupported histogram parameter: unknown", ex.getMessage());
    }

    @Test
    void testHistogram_UnexpectedParameter_ThrowsIllegalStateException() {
        AppProperties.Histogram histogram = mock(AppProperties.Histogram.class);
        when(appProperties.getHistogram()).thenReturn(histogram);
        when(histogram.getAllowed()).thenReturn(List.of("brand", "city", "country", "amenities", "other"));

        Hotel hotel = new Hotel();
        when(repository.findAll()).thenReturn(List.of(hotel));

        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> service.histogram("other"));

        assertTrue(ex.getMessage().contains("Unexpected value"));
    }
}