package com.example.carRentalSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carRentalSystem.entities.Garage;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Integer>{

}
