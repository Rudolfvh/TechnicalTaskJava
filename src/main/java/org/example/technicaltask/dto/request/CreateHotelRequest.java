package org.example.technicaltask.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }

    public ContactsRequest getContacts() {
        return contacts;
    }

    public void setContacts(ContactsRequest contacts) {
        this.contacts = contacts;
    }

    public ArrivalTimeRequest getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTimeRequest arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
