package com.example.facturationproject.infrastructure.controller;

import com.example.facturationproject.application.commant.Transaction.TransactionCreator;
import com.example.facturationproject.application.commant.Transaction.TransactionDeleted;
import com.example.facturationproject.application.query.transaction.TransactionFind;
import com.example.facturationproject.infrastructure.Dto.transaction.TransactionRequest;
import com.example.facturationproject.infrastructure.Dto.transaction.TransactionResponse;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.BadRequestException;
import com.example.facturationproject.infrastructure.utils.ValidateErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionCreator transactionCreator;
    private final TransactionFind transactionFind;
    private final TransactionDeleted transactionDeleted;
    private final ValidateErrors validateErrors;

    @PostMapping
    public ResponseEntity<String> createTransaction(@Validated @RequestBody TransactionRequest transactionRequest, BindingResult result){
        if(result.hasErrors()) {
            throw new BadRequestException(validateErrors.ValidFields(result));
        }

        transactionCreator.createTransaction(transactionRequest);
        return ResponseEntity.ok("Transaction Created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionResponse>> getTransaction(@PathVariable("id") Long id){
       List<TransactionResponse> transactionResponses = transactionFind.findAll(id);
       return new ResponseEntity<>(transactionResponses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long id){
        transactionDeleted.deleted(id);
        return ResponseEntity.ok("Transaction Deleted");

    }

}
