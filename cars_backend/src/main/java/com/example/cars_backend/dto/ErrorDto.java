package com.example.cars_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDto {

    private String message;
    private LocalDateTime time;
}
