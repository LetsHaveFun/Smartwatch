package controllers;

public class TimeUnit {
	private int counter;
	private int maxCount;
	
	public TimeUnit(int maxCount)
	{
		counter = 0;
		this.maxCount = maxCount;
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public boolean Increment()
	{
		if (counter + 1 == maxCount)
		{
			counter = 0;
			return true;
		}
		else
		{			
			counter += 1;
			return false;
		}
	}
}
