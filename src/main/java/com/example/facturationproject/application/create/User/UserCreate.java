package com.example.facturationproject.application.create.User;


import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.domain.user.UserRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserCreate {


    private final UserRepository userRepository;
    final String EMAIL_EXISTS = "Email exits";

    public void createUser(User user){

       User userDb = userRepository.findByEmail(user.getEmail()).orElse(new User());

        if (Objects.equals(userDb.getEmail(), user.getEmail())){
            throw  new DuplicateResourceException(EMAIL_EXISTS);
        }


        userRepository.save(user);

    }


}
