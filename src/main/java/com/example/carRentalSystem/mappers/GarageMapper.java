package com.example.carRentalSystem.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.carRentalSystem.dtos.GarageDTO;
import com.example.carRentalSystem.entities.Garage;

@Component
public class GarageMapper implements ModelMapper<GarageDTO, Garage>{

	@Override
	public GarageDTO toDto(Garage entity) {
		return GarageDTO.builder().
				id(entity.getId()).
				name(entity.getName()).
				address(entity.getAddress()).
				isActive(entity.getIsActive()).
				build();
	}

	@Override
	public Garage toEntity(GarageDTO dto) {
		return Garage.builder().
				id(dto.getId()).
				name(dto.getName()).
				address(dto.getAddress()).
				isActive(dto.getIsActive()).
				build();
	}

	@Override
	public List<GarageDTO> allToDtos(List<Garage> entities) {
		return entities.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}

	@Override
	public List<Garage> allToEntities(List<GarageDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

}
