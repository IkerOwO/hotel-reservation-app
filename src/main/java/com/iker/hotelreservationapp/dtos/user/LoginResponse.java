package com.iker.hotelreservationapp.dtos.user;

public record LoginResponse(
        String token,
        Long id,
        String username,
        String email,
        String role
) {}
