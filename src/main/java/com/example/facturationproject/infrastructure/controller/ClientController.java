package com.example.facturationproject.infrastructure.controller;

import com.example.facturationproject.application.commant.Client.ClientCreate;
import com.example.facturationproject.application.commant.Client.DeletedClient;
import com.example.facturationproject.application.commant.Client.UpdatedClient;
import com.example.facturationproject.application.query.client.ClientFind;
import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.infrastructure.Dto.client.ClientRequest;
import com.example.facturationproject.infrastructure.Dto.client.ClientResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.BadRequestException;
import com.example.facturationproject.infrastructure.utils.ValidateErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientCreate clientCreate;
    private final ClientFind clientFind;
    private final DeletedClient deletedClient;
    private final UpdatedClient updatedClient;
    private final ValidateErrors validateErrors;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll(){

         List<ClientResponse> clientResponses =  clientFind.findAll();
        return new ResponseEntity<>(clientResponses, HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ClientRequest clientRequest, BindingResult result){
        if(result.hasErrors()) {

            throw new BadRequestException(validateErrors.ValidFields(result));
        }

        Client client = clientRequest.toClient();
        clientCreate.create(client);

        String CREATE_RESPONSE = "Client Created";
        return new ResponseEntity<>(CREATE_RESPONSE,HttpStatus.CREATED);

    }


    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @Validated @RequestBody ClientRequest clientRequest,
                                         BindingResult result){

        if(result.hasErrors()) {

            throw new BadRequestException(validateErrors.ValidFields(result));
        }

        Client client = clientRequest.toClient();
        updatedClient.update(client,id);
        String UPDATE_RESPONSE = "Client Updated";
        return new ResponseEntity<>(UPDATE_RESPONSE,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        deletedClient.delete(id);
        String DELETE_RESPONSE = "Client Deleted";
        return new ResponseEntity<>(DELETE_RESPONSE,HttpStatus.OK);
    }

}
