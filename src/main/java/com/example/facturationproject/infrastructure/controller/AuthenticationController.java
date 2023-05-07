package com.example.facturationproject.infrastructure.controller;

import com.example.facturationproject.application.Auth.AuthRequest;
import com.example.facturationproject.application.Auth.AuthResponse;
import com.example.facturationproject.application.Auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody AuthRequest request) {
       AuthResponse response = authService.login(request);
       return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
