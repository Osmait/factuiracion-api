package com.example.facturationproject.application.commant.Client;


import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatedClient {

    private final ClientRepository clientRepository;

    public void update(Client client,Long id) {
        Client clientDB = clientRepository.findById(id).orElseThrow(() -> new NotFondException("client not found"));
        clientDB.setEmail(client.getEmail());
        clientDB.setName(client.getName());
        clientDB.setLastName(client.getLastName());
        clientDB.setAddress(client.getAddress());
        clientDB.setPhone(client.getPhone());


        clientRepository.save(clientDB);
    }

}
