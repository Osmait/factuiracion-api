package com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions;

import java.time.LocalDateTime;

public record ApiError(String message, int httpStatus, LocalDateTime localDateTime) {
}