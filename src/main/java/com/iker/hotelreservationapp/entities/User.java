package com.iker.hotelreservationapp.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String last_name;
    private String username;
    private String role;
    private LocalDate birth_date;
    private String email;
    private String password;
    private String user_location;

    public User() { }

    public User(String name, String last_name, String username, String role, LocalDate birth_date, String email, String password, String user_location) {
        this.name = name;
        this.last_name = last_name;
        this.username = username;
        this.role = role;
        this.birth_date = birth_date;
        this.email = email;
        this.password = password;
        this.user_location = user_location;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public void checkAge(LocalDate birth_date) throws IllegalAccessException {
        int age = LocalDate.now().getYear() - birth_date.getYear();
        if (age < 18) {
            throw new IllegalAccessException("Age is below 18");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }
}
