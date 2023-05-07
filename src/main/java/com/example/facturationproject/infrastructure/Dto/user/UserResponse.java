package com.example.facturationproject.infrastructure.Dto.user;

import java.time.LocalDateTime;

public record UserResponse(String name , String lastName, String email , LocalDateTime CreateAt) {
}
