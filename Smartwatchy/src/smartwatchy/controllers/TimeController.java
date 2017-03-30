package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import model.Time;

public class TimeController implements Controller{
	private Time time;
	private Timer timeTimer;
	private TimeTask timeTask;
	private List<TimeListener> timeListeners = new ArrayList<TimeListener>();
	private List<ButtonListener> buttonListeners = new ArrayList<ButtonListener>();
	
	// 0 = show time, 
	// 1 = increment seconds, 2 = minutes, 3 = hours
	private int timeMode;

	public TimeController ()
	{
		time = new Time();
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
	
	public void addTimeListener(TimeListener toAdd) {
		timeListeners.add(toAdd);
    }
	
	public void addButtonListener(ButtonListener toAdd) {
		buttonListeners.add(toAdd);
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
		timeTask = new TimeTask(this, timeListeners);
		timeTimer = new Timer(true);
		timeTimer.scheduleAtFixedRate(timeTask, 0, 1000);
	}
	
	private void NotifyTimeChanged()
	{
		// Notify everybody that may be interested.
        for (TimeListener tl : timeListeners)
            tl.TimeChanged();
	}
	
	private void RequestButtonChange(int button, String newText)
	{
		// Notify everybody that may be interested.
        for (ButtonListener bl : buttonListeners)
            bl.ButtonChange(button, newText);
	}
	
	@Override
	public void buttonPressedA() {
		PauseTimer();
		switch (timeMode)
		{
			case 0:
				timeMode = 1;
				RequestButtonChange(1, "increment seconds");
				RequestButtonChange(2, "Switch to minutes");
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
				RequestButtonChange(1, "increment minutes");
				RequestButtonChange(2, "Switch to hours");
				break;
			case 2:
				timeMode = 3;
				RequestButtonChange(1, "increment hours");
				RequestButtonChange(2, "OK");
				break;
			case 3:
				timeMode = 0;
				RequestButtonChange(1, "Edit Time");
				RequestButtonChange(2, "View Weather");
				StartTimer();
				break;
		}		
	}
}
