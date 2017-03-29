package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import model.Notification;
import model.Weather;

public class NotificationController implements Controller{
	private Timer updateNotificationsTimer;
	private Queue<Notification> notifications;
	private List<NotificationListener> listeners = new ArrayList<NotificationListener>();
	
	public NotificationController()
	{
		updateNotificationsTimer.schedule(updateNotifications(), 2000);
	}

    public void addListener(NotificationListener toAdd) {
        listeners.add(toAdd);
    }

    public void PushNotification() {

        // Notify everybody that may be interested.
        for (NotificationListener nl : listeners)
            nl.NewNotification();
    }
	
	private TimerTask updateNotifications() {
		// check code
		// if code extreme
		// add notifications
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
