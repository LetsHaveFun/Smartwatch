package model;

public class Weather {
	
	public int WeatherID;
	public int temperature;
	
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
