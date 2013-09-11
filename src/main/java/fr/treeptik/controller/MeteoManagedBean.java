package fr.treeptik.controller;

import java.text.DecimalFormat;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.treeptik.wsimport.WeatherReturn;
import fr.treeptik.wsimport.WeatherSoap;

@ManagedBean(name = "MeteoMB")
@SessionScoped
public class MeteoManagedBean {

	@Inject
	WeatherSoap soap;

	private String city;

	private String temperature;

	@PostConstruct
	public void init() {
		System.out.println("INIT");
		WeatherReturn cityWeatherByZIP = soap.getCityWeatherByZIP("90001");
		city = cityWeatherByZIP.getCity();
		temperature = cityWeatherByZIP.getTemperature();
		System.out.println("Meteo : " + city);
		System.out.println("Meteo Temp : " + temperature);

	}

	public String convertFtoC() {
		double tempC = (Double.valueOf(temperature) - 32) / 1.8;
		DecimalFormat df = new DecimalFormat("#######.00");

		return df.format(tempC);

	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}
