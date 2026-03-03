package org.example.technicaltask.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactsRequest {

    @NotBlank(message = "Phone must not be blank")
    private String phone;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email must not be blank")
    private String email;
}
