package org.example.technicaltask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ContactsResponse {

    private String phone;
    private String email;
}
