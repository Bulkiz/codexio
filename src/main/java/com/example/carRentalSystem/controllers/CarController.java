package com.example.carRentalSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carRentalSystem.dtos.CarDTO;
import com.example.carRentalSystem.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	CarService carService;
	
	
	@GetMapping
	public ResponseEntity<List<CarDTO>> getAllCars(){
		return ResponseEntity.ok(carService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO) {
		return new ResponseEntity<>(carService.saveCar(carDTO), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDTO) {
		return  ResponseEntity.ok(carService.updateCar(carDTO));
	}
	
	@GetMapping("/areAvailable") 
	public ResponseEntity<List<CarDTO>> getAvailableCars(){
		return ResponseEntity.ok(carService.findAvailable());
	}
	
	@GetMapping("/rent/{id}")
	public String rentCar(@PathVariable("id") Integer id) {
		
		return carService.rentCar(id);
	}
}
