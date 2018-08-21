package com.countries.gc;

public class Country {
	private String countryName;
	private String capitalCity;

	public Country(String countryName, String capitalCity) {
		super();
		this.countryName = countryName;
		this.capitalCity = capitalCity;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}
	
	public String getCapitalCity(String capitalCity) {
		return capitalCity;
	}
	
	@Override
	public String toString() {
		return countryName + "," + capitalCity;
	}
}
