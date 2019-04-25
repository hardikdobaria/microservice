package com.hardik.countriesservice.resource;


import java.security.Principal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.countriesservice.modal.Countries;
import com.hardik.countriesservice.sevice.CountryService;

@RestController
@RequestMapping("country")
public class CountriesServiceController {
	HashMap<Integer, Integer> timePort=new HashMap<>();
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/{country}")
	public Countries getCountry(@PathVariable String country) {
		Countries  countryBean = countryService.findById(country);
		return countryBean;		
	}		
	@GetMapping("/time/{time}")
	public int getTime(@PathVariable int time) {
		int port=Integer.parseInt(environment.getProperty("local.server.port")) ;
		timePort.put(port, time);
		return time;
	}		
	
	@GetMapping("/helloWorld")
	public ResponseEntity<?> demo(Principal p){
	
		System.out.println("principal :: "+p);
		return new ResponseEntity<>("helloWorld",HttpStatus.OK);
	}
}
