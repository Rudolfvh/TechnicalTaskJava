package org.example.technicaltask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class HotelShortResponse {

    private Long id;
    private String name;
    private String description;
    private String address;
    private String phone;
}
