package com.iker.hotelreservationapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.iker.hotelreservationapp.dtos.hotel.RegisterHotelRequest;
import com.iker.hotelreservationapp.entities.Hotel;
import com.iker.hotelreservationapp.exceptions.hotel.HotelDoesntExist;
import com.iker.hotelreservationapp.repositories.HotelRepository;

@Service 
public class HotelService {
    @Autowired 
    private HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    public Optional<Hotel> getById(Long id) {
        return repository.findById(id);
    }

    public void insertHotel(RegisterHotelRequest request) {
        if (repository.existsByName(request.getName())) {
            throw new HotelDoesntExist("Hotel not found!");
        }

        Hotel hotel = new Hotel();
        hotel.setName(request.getName());
        hotel.setLocation(request.getLocation());
        hotel.setPrice(request.getPrice());
        hotel.setTimeOfPost(request.getTimeOfPost());

        repository.save(hotel);
    }

    @Transactional(readOnly = true)
    public void updatePrice(Long id, long newPrice) {
        Optional<Hotel> opHotel = repository.findById(id);

        if (opHotel.isPresent()) {
            Hotel hotel = opHotel.get();
            hotel.setPrice(newPrice);
            repository.save(hotel);
        }
    }

    public void deleteHotel(Long id) {
        Optional<Hotel> opHotel = repository.findById(id);

        opHotel.ifPresentOrElse(
            h -> repository.delete(h), 
            () -> new HotelDoesntExist("Hotel not found!")
        );
    }
}
