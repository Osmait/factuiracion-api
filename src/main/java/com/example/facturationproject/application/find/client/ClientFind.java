package com.example.facturationproject.application.find.client;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientFind {

    private final ClientRepository clientRepository;
    private final AuthService authService;




    public List<Client> findAll() {
       Long  userId = authService.getIdCurrentLoggedUser().getId();
        System.out.printf("--------------------" + userId);
        return clientRepository.findAllByUserId(userId).orElseThrow( () -> new NotFondException("Client not found"));
    }
}
