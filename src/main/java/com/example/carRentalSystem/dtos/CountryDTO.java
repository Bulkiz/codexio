package com.example.carRentalSystem.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CountryDTO {
	
	private Integer id;
	private String name;
	private Boolean isActive;

}
