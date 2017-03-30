package model;

public class Weather {	
	private int WeatherID;
	private int temperature;
	
	public Weather(int WeatherIDTMP, int temperaturetmp)
	{
		WeatherID = WeatherIDTMP;
		temperature = temperaturetmp;
	}
	
	public Weather GetWeather()
	{
		return this;
	}
	public int GetWeatherWeatherID()
	{
		return WeatherID;
	}
	public int GetWeatherTemperature()
	{
		return temperature;
	}

}
