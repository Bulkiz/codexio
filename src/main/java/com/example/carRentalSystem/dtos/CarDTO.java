package com.example.carRentalSystem.dtos;

import com.example.carRentalSystem.enums.CarType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarDTO {
	
	private Integer id;
	private String make;
	private String model;
	private String year;
	private CarType carType;
	private Integer doors;
	private Boolean isAvailable;
	private CountryDTO country;
	private GarageDTO garage;
}
