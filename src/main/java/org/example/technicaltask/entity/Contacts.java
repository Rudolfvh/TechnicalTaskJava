package org.example.technicaltask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contacts {

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}