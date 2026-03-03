package org.example.technicaltask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalTimeRequest {

    private String checkIn;
    private String checkOut;
}
