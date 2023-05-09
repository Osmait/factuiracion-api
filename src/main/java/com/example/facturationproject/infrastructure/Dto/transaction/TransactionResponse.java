package com.example.facturationproject.infrastructure.Dto.transaction;

import com.example.facturationproject.domain.transaction.TransactionType;

import java.time.LocalDateTime;

public record TransactionResponse(Long id ,
                                  Double amount ,
                                  TransactionType type ,
                                  String description ,
                                  LocalDateTime createdAt) {
}
