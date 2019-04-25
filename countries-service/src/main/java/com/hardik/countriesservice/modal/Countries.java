package com.hardik.countriesservice.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Countries {
	
	
	@Id
	private String country;
	
	@Column 
	@NotNull
	private String name;

	@Column 
	@NotNull
	private String currency;
	
	@Column 
	@NotNull
	private String currencysimbol;

	@Column 
	@NotNull
	private String language;
	
	@Column 
	@NotNull
	private String capital;
	
	@Transient
	int port;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencysimbol() {
		return currencysimbol;
	}

	public void setCurrencysimbol(String currencysimbol) {
		this.currencysimbol = currencysimbol;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Countries [country=" + country + ", name=" + name + ", currency=" + currency + ", currencysimbol="
				+ currencysimbol + ", language=" + language + ", capital=" + capital + ", port=" + port + "]";
	}

}
