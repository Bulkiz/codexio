package com.example.carRentalSystem.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.carRentalSystem.dtos.CountryDTO;
import com.example.carRentalSystem.entities.Country;

@Component
public class CountryMapper implements ModelMapper<CountryDTO, Country>{

	@Override
	public CountryDTO toDto(Country entity) {
		return CountryDTO.builder().
				id(entity.getId()).
				name(entity.getName()).
				isActive(entity.getIsActive()).
				build();
	}

	@Override
	public Country toEntity(CountryDTO dto) {
		return Country.builder().
				id(dto.getId()).
				name(dto.getName()).
				isActive(dto.getIsActive()).
				build();	
	}

	@Override
	public List<CountryDTO> allToDtos(List<Country> entities) {
		return entities.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}

	@Override
	public List<Country> allToEntities(List<CountryDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

}
