package com.iker.hotelreservationapp.exceptions.hotel;

public class HotelDoesntExist extends RuntimeException {
    public HotelDoesntExist(String message) {
        super(message);
    }
}
