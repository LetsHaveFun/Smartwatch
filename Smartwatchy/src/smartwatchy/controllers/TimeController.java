package controllers;

import java.util.Timer;
import java.util.TimerTask;

import model.Time;

public class TimeController implements MainController{
	private Time time;
	private Timer updateTimeTimer;

	public TimeController ()
	{
		time = new Time();
		updateTimeTimer.schedule(updateTime(), 12000);
	}
	private TimerTask updateTime() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void buttonPressedA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonPressedB() {
		// TODO Auto-generated method stub
		
	}

}
