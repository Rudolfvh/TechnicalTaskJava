package org.example.technicaltask.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateHotelRequest {

    @NotBlank(message = "Hotel name must not be blank")
    private String name;

    private String description;

    @NotBlank(message = "Brand must not be blank")
    private String brand;

    @NotNull(message = "Address is required")
    @Valid
    private AddressRequest address;

    @NotNull(message = "Contacts are required")
    @Valid
    private ContactsRequest contacts;

    @Valid
    private ArrivalTimeRequest arrivalTime;
}
