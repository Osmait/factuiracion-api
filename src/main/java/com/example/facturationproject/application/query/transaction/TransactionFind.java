package com.example.facturationproject.application.query.transaction;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.transaction.TransactionRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionFind {


    private final TransactionRepository transactionRepository;
    private final AuthService authService;

    public List<Transaction> findAll(Long id){

        Long  userId = authService.getIdCurrentLoggedUser().getId();
        return transactionRepository.findAllBySaleIdAndUserId(id,userId).orElseThrow(()->new NotFondException("transaction not found"));
    }
}
