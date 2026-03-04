package org.example.technicaltask.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.example.technicaltask.dto.request.CreateHotelRequest;
import org.example.technicaltask.dto.response.HotelDetailResponse;
import org.example.technicaltask.dto.response.HotelShortResponse;
import org.example.technicaltask.entity.Hotel;
import org.example.technicaltask.mapper.HotelMapper;
import org.example.technicaltask.service.HotelService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("${app.api.prefix}")
@Validated
public class HotelController {

    private final HotelService service;
    private final HotelMapper mapper;

    public HotelController(HotelService service, HotelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/hotels")
    public List<HotelShortResponse> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toShortResponse)
                .toList();
    }

    @GetMapping("/hotels/{id}")
    public HotelDetailResponse getById(@PathVariable @Positive Long id) {
        return mapper.toDetailResponse(service.getById(id));
    }

    @PostMapping("/hotels")
    public HotelShortResponse create(@Valid @RequestBody CreateHotelRequest request) {

        Hotel saved = service.create(
                mapper.toEntity(request)
        );

        return mapper.toShortResponse(saved);
    }

    @PostMapping("/hotels/{id}/amenities")
    public void addAmenities(@PathVariable @Positive Long id,
            @RequestBody Set<@NotBlank String> amenities) {
        service.addAmenities(id, amenities);
    }

    @GetMapping("/search")
    public List<HotelShortResponse> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String amenities
    ) {
        return service.search(name, brand, city, country, amenities)
                .stream()
                .map(mapper::toShortResponse)
                .toList();
    }

    @GetMapping("/histogram/{param}")
    public Map<String, Long> histogram(@PathVariable String param) {
        return service.histogram(param);
    }
}
