package com.example.carRentalSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carRentalSystem.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

}
