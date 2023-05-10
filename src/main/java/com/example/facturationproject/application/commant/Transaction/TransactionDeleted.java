package com.example.facturationproject.application.commant.Transaction;


import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.transaction.TransactionRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionDeleted {

    private final TransactionRepository transactionRepository;

    public void deleted( Long id){
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()-> new NotFondException("transaction Not Found"));
        transaction.setDeleted(true);
        transactionRepository.save(transaction);
    }
}
