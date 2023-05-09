package com.example.facturationproject.infrastructure.Dto.transaction;

import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.transaction.TransactionType;
import lombok.Data;

@Data
public class TransactionRequest {

    private Double amount;

    private TransactionType type;

    private String description;

    private Long saleId;



    public Transaction  toTransaction(){
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setDescription(description);
        return transaction;
    }



}
