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

	private Short weatherId;

	@PostConstruct
	public void init() {
		System.out.println("INIT");
		WeatherReturn cityWeatherByZIP = soap.getCityWeatherByZIP("90001");
		city = cityWeatherByZIP.getCity();
		temperature = cityWeatherByZIP.getTemperature();
		weatherId = cityWeatherByZIP.getWeatherID();
		System.out.println("Meteo : " + city);
		System.out.println("Meteo Temp : " + temperature);

	}

	public String convertFtoC() {
		double tempC = (Double.valueOf(temperature) - 32) / 1.8;
		DecimalFormat df = new DecimalFormat("#######.00");

		return df.format(tempC);

	}

	public String iconeMeteo() {
		String imageMeteo = "";

		switch (weatherId) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			imageMeteo = "/template-JSF-CDI-EJB/images/Sunny.png";
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			imageMeteo = "/template-JSF-CDI-EJB/images/Rain.png";
			break;
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
			imageMeteo = "/template-JSF-CDI-EJB/images/Cloudy_With_Dizzle.png";
			break;
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
			imageMeteo = "/template-JSF-CDI-EJB/images/Thunderstorms.png";
			break;
		}

		return imageMeteo;

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

	public Short getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(Short weatherId) {
		this.weatherId = weatherId;
	}

}
