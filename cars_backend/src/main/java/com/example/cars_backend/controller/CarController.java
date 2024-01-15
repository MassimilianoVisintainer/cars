package com.example.cars_backend.controller;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.entity.Car;
import com.example.cars_backend.service.impl.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/car")
public class CarController {

  private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("id") Long id){
      CarDto car = carService.getCarById(id);

      return ResponseEntity.ok(car);
  }

  @GetMapping
    public ResponseEntity<List<CarDto>> findAll() {
        List<CarDto> cars = carService.findAll();

        return ResponseEntity.ok(cars);
  }

  @PostMapping()
    public ResponseEntity<CarDto> save(@Validated @RequestBody CarDto carDto) {
      CarDto car = carService.save(carDto);

      return  new ResponseEntity<>(car, HttpStatus.CREATED);
  }


  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteCar(@PathVariable("id") Long id){
      carService.deleteCar(id);

      return ResponseEntity.ok("Car has been successfully deleted");
  }
}
