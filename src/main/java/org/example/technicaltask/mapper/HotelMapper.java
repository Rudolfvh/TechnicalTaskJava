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

        Hotel hotel = new Hotel();
        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setBrand(request.getBrand());

        if (request.getAddress() != null) {
            Address address = new Address();
            address.setHouseNumber(request.getAddress().getHouseNumber());
            address.setStreet(request.getAddress().getStreet());
            address.setCity(request.getAddress().getCity());
            address.setCountry(request.getAddress().getCountry());
            address.setPostCode(request.getAddress().getPostCode());
            hotel.setAddress(address);
        }

        if (request.getContacts() != null) {
            Contacts contacts = new Contacts();
            contacts.setPhone(request.getContacts().getPhone());
            contacts.setEmail(request.getContacts().getEmail());
            hotel.setContacts(contacts);
        }

        if (request.getArrivalTime() != null) {
            ArrivalTime arrivalTime = new ArrivalTime();
            arrivalTime.setCheckIn(request.getArrivalTime().getCheckIn());
            arrivalTime.setCheckOut(request.getArrivalTime().getCheckOut());
            hotel.setArrivalTime(arrivalTime);
        }

        return hotel;
    }

    public HotelShortResponse toShortResponse(Hotel hotel) {

        String formattedAddress =
                hotel.getAddress().getHouseNumber() + " " +
                        hotel.getAddress().getStreet() + ", " +
                        hotel.getAddress().getCity() + ", " +
                        hotel.getAddress().getPostCode() + ", " +
                        hotel.getAddress().getCountry();

        HotelShortResponse response = new HotelShortResponse();
        response.setId(hotel.getId());
        response.setName(hotel.getName());
        response.setDescription(hotel.getDescription());
        response.setAddress(formattedAddress);
        response.setPhone(hotel.getContacts().getPhone());

        return response;
    }

    public HotelDetailResponse toDetailResponse(Hotel hotel) {

        HotelDetailResponse response = new HotelDetailResponse();
        response.setId(hotel.getId());
        response.setName(hotel.getName());
        response.setDescription(hotel.getDescription());
        response.setBrand(hotel.getBrand());

        // Address
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setHouseNumber(hotel.getAddress().getHouseNumber());
        addressResponse.setStreet(hotel.getAddress().getStreet());
        addressResponse.setCity(hotel.getAddress().getCity());
        addressResponse.setCountry(hotel.getAddress().getCountry());
        addressResponse.setPostCode(hotel.getAddress().getPostCode());
        response.setAddress(addressResponse);

        // Contacts
        ContactsResponse contactsResponse = new ContactsResponse();
        contactsResponse.setPhone(hotel.getContacts().getPhone());
        contactsResponse.setEmail(hotel.getContacts().getEmail());
        response.setContacts(contactsResponse);

        // Arrival time
        if (hotel.getArrivalTime() != null) {
            ArrivalTimeResponse arrivalTimeResponse = new ArrivalTimeResponse();
            arrivalTimeResponse.setCheckIn(hotel.getArrivalTime().getCheckIn());
            arrivalTimeResponse.setCheckOut(hotel.getArrivalTime().getCheckOut());
            response.setArrivalTime(arrivalTimeResponse);
        }

        response.setAmenities(hotel.getAmenities());

        return response;
    }
}
