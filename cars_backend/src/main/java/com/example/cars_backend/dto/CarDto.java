package com.example.cars_backend.dto;

import com.example.cars_backend.entity.Brand;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


public record CarDto(
        Long id,
        @NotEmpty(message = "Car should have a brand") String brand,
        @NotEmpty(message = "Car should have a model")String model,
        @NotNull(message = "Car should have a year") Integer year
) {

}
