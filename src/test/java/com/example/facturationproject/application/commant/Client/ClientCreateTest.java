package com.example.facturationproject.application.commant.Client;

import com.example.facturationproject.application.Auth.AuthService;

import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.domain.user.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientCreateTest {

    private ClientCreate clientCreate;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private AuthService authService;

    @BeforeEach
    public void setUp(){
        clientCreate = new ClientCreate(clientRepository,authService);
    }
    @Test
    void create() {
        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setCreateAt(LocalDateTime.now());


        Client client = new Client();
        client.setEmail("john.doe@example.com");
        client.setName("John");
        client.setLastName("Doe");
        client.setAddress("123 Street");
        client.setPhone("0612345678");


        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        clientCreate.create(client);
        Mockito.verify(clientRepository,Mockito.times(1)).save(client);

    }
}