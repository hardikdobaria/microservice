package com.hardik.countriesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardik.countriesservice.modal.Countries;

public interface CountriesRepository extends JpaRepository <Countries,String>{

}
