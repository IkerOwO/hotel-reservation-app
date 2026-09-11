package com.iker.hotelreservationapp.dtos.hotel;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterHotelRequest {
    @NotBlank 
    private String name;
    
    @NotBlank 
    private String location;

    @Size(min = 2)
    private long price;

    private LocalDate timeOfPost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public LocalDate getTimeOfPost() {
        return timeOfPost;
    }

    public void setTimeOfPost(LocalDate timeOfPost) {
        this.timeOfPost = timeOfPost;
    }
}
