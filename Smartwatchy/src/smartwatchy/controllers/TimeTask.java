package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class TimeTask extends TimerTask {
	private TimeController timeController;
	private List<TimeListener> listeners = new ArrayList<TimeListener>();
	
	public TimeTask(TimeController timeController, List<TimeListener> listeners)
	{
		this.timeController = timeController;
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
		timeController.GetTime().Tick();
		PushTimeTicked();
    }
}
