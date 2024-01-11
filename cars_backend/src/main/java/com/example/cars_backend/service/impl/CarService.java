package com.example.cars_backend.service.impl;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.entity.Brand;
import com.example.cars_backend.entity.Car;
import com.example.cars_backend.exception.ResourceNotFoundException;
import com.example.cars_backend.mapper.CarMapper;
import com.example.cars_backend.repository.BrandRepository;
import com.example.cars_backend.repository.CarRepository;
import com.example.cars_backend.service.ICarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {

    private final CarRepository carRepository;
    private final   BrandRepository brandRepository;
    private final  CarMapper carMapper;

    public CarService(CarRepository carRepository, BrandRepository brandRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.carMapper = carMapper;
    }


    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = cars.stream().map((car -> carMapper.fromCarToCarDto(car))).collect(Collectors.toList());

        return carDtos;
    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = carRepository.getReferenceById(id);
        if (car == null) {
            throw new ResourceNotFoundException("Car is not existing with the following id :" + id);
        }

        CarDto carDto = carMapper.fromCarToCarDto(car);

        return carDto;
    }



    @Override
    public void deleteCar(Long id) {

        Car car = carRepository.getReferenceById(id);

        if (car == null) {
            throw new ResourceNotFoundException("Car is not existing with the following id :" + id);
        }

        carRepository.delete(car);

    }


    @Override
    public CarDto save(CarDto carDto) {
        Car car = carMapper.fromCarDtoToCar(carDto);
        Brand brand = brandRepository.findByName(carDto.brand()).orElse(new Brand(carDto.brand()));
        car.setBrand(brand);

        carRepository.save(car);

        return carMapper.fromCarToCarDto(car);
    }
}
