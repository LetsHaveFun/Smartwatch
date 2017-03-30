package model;

public class Time {
	private TimeUnit seconds;
	private TimeUnit minutes;
	private TimeUnit hours;
	
	public Time()
	{
		seconds = new TimeUnit(60);
		minutes = new TimeUnit(60);
		hours = new TimeUnit(24);
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
