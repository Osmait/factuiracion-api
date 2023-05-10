package com.example.facturationproject.application.commant.Sale;

import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.Sale.SaleRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleDeleted {

    private final SaleRepository saleRepository;


    public void deleted(Long id){
        Sale  sale = saleRepository.findById(id).orElseThrow(()-> new NotFondException("Not Found Sale"));
        sale.setDeleted(true);
        saleRepository.save(sale);
    }




}
