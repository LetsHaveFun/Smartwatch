package controllers;

import java.util.Timer;
import java.util.TimerTask;

import model.Time;

public class TimeController implements Controller{
	private Time time;
	private Timer updateTimeTimer;
	
	// 0 = show time, 
	// 1 = increment seconds, 2 = minutes, 3 = hours
	private int timeMode;

	public TimeController ()
	{
		time = new Time();
		updateTimeTimer.schedule(TimeTick(), 1000);
	}
	
	private TimerTask TimeTick() {
		if (timeMode == 0)
		{
			time.Tick();
		}
		return null;
	}
	
	@Override
	public void buttonPressedA() {
		switch (timeMode)
		{
			case 0:
				timeMode = 1;
				break;
			case 1:
				time.IncrementSeconds();
				break;
			case 2:
				time.IncrementMinutes();
				break;
			case 3:
				time.IncrementHours();
				break;
		}		
	}

	@Override
	public void buttonPressedB() {
		switch (timeMode)
		{
			case 0:
				break;
			case 1:
				timeMode = 2;
			case 2:
				timeMode = 3;
				break;
			case 3:
				timeMode = 0;
				break;
		}
		
	}

}
