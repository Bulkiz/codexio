package com.example.carRentalSystem.services;

import java.util.List;

import com.example.carRentalSystem.dtos.CarDTO;

public interface CarService {
	
	public List<CarDTO> findAll();

	public CarDTO saveCar(CarDTO carDTO);

	public CarDTO updateCar(CarDTO carDTO);

	public List<CarDTO> findAvailable();

	public String rentCar(Integer id);


}
