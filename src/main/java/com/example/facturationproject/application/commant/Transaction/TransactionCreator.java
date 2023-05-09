package com.example.facturationproject.application.commant.Transaction;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.transaction.TransactionRepository;
import com.example.facturationproject.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCreator {
    private final TransactionRepository transactionRepository;
    private final AuthService authService;


    public void createTransaction(Transaction transaction){
        User user = authService.getIdCurrentLoggedUser();
        transaction.setUser(user);
        transactionRepository.save(transaction);
    }
}
