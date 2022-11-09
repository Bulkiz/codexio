package com.example.carRentalSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.carRentalSystem.enums.CarType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "type", columnDefinition = "int2")
	private CarType carType;
	
	@Column(name = "doors")
	private Integer doors;
	
	@Column(name = "is_available")
	private Boolean isAvailable;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "garage_id", referencedColumnName = "id")
	private Garage garage;
	
	
	
	
	
}
