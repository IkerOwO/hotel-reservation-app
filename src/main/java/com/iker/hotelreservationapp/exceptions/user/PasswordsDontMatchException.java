package com.iker.hotelreservationapp.exceptions.user;

public class PasswordsDontMatchException extends RuntimeException {
    public PasswordsDontMatchException(String message) {
        super(message);
    }
}
