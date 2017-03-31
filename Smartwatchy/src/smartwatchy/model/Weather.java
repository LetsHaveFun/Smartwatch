package model;

import java.util.Date;

public class Weather {	
	private String description;
	private int weatherID;
	private int morningTemp;
	private int dayTemp;
	private int nightTemp;
	private int eveningTemp;
	private Date dateTime;
	private Date updateTime;
	
	public Weather(String description, int weatherID, int morningTemp, int dayTemp, int nightTemp, int eveningTemp, long time)
	{
		this.description = description;
		this.weatherID = weatherID;
		this.morningTemp = morningTemp;
		this.dayTemp = dayTemp;
		this.nightTemp = nightTemp;
		this.eveningTemp = eveningTemp;
		dateTime = new Date(time);
		this.updateTime = new Date();
	}
	
	public String GetDescription()
	{
		return description;
	}
	
	public int GetMorningTemperature()
	{
		return morningTemp;
	}
	
	public int GetDayTemperature()
	{
		return dayTemp;
	}
	
	public int GetNightTemperature()
	{
		return nightTemp;
	}
	
	public int GetEveningTemperature()
	{
		return eveningTemp;
	}
	
	public Date GetDateTime()
	{
		return dateTime;
	}
	
	public Date GetUpdateTime()
	{
		return updateTime;
	}
	
	public int GetWeatherID()
	{
		return weatherID;
	}
}
