package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import model.Time;

public class TimeController implements Controller{
	private Time time;
	private Timer timeTimer;
	private TimeTask timeTask;
	private List<TimeListener> listeners = new ArrayList<TimeListener>();
	
	// 0 = show time, 
	// 1 = increment seconds, 2 = minutes, 3 = hours
	private int timeMode;

	public TimeController ()
	{
		time = new Time(new Date());
		timeMode = 0;
		StartTimer();
	}
	
	public Time GetTime()
	{
		return time;
	}
	
	public int GetMode()
	{
		return timeMode;
	}
	
	public void addListener(TimeListener toAdd) {
		listeners.add(toAdd);
    }
	
	private void PauseTimer()
	{
		if (timeTimer != null)
		{
			timeTimer.cancel();
		}
	}
	
	private void StartTimer()
	{
		timeTask = new TimeTask(listeners);
		timeTimer = new Timer(true);
		timeTimer.scheduleAtFixedRate(timeTask, 0, 1000);
	}
	
	private void NotifyTimeChanged()
	{
        for (TimeListener tl : listeners)
            tl.TimeChanged();
	}
	
	@Override
	public void buttonPressedA() {
		PauseTimer();
		switch (timeMode)
		{
			case 0:
				timeMode = 1;
				break;
			case 1:
				time.IncrementSeconds();
				NotifyTimeChanged();
				break;
			case 2:
				time.IncrementMinutes();
				NotifyTimeChanged();
				break;
			case 3:
				time.IncrementHours();
				NotifyTimeChanged();
				break;
		}		
	}

	@Override
	public void buttonPressedB() {
		switch (timeMode)
		{
			case 1:
				timeMode = 2;
				break;
			case 2:
				timeMode = 3;
				break;
			case 3:
				timeMode = 0;
				StartTimer();
				break;
		}		
	}
}
