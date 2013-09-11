package fr.treeptik.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	private List<String> zipCode = new ArrayList<>();

	@PostConstruct
	public void init() {
		System.out.println("INIT");
		initListZipCode();
		Random random = new Random();
		String zip = zipCode.get(random.nextInt(zipCode.size()));
		WeatherReturn cityWeatherByZIP = soap.getCityWeatherByZIP(zip);
		city = cityWeatherByZIP.getCity();
		temperature = cityWeatherByZIP.getTemperature();
		weatherId = cityWeatherByZIP.getWeatherID();
		System.out.println("Zip :" + zip);
		System.out.println("Meteo : " + city);
		System.out.println("Meteo Temp : " + temperature);

	}

	public void changeVille() {
		initListZipCode();
		Random random = new Random();
		String zip = zipCode.get(random.nextInt(zipCode.size()));
		WeatherReturn cityWeatherByZIP = soap.getCityWeatherByZIP(zip);
		city = cityWeatherByZIP.getCity();
		temperature = cityWeatherByZIP.getTemperature();
		weatherId = cityWeatherByZIP.getWeatherID();
		System.out.println("Zip :" + zip);
		System.out.println("Meteo : " + city);
		System.out.println("Meteo Temp : " + temperature);
	}

	public void initListZipCode() {

		zipCode = new ArrayList<>();
		zipCode.add("90001");
		zipCode.add("86023");
		zipCode.add("94102");
		zipCode.add("80201");
		zipCode.add("06102");
		zipCode.add("32931");
		zipCode.add("30301");
		zipCode.add("96721");
		zipCode.add("61701");
		zipCode.add("66103");
		zipCode.add("21401");
		zipCode.add("01002");
		zipCode.add("89702");
		zipCode.add("08401");
		zipCode.add("12201");
		zipCode.add("17101");
		zipCode.add("79101");
		zipCode.add("22301");
		zipCode.add("98502");
		zipCode.add("10001");

	}

	public String convertFtoC() {
		double tempC = (Double.valueOf(temperature) - 32) / 1.8;
		DecimalFormat df = new DecimalFormat("#######.00");
		// System.out.println(df.format(tempC));
		return df.format(tempC);

	}

	public String iconeMeteo() {
		String imageMeteo = "";

		switch (weatherId) {
		case 1:
			imageMeteo = "/template-JSF-CDI-EJB/images/Thunderstorms.png";
			break;
		case 2:
		case 3:
			imageMeteo = "/template-JSF-CDI-EJB/images/Mostly_Cloudy.png";
			break;
		case 4:
			imageMeteo = "/template-JSF-CDI-EJB/images/Sunny.png";
			break;
		case 5:
			imageMeteo = "/template-JSF-CDI-EJB/images/Rain.png";
			break;
		case 6:
			imageMeteo = "/template-JSF-CDI-EJB/images/Cloudy_With_Dizzle.png";
			break;
		case 7:
		case 8:
		case 9:
		case 10:
			imageMeteo = "/template-JSF-CDI-EJB/images/Mostly_Sunny.png";
			break;
		case 11:
			imageMeteo = "/template-JSF-CDI-EJB/images/Clear.png";
			break;
		case 12:
		case 13:
		case 14:
			imageMeteo = "/template-JSF-CDI-EJB/images/Cloudy.png";
			break;
		case 15:
			imageMeteo = "/template-JSF-CDI-EJB/images/Cloudy_With_Dizzle.png";
			break;
		case 16:
		case 17:
		case 18:
			imageMeteo = "/template-JSF-CDI-EJB/images/Fog.png";
			break;
		case 19:
		case 20:
			imageMeteo = "/template-JSF-CDI-EJB/images/Fluries.png";
			break;
		case 21:
		case 26:
		case 27:
		case 28:
		case 29:
			imageMeteo = "/template-JSF-CDI-EJB/images/Snow.png";
			break;
		case 32:
		case 33:
		case 34:
		case 35:
		case 36:
		case 37:
			imageMeteo = "/template-JSF-CDI-EJB/images/Rain.png";
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

	public List<String> getZipCode() {
		return zipCode;
	}

	public void setZipCode(List<String> zipCode) {
		this.zipCode = zipCode;
	}

}
