package com.example.facturationproject.infrastructure.controller;


import com.example.facturationproject.application.commant.User.UserCreate;
import com.example.facturationproject.application.query.user.UserFind;
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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFind userFind;
    private final UserCreate userCreate;
    private final ValidateErrors validateErrors;


    @PostMapping
    public ResponseEntity<String> CreateUser(@Validated @RequestBody UserRequest user, BindingResult result){
        if(result.hasErrors()) {

            throw new BadRequestException(validateErrors.ValidFields(result));
        }

        userCreate.createUser(user);

        String CREATE_RESPONSE = "User Created";
        return new ResponseEntity<>(CREATE_RESPONSE,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> GetUser(@PathVariable Long id){

        UserResponse userResponse = userFind.findById(id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);

    }






}


