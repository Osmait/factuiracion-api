package com.example.facturationproject.application.query.sale;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.Sale.SaleRepository;
import com.example.facturationproject.infrastructure.Dto.sale.SaleResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleFind {

    private final SaleRepository saleRepository;
    private final AuthService authService;


    public List<SaleResponse> findAll(Long id) {
        Long  userId = authService.getIdCurrentLoggedUser().getId();

        List<Sale> sales = saleRepository.findAllByClientIdAndUserId(id, userId)
                .orElseThrow( () -> new NotFondException("Not Found Sales"));

        return sales.stream().map((sale -> new SaleResponse(
               sale.getId(),
               sale.getDescription(),
               sale.getPrice(),
               sale.getCreateAt())
        )).toList();

    }

}
