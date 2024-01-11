package com.example.cars_backend.controller;

import com.example.cars_backend.dto.ErrorDto;
import com.example.cars_backend.exception.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(value = ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(ResourceNotFoundException exception){

        return ResponseEntity.badRequest().body(ErrorDto.builder()
                .message(exception.getMessage())
                        .time(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(ErrorDto.builder()
                .message(exception.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(",")))
                .time(LocalDateTime.now())
                .build());
    }

}
