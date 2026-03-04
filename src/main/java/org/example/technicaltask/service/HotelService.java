package org.example.technicaltask.service;

import org.example.technicaltask.config.AppProperties;
import org.example.technicaltask.entity.Hotel;
import org.example.technicaltask.repository.HotelRepository;
import org.example.technicaltask.specification.HotelSpecification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository repository;
    private final AppProperties appProperties;

    public HotelService(HotelRepository repository, AppProperties appProperties) {
        this.repository = repository;
        this.appProperties = appProperties;
    }

    public List<Hotel> getAll() {
        return repository.findAll();
    }

    public Hotel getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    public Hotel create(Hotel hotel) {
        return repository.save(hotel);
    }

    public void addAmenities(Long id, Set<String> amenities) {
        Hotel hotel = getById(id);
        hotel.getAmenities().addAll(amenities);
        repository.save(hotel);
    }

    public List<Hotel> search(String name, String brand,
                              String city, String country,
                              String amenities) {

        return repository.findAll(
                HotelSpecification.filter(name, brand, city, country, amenities)
        );
    }

    public Map<String, Long> histogram(String param) {

        if (!appProperties.getHistogram().getAllowed().contains(param)) {
            throw new IllegalArgumentException("Unsupported histogram parameter: " + param);
        }

        List<Hotel> hotels = repository.findAll();

        return switch (param) {
            case "brand" ->
                    hotels.stream()
                            .collect(Collectors.groupingBy(
                                    Hotel::getBrand,
                                    Collectors.counting()));

            case "city" ->
                    hotels.stream()
                            .collect(Collectors.groupingBy(
                                    h -> h.getAddress().getCity(),
                                    Collectors.counting()));

            case "country" ->
                    hotels.stream()
                            .collect(Collectors.groupingBy(
                                    h -> h.getAddress().getCountry(),
                                    Collectors.counting()));

            case "amenities" ->
                    hotels.stream()
                            .flatMap(h -> h.getAmenities().stream())
                            .collect(Collectors.groupingBy(
                                    a -> a,
                                    Collectors.counting()));

            default -> throw new IllegalStateException("Unexpected value: " + param);
        };
    }
}
