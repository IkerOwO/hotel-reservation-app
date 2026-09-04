package com.iker.hotelreservationapp.services;

import com.iker.hotelreservationapp.dtos.user.LoginRequest;
import com.iker.hotelreservationapp.dtos.user.LoginResponse;
import com.iker.hotelreservationapp.dtos.user.RegisterUserRequest;
import com.iker.hotelreservationapp.entities.User;
import com.iker.hotelreservationapp.exceptions.user.PasswordsDontMatchException;
import com.iker.hotelreservationapp.exceptions.user.UserAlreadyExistsException;
import com.iker.hotelreservationapp.exceptions.user.UserDontExistException;
import com.iker.hotelreservationapp.repositories.AuthRepository;
import com.iker.hotelreservationapp.security.JwtService;
import com.iker.hotelreservationapp.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AuthRepository repository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder encoder;

    public AuthService(AuthRepository repository, JwtService jwtService, PasswordEncoder encoder) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    public void registerUser(RegisterUserRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email associated with another account!");
        }
        User user = new User();
        user.setName(request.getName());
        user.setLast_name(request.getLast_name());
        user.setBirth_date(request.getBirth_date());
        user.setEmail(request.getEmail());
        user.setUser_location(request.getUser_location());
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");

        repository.save(user);
    }

    public LoginResponse loginUser(LoginRequest request) {
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserDontExistException("The user doesn't exists!"));

        if (!encoder.matches(request.getPassword(), user.getPassword())){
            throw new PasswordsDontMatchException("Incorrect login!");
        }

        return new LoginResponse(
                jwtService.generateToken(user),
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}
