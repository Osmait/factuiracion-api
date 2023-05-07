package com.example.facturationproject.infrastructure.controller;

import com.example.facturationproject.application.create.Client.ClientCreate;
import com.example.facturationproject.application.find.client.ClientFind;
import com.example.facturationproject.domain.client.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientCreate clientCreate;
    private final ClientFind clientFind;

    private final String CREATE_RESPONSE = "Client Created";

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(clientFind.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Client client){
        clientCreate.create(client);

        return new ResponseEntity<>(CREATE_RESPONSE,HttpStatus.CREATED);

    }

}
