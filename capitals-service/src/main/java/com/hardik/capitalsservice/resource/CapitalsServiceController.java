package com.hardik.capitalsservice.resource;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.capitalsservice.model.CapitalsBean;
import com.hardik.capitalsservice.proxy.CapitalsServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("capital")
public class CapitalsServiceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CapitalsServiceProxy proxy;
	
	HashMap<Integer, Integer> htPuerto=new HashMap<>();	
	
	public CapitalsBean fallback(String s) {
	    return new CapitalsBean();
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/{country}")
	public CapitalsBean getCountry(@PathVariable String country) {
		System.out.println(country);
		try {
		CapitalsBean response = proxy.getCountry(country);
		System.out.println("##"+response);
		htPuerto.put(response.getPort(), htPuerto.getOrDefault(response.getPort(),0)+1);
		logger.info("CapitalesService -> {} ",response);
		return response;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/puertos")
	public String getCountryUsingFeign() {
		StringBuffer response=new StringBuffer();
		htPuerto.forEach((k,v) -> response.append(" Puerto: "+k+" Valor: "+v));
		return response.toString();
	}
	
	
}
