package com.example.carRentalSystem.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.carRentalSystem.dtos.CarDTO;
import com.example.carRentalSystem.entities.Car;

@Component
public class CarMapper implements ModelMapper<CarDTO, Car>{
	
	private CountryMapper countryMapper;
	private GarageMapper garageMapper;
	
	@Autowired
	public CarMapper(GarageMapper garageMapper, CountryMapper countryMapper){
		this.countryMapper = countryMapper;
		this.garageMapper = garageMapper;
		
	}
	@Override
	public CarDTO toDto(Car entity) {
		return CarDTO.builder().
				id(entity.getId()).
				make(entity.getMake()).
				model(entity.getModel()).
				year(entity.getYear()).
				carType(entity.getCarType()).
				doors(entity.getDoors()).
				isAvailable(entity.getIsAvailable()).
				country(countryMapper.toDto(entity.getCountry())).
				garage(garageMapper.toDto(entity.getGarage())).
				build();
	}

	@Override
	public Car toEntity(CarDTO dto) {
		return Car.builder().
				id(dto.getId()).
				make(dto.getMake()).
				model(dto.getModel()).
				year(dto.getYear()).
				carType(dto.getCarType()).
				doors(dto.getDoors()).
				isAvailable(dto.getIsAvailable()).
				country(countryMapper.toEntity(dto.getCountry())).
				garage(garageMapper.toEntity(dto.getGarage())).
				build();
	}

	@Override
	public List<CarDTO> allToDtos(List<Car> entities) {
		return entities.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}

	@Override
	public List<Car> allToEntities(List<CarDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}
	
	

}
