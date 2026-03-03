package org.example.technicaltask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArrivalTimeResponse {

    private String checkIn;
    private String checkOut;
}
