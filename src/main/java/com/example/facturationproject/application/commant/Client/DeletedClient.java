package com.example.facturationproject.application.commant.Client;

import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletedClient {

    private final ClientRepository clientRepository;

    public void delete(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new NotFondException("client " + id + " not found"));
        client.setDeleted(true);
        clientRepository.save(client);
    }
}
