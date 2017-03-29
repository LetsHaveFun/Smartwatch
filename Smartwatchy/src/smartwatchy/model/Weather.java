package model;

public class Weather {
	
	public String description;
	public int temperature;
	
	public Weather(String weathertmp, int temperaturetmp)
	{
		description = weathertmp;
		temperature = temperaturetmp;
	}
	
	public Weather GetWeather()
	{
		return this;
	}

}
