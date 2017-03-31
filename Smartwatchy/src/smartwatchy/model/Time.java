package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	private TimeUnit seconds;
	private TimeUnit minutes;
	private TimeUnit hours;
	
	private final SimpleDateFormat secondsTimeFormat = new SimpleDateFormat("s");
	private final SimpleDateFormat minutesTimeFormat = new SimpleDateFormat("m");
	private final SimpleDateFormat hoursTimeFormat = new SimpleDateFormat("H");
	
	public Time()
	{
		seconds = new TimeUnit(60);
		minutes = new TimeUnit(60);
		hours = new TimeUnit(24);
	}
	
	public Time(Date startTime)
	{
		int parsedSeconds = Integer.parseInt(secondsTimeFormat.format(startTime));
		int parsedMinutes = Integer.parseInt(minutesTimeFormat.format(startTime));
		int parsedHours = Integer.parseInt(hoursTimeFormat.format(startTime));
		
		seconds = new TimeUnit(60, parsedSeconds);
		minutes = new TimeUnit(60, parsedMinutes);
		hours = new TimeUnit(24, parsedHours);
	}
	
	public void Tick()
	{
		if (seconds.Increment())
		{
			if (minutes.Increment())
			{
				hours.Increment();
			}
		}
	}
	
	public int GetSeconds()
	{
		return seconds.getCounter();
	}
	
	public int GetMinutes()
	{
		return minutes.getCounter();
	}
	
	public int GetHours()
	{
		return hours.getCounter();
	}
	
	public void IncrementSeconds()
	{
		seconds.Increment();
	}
	
	public void IncrementMinutes()
	{
		minutes.Increment();
	}
	
	public void IncrementHours()
	{
		hours.Increment();
	}
}
