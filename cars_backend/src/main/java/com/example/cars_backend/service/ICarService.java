package com.example.cars_backend.service;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.entity.Car;

import java.util.List;

public interface ICarService {

    List<CarDto> findAll();
    CarDto getCarById(Long id);

    void deleteCar(Long id);

    CarDto save(CarDto carDto);

    CarDto updateCar(Long id, CarDto carDto);
}
