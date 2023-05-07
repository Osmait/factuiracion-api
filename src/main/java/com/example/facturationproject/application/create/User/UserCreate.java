package com.example.facturationproject.application.create.User;


import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.domain.user.UserRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.DuplicateResourceException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserCreate {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    final String EMAIL_EXISTS = "Email exits";

    public void createUser(User user){

       User userDb = userRepository.findByEmail(user.getEmail()).orElse(new User());

        if (Objects.equals(userDb.getEmail(), user.getEmail())){
            throw  new DuplicateResourceException(EMAIL_EXISTS);
        }
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);


        userRepository.save(user);

    }


}
