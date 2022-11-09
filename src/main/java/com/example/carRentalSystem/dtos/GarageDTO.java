package com.example.carRentalSystem.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GarageDTO {
	
	private Integer id;
	private String name;
	private String address;
	private Boolean isActive;
}
