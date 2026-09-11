package com.iker.hotelreservationapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iker.hotelreservationapp.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    boolean existsByName(String name);
}
