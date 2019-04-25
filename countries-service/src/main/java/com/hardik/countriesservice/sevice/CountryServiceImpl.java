package com.hardik.countriesservice.sevice;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.hardik.countriesservice.NotFoundException;
import com.hardik.countriesservice.modal.Countries;
import com.hardik.countriesservice.repository.CountriesRepository;

@Service
public class CountryServiceImpl implements CountryService{
	HashMap<Integer, Integer> timePort=new HashMap<>();
	
	@Autowired
	private CountriesRepository countriesRepository;
	
	@Autowired
	private Environment environment;

	@Override
	public Countries findById(String country) {
		Countries  countryBean = countriesRepository.findById(country).orElseThrow(() -> new NotFoundException("Country: "+country+" not found"));
		System.out.println(">>>>>>>>countryBean:::"+countryBean);
		int port= Integer.parseInt(environment.getProperty("local.server.port")) ;
		countryBean.setPort(port);
		int time=timePort.getOrDefault(port, 0);
		if (time>=0)
		{
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>>>>>>>countryBean1:::"+countryBean);
		return countryBean;
	}
}
