package com.iker.hotelreservationapp.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private long price;
    private LocalDate timeOfPost;

    public Hotel() {}
    
    public Hotel(String name, String location, long price, LocalDate timeOfPost) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.timeOfPost = timeOfPost;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
