package com.example.cars_backend.mapper;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CarMapper {

    @Mapping(target="year", source="yearOfManufacture")
    @Mapping(target = "brand", source = "brand.name")
    CarDto fromCarToCarDto(Car car);

    @Mapping(target="yearOfManufacture", source="year")
    @Mapping(target = "brand",ignore = true)
    Car fromCarDtoToCar(CarDto carDto);
}
