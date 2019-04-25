package com.hardik.capitalsservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hardik.capitalsservice.model.CapitalsBean;

@FeignClient(name="country-service")
public interface CapitalsServiceProxy {
	@GetMapping("/country/{country}")
	public CapitalsBean getCountry(@PathVariable("country") String country);
}
