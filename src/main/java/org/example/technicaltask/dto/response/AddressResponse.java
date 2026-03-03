package org.example.technicaltask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AddressResponse {

    private Integer houseNumber;
    private String street;
    private String city;
    private String country;
    private String postCode;
}
