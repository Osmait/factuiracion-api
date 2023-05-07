package com.example.facturationproject.application.find.user;

import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.domain.user.UserRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class UserFind {

    final String USER_NOT_FOUND = "User not found";


    private final UserRepository userRepository;

    public User findById(Long id) {

       return  userRepository.findById(id).orElseThrow(()-> new NotFondException(USER_NOT_FOUND));


    }
    public User findByEmail(String email){

        return  userRepository.findByEmail(email).orElseThrow(()-> new NotFondException(USER_NOT_FOUND));


    }


}
