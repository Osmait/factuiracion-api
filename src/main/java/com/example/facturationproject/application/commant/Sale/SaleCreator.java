package com.example.facturationproject.application.commant.Sale;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.Sale.SaleRepository;
import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.client.ClientRepository;
import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.infrastructure.Dto.sale.SaleRequest;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleCreator {

    private final SaleRepository saleRepository;
    private final AuthService authService;
    private  final ClientRepository  clientRepository;




    public void create(SaleRequest saleRequest) {
        User user = authService.getIdCurrentLoggedUser();
        Client client = clientRepository.findById(saleRequest.getClientId()).orElseThrow( () -> new NotFondException("Client not found"));

        Sale sale =saleRequest.ToSale();

        sale.setClient(client);
        sale.setUser(user);
        saleRepository.save(sale);
    }
}
