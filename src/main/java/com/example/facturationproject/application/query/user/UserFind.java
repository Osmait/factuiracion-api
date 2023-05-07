package com.example.facturationproject.application.query.user;

import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.domain.user.UserRepository;
import com.example.facturationproject.infrastructure.Dto.user.UserResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserFind {

    final String USER_NOT_FOUND = "User not found";


    private final UserRepository userRepository;

    public UserResponse findById(Long id) {

       User user= userRepository.findById(id).orElseThrow(()-> new NotFondException(USER_NOT_FOUND));
       return  new UserResponse(user.getName() , user.getLastName(), user.getEmail(), user.getCreateAt());


    }
    public User findByEmail(String email){

        return  userRepository.findByEmail(email).orElseThrow(()-> new NotFondException(USER_NOT_FOUND));


    }


}
