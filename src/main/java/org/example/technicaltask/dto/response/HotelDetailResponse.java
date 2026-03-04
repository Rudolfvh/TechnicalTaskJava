package org.example.technicaltask.dto.response;


import java.util.Set;

public class HotelDetailResponse {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private AddressResponse address;
    private ContactsResponse contacts;
    private ArrivalTimeResponse arrivalTime;
    private Set<String> amenities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public ContactsResponse getContacts() {
        return contacts;
    }

    public void setContacts(ContactsResponse contacts) {
        this.contacts = contacts;
    }

    public ArrivalTimeResponse getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTimeResponse arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Set<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(Set<String> amenities) {
        this.amenities = amenities;
    }
}