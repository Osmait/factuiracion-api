package com.example.facturationproject.application.query.sale;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.Sale.SaleRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleFind {

    private final SaleRepository saleRepository;
    private final AuthService authService;


    public List<Sale> findAll(Long id) {
        Long  userId = authService.getIdCurrentLoggedUser().getId();
        return saleRepository.findAllByClientIdAndUserId(id, userId).orElseThrow( () -> new NotFondException("Not Found Sales"));
    }

}
