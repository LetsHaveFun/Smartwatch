package controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;

import model.Notification;

public class NotificationController implements Controller, WeatherListener, NotificationListener{
	private NotificationTask notificationTask;
	private Timer updateNotificationsTimer;
	private Queue<Notification> notifications;
	private List<NotificationListener> listeners = new ArrayList<NotificationListener>();
	
	public NotificationController()
	{
		addListener(this);
		notificationTask = new NotificationTask(listeners);
		updateNotificationsTimer = new Timer(true);
		updateNotificationsTimer.scheduleAtFixedRate(notificationTask, 2000, 1000);
		notifications = new LinkedList<Notification>();
	}
	
	public boolean NotificationsLeft()
	{
		return !notifications.isEmpty();
	}
	
	public Notification GetFirstNotification()
	{
		return notifications.remove();
	}

    public void addListener(NotificationListener toAdd) {
        listeners.add(toAdd);
    }

    private void PushNotifications() {
        for (NotificationListener nl : listeners)
            nl.NewNotification();
    }
	
	@Override
	public void buttonPressedA() {
		// Currently unused
	}

	@Override
	public void buttonPressedB() {
		ClearNotifications();	
	}
	
	private void ClearNotifications()
	{
		notifications.clear();
	}

	@Override
	public void WeatherWarning(String warningText) {
		Notification newNotification = new Notification(warningText);
		notifications.add(newNotification);
	}

	@Override
	public void WeatherUpdate() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void NewNotification() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void CheckNotification() {
		if (notifications.size() > 0)
		{
			PushNotifications();
		}		
	}

}
