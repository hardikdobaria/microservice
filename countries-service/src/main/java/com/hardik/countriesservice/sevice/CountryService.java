package com.hardik.countriesservice.sevice;

import com.hardik.countriesservice.modal.Countries;

public interface CountryService {

	Countries findById(String country);
	
}
