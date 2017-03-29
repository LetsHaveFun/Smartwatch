package model;

public class Weather {
	
	public String weather;
	public int temperature;
	
	public Weather(String weathertmp, int temperaturetmp)
	{
		weather = weathertmp;
		temperature = temperaturetmp;
	}
	
	public Weather GetWeather()
	{
		return this;
	}

}
