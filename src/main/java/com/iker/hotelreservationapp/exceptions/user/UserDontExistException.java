package com.iker.hotelreservationapp.exceptions.user;

public class UserDontExistException extends RuntimeException {
    public UserDontExistException(String message) {
        super(message);
    }
}
