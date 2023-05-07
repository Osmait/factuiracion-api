package com.example.facturationproject.infrastructure.Dto.client;

import java.time.LocalDateTime;

public record ClientResponse(Long id, String name, String lastName, String Email, String phone, String address, LocalDateTime createAt) {
}
