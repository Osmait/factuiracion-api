package com.example.facturationproject.infrastructure.controller;

import com.example.facturationproject.application.commant.Sale.SaleCreator;
import com.example.facturationproject.application.query.sale.SaleFind;
import com.example.facturationproject.infrastructure.Dto.sale.SaleRequest;
import com.example.facturationproject.infrastructure.Dto.sale.SaleResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.BadRequestException;
import com.example.facturationproject.infrastructure.utils.ValidateErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleFind saleFind;
    private final SaleCreator  saleCreator;
    private final ValidateErrors validateErrors;


    @GetMapping("/{id}")
    public List<SaleResponse> getAllSales(@PathVariable Long id) {

        return saleFind.findAll(id);
    }


    @PostMapping
    public ResponseEntity<String> createSAle(@Validated @RequestBody SaleRequest saleRequest, BindingResult result){
        if(result.hasErrors()) {

            throw new BadRequestException(validateErrors.ValidFields(result));
        }
        saleCreator.create(saleRequest);
        return ResponseEntity.ok("sale created");
    }


}
