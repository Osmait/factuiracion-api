package com.example.facturationproject.application.commant.Sale;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.Sale.SaleRepository;
import com.example.facturationproject.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleCreator {

    private final SaleRepository saleRepository;
    private final AuthService authService;




    public void create(Sale sale) {
        User user = authService.getIdCurrentLoggedUser();
        sale.setUser(user);
        saleRepository.save(sale);
    }
}
