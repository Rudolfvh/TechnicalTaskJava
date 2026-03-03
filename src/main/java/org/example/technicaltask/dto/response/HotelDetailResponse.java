package org.example.technicaltask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class HotelDetailResponse {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private AddressResponse address;
    private ContactsResponse contacts;
    private ArrivalTimeResponse arrivalTime;
    private Set<String> amenities;
}