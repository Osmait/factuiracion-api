package com.example.facturationproject.application.query.transaction;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.transaction.TransactionRepository;
import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.infrastructure.Dto.transaction.TransactionResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionFind {


    private final TransactionRepository transactionRepository;
    private final AuthService authService;

    public List<TransactionResponse> findAll(Long id){

        User user = authService.getIdCurrentLoggedUser();
        Long userId = user.getId();


       List<Transaction> transactions =  transactionRepository.findAllBySaleIdAndUserId(id,userId)
               .orElseThrow(()->new NotFondException("transaction not found"));

       return transactions.stream().map( transaction -> new TransactionResponse(
               transaction.getId(),
               transaction.getAmount(),
               transaction.getType(),
               transaction.getDescription(),
               transaction.getCreatedAt()
       )).toList();
    }
}
