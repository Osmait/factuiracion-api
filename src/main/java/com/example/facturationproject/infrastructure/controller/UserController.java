package com.example.facturationproject.infrastructure.controller;


import com.example.facturationproject.application.create.User.UserCreate;
import com.example.facturationproject.application.find.user.UserFind;
import com.example.facturationproject.domain.user.User;

import com.example.facturationproject.infrastructure.Dto.user.UserRequest;
import com.example.facturationproject.infrastructure.Dto.user.UserResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.BadRequestException;
import com.example.facturationproject.infrastructure.utils.ValidateErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFind userFind;
    private final UserCreate userCreate;
    private final ValidateErrors validateErrors;
    private final String CREATE_RESPONSE = "User Created";


    @PostMapping("/user")
    public ResponseEntity<String> CreateUser(@Validated @RequestBody UserRequest user, BindingResult result){
        if(result.hasErrors()) {

            throw new BadRequestException(validateErrors.ValidFilds(result).toString());
        }
        User newUser =  user.getUserFromDto();
        userCreate.createUser(newUser);

        return new ResponseEntity<>(CREATE_RESPONSE,HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> GetUser(@PathVariable Long id){

        User user = userFind.findById(id);
        UserResponse userResponse = new UserResponse(user.getName() , user.getLastName(), user.getEmail(), user.getCreateAt());

        return new ResponseEntity<>(userResponse, HttpStatus.OK);

    }





}


