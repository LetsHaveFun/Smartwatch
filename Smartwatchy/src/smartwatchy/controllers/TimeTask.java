package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class TimeTask extends TimerTask {
	private List<TimeListener> listeners = new ArrayList<TimeListener>();
	
	public TimeTask(List<TimeListener> listeners)
	{
		this.listeners = listeners;
	}
	
	private void PushTimeTicked()
	{
        for (TimeListener tl : listeners)
            tl.TimeTicked();
	}
	
	@Override
    public void run() {
		PushTimeTicked();
    }
}
