package com.example.facturationproject.application.commant.Transaction;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.Sale.SaleRepository;
import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.transaction.TransactionRepository;
import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.infrastructure.Dto.transaction.TransactionRequest;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCreator {
    private final TransactionRepository transactionRepository;
    private final SaleRepository saleRepository;
    private final AuthService authService;



    public void createTransaction(TransactionRequest transactionRequest){
        User user = authService.getIdCurrentLoggedUser();
        Long saleId =transactionRequest.getSaleId();
        saleRepository.findById(saleId).orElseThrow(()->new NotFondException("sale not found"));
        Transaction transaction = transactionRequest.toTransaction();
        transaction.setUser(user);
        transactionRepository.save(transaction);
    }
}
