package com.example.carRentalSystem.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.carRentalSystem.dtos.CarDTO;
import com.example.carRentalSystem.entities.Car;
import com.example.carRentalSystem.mappers.CarMapper;
import com.example.carRentalSystem.mappers.GarageMapper;
import com.example.carRentalSystem.repositories.CarRepository;
import com.example.carRentalSystem.repositories.GarageRepository;
import com.example.carRentalSystem.services.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	private CarRepository carRepository;
	private CarMapper carMapper;
	private GarageRepository garageRepository;
	
	public CarServiceImpl(CarRepository carRepository, GarageRepository garageRepository, CarMapper carMapper, GarageMapper garageMapper) {
		this.carRepository = carRepository;
		this.carMapper = carMapper;
		this.garageRepository = garageRepository;
	}
	
	@Transactional
	@Override
	public List<CarDTO> findAll() {
		
		return carMapper.allToDtos(carRepository.findAll());
	}
	
	@Transactional
	@Override
	public CarDTO saveCar(CarDTO carDTO) {
		Car car = carMapper.toEntity(carDTO);
		garageRepository.save(car.getGarage());
		carRepository.save(car);
		return carMapper.toDto(car);
	}
	
	@Transactional
	@Override
	public CarDTO updateCar(CarDTO carDTO) {
		return saveCar(carDTO);
	}
	
	@Transactional
	@Override
	public List<CarDTO> findAvailable() {
		List<Car> availableCars = new ArrayList<>();
		for(Car car: carRepository.findAll()) {
			if (car.getIsAvailable()) {
				availableCars.add(car);
			}
		}
		return carMapper.allToDtos(availableCars);
	}
	
	@Transactional
	@Override
	public String rentCar(Integer id) {
		Car car = carRepository.findById(id).get();
		if (!car.getIsAvailable()) {
			return "This " + car.getMake() + " is not available at the moment!";
		}
		
		return "You have successfully rented " + car.getMake() + " " + car.getModel() + "!";
	}
	
	
}
