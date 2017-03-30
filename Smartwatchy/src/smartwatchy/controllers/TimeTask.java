package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import model.Time;

public class TimeTask extends TimerTask {
	private Time time;
	private List<TimeListener> listeners = new ArrayList<TimeListener>();
	
	public TimeTask(Time time, List<TimeListener> listeners)
	{
		this.time = time;
		this.listeners = listeners;
	}
	
	private void PushTimeTicked()
	{
		// Notify everybody that may be interested.
        for (TimeListener tl : listeners)
            tl.TimeTicked();
	}
	
	@Override
    public void run() {
		time.Tick();
		PushTimeTicked();
    }
}
