package com.example.facturationproject.application.query.sale;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.Sale.SaleRepository;
import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.infrastructure.Dto.sale.SaleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SaleFindTest {
    private SaleFind saleFind;

    @Mock
    private  SaleRepository saleRepository;

    @Mock
    private AuthService authService;


    @BeforeEach
    public void setUp(){
       saleFind = new SaleFind(saleRepository,authService);
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

        Client client = new Client();
        client.setId(id);
        client.setEmail("john.doe@example.com");
        client.setName("John");
        client.setLastName("Doe");
        client.setAddress("123 Street");
        client.setPhone("0612345678");
        client.setUser(user);


        Sale sale = new Sale();
        sale.setId(1L);
        sale.setPrice(100d);
        sale.setDescription("buy something");
        sale.setUser(user);
        sale.setClient(client);
        sale.setCreateAt(LocalDateTime.now());

        Sale sale2 = new Sale();
        sale2.setId(1L);
        sale2.setPrice(200d);
        sale2.setDescription("buy other something");
        sale2.setUser(user);
        sale2.setClient(client);
        sale2.setCreateAt(LocalDateTime.now());

        List<Sale> saleList = List.of(sale,sale2);
        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);

        Mockito.when(saleRepository.findAllByClientIdAndUserId(user.getId(), client.getId())).thenReturn(Optional.of(saleList));
        List<SaleResponse> saleResponses = saleFind.findAll(client.getId());

        Mockito.verify(saleRepository,Mockito.times(1)).findAllByClientIdAndUserId(user.getId(), client.getId());

        assertEquals(saleResponses.size(),2);
        assertEquals(saleResponses.get(0).description(),sale.getDescription());
        assertEquals(saleResponses.get(0).price(),sale.getPrice());



    }
}