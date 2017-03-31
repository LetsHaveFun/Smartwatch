package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class NotificationTask extends TimerTask{
	private List<NotificationListener> listeners = new ArrayList<NotificationListener>();
	
	public NotificationTask(List<NotificationListener> listeners)
	{
		this.listeners = listeners;
	}
	
	private void PushWeatherUpdate()
	{
        for (NotificationListener nl : listeners)
            nl.CheckNotification();
	}
	
	@Override
    public void run() {
		PushWeatherUpdate();
    }
}
