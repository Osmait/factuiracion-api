package com.example.facturationproject.application.query.client;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.infrastructure.Dto.client.ClientResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientFind {

    private final ClientRepository clientRepository;
    private final AuthService authService;




    public List<ClientResponse> findAll() {
       Long  userId = authService.getIdCurrentLoggedUser().getId();



        List<Client>clients = clientRepository.findAllByUserIdAndDeletedFalse(
                userId).orElseThrow( () -> new NotFondException("Client not found"));

        return clients.stream().map(client -> new ClientResponse(
                client.getId(),
                client.getName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhone(),
                client.getAddress(),
                client.getCreateAt()
        )).toList();
    }
}
