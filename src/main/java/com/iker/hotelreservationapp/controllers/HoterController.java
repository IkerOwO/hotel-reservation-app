package com.iker.hotelreservationapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iker.hotelreservationapp.dtos.hotel.RegisterHotelRequest;
import com.iker.hotelreservationapp.entities.Hotel;
import com.iker.hotelreservationapp.services.HotelService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping("/hotel") 
public class HoterController {
    @Autowired 
    private HotelService service;

    public HoterController(HotelService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return service.getAllHotels();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<?> insertNewHotel(@Valid @RequestBody RegisterHotelRequest request) {
        service.insertHotel(request);
        return ResponseEntity.ok("Hotel created!");
    }
    
    @PutMapping("/price/{price}")
    public void updatePrice(@Valid @RequestBody Long id, @PathVariable long newPrice) {
        service.updatePrice(id, newPrice);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        service.deleteHotel(id);
    }
}
