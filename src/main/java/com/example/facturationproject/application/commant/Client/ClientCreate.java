package com.example.facturationproject.application.commant.Client;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCreate {

    private final ClientRepository clientRepository;
    private final AuthService authService;


    public void create(Client client) {
       User currentUser = authService.getIdCurrentLoggedUser();
       client.setUser(currentUser);
       clientRepository.save(client);
    }
}
