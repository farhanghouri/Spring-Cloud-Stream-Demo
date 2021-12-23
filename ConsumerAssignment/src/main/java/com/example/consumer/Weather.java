package com.example.consumer;

public class Weather {
	  private String city;
	  private String country;
	  private String temperature;
	  private String wind;
	  private String humidity;
	  
	  
	public Weather() {
		city = "Lhr";
		country = "PK";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	@Override
	public String toString() {
		return "Weather [city=" + city + ", country=" + country + ", temperature=" + temperature + ", wind=" + wind
				+ ", humidity=" + humidity + "]";
	}
}
