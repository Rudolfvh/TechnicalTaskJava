package org.example.technicaltask.mapper;

import org.example.technicaltask.dto.request.CreateHotelRequest;
import org.example.technicaltask.dto.response.*;
import org.example.technicaltask.entity.Address;
import org.example.technicaltask.entity.ArrivalTime;
import org.example.technicaltask.entity.Contacts;
import org.example.technicaltask.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel toEntity(CreateHotelRequest request) {

        return Hotel.builder()
                .name(request.getName())
                .description(request.getDescription())
                .brand(request.getBrand())
                .address(
                        Address.builder()
                                .houseNumber(request.getAddress().getHouseNumber())
                                .street(request.getAddress().getStreet())
                                .city(request.getAddress().getCity())
                                .country(request.getAddress().getCountry())
                                .postCode(request.getAddress().getPostCode())
                                .build()
                )
                .contacts(
                        Contacts.builder()
                                .phone(request.getContacts().getPhone())
                                .email(request.getContacts().getEmail())
                                .build()
                )
                .arrivalTime(
                        request.getArrivalTime() == null ? null :
                                ArrivalTime.builder()
                                        .checkIn(request.getArrivalTime().getCheckIn())
                                        .checkOut(request.getArrivalTime().getCheckOut())
                                        .build()
                )
                .build();
    }

    public HotelShortResponse toShortResponse(Hotel hotel) {

        String formattedAddress =
                hotel.getAddress().getHouseNumber() + " " +
                        hotel.getAddress().getStreet() + ", " +
                        hotel.getAddress().getCity() + ", " +
                        hotel.getAddress().getPostCode() + ", " +
                        hotel.getAddress().getCountry();

        return HotelShortResponse.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .address(formattedAddress)
                .phone(hotel.getContacts().getPhone())
                .build();
    }

    public HotelDetailResponse toDetailResponse(Hotel hotel) {

        return HotelDetailResponse.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .brand(hotel.getBrand())
                .address(
                        AddressResponse.builder()
                                .houseNumber(hotel.getAddress().getHouseNumber())
                                .street(hotel.getAddress().getStreet())
                                .city(hotel.getAddress().getCity())
                                .country(hotel.getAddress().getCountry())
                                .postCode(hotel.getAddress().getPostCode())
                                .build()
                )
                .contacts(
                        ContactsResponse.builder()
                                .phone(hotel.getContacts().getPhone())
                                .email(hotel.getContacts().getEmail())
                                .build()
                )
                .arrivalTime(
                        hotel.getArrivalTime() == null ? null :
                                ArrivalTimeResponse.builder()
                                        .checkIn(hotel.getArrivalTime().getCheckIn())
                                        .checkOut(hotel.getArrivalTime().getCheckOut())
                                        .build()
                )
                .amenities(hotel.getAmenities())
                .build();
    }
}
