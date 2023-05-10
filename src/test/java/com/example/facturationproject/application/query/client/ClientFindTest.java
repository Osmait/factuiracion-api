package com.example.facturationproject.application.query.client;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.infrastructure.Dto.client.ClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientFindTest {

    private ClientFind clientFind;

    @Mock
    private ClientRepository  clientRepository;

    @Mock
    private  AuthService authService;

    @BeforeEach
    public void setUp(){
        clientFind = new ClientFind(clientRepository,authService);
    }

    @Test
    void findAll() {
        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setCreateAt(LocalDateTime.now());


        Client  client = new Client();
        client.setEmail("john.doe@example.com");
        client.setName("John");
        client.setLastName("Doe");
        client.setAddress("123 Street");
        client.setPhone("0612345678");
        client.setUser(user);

        Client  client2 = new Client();
        client.setEmail("john.doe2@example.com");
        client.setName("John2");
        client.setLastName("Doe2");
        client.setAddress("123232 Street");
        client.setPhone("061234567228");
        client.setUser(user);


        List<Client> clients = new ArrayList<>();
        clients.add(client);
        clients.add(client2);

        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        Mockito.when(clientRepository.findAllByUserIdAndDeletedFalse(user.getId())).thenReturn(Optional.of(clients));
        List<ClientResponse> clientResponses = clientFind.findAll();
        Mockito.verify(clientRepository,Mockito.times(1)).findAllByUserIdAndDeletedFalse(user.getId());


        assertEquals(2,clientResponses.size());
        assertEquals(client.getEmail(),clientResponses.get(0).Email());
        assertEquals(client.getName(),clientResponses.get(0).name());
        assertEquals(client.getLastName(),clientResponses.get(0).lastName());
        assertEquals(client.getAddress(),clientResponses.get(0).address());
        assertEquals(client.getPhone(),clientResponses.get(0).phone());






    }
}