package org.example.technicaltask.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class ContactsRequest {

    @NotBlank(message = "Phone must not be blank")
    private String phone;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email must not be blank")
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
