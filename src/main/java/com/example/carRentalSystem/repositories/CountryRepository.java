package com.example.carRentalSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carRentalSystem.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
