package com.example.facturationproject.infrastructure.Dto.sale;

import java.time.LocalDateTime;

public record SaleResponse(Long id, String description, Double price, LocalDateTime createdAt) {
}
