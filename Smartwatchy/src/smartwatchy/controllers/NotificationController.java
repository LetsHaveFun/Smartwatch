package controllers;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import model.Notification;

public class NotificationController implements MainController{
	private Timer updateNotificationsTimer;
	private Queue<Notification> notificationQueue;
	
	public NotificationController()
	{
		updateNotificationsTimer.schedule(updateNotifications(), 2000);
	}
	
	private TimerTask updateNotifications() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Notification GetFirstInQueue()
	{
		return notificationQueue.peek();
	}
	
	@Override
	public void buttonPressedA() {
		notificationQueue.remove();
		
	}

	@Override
	public void buttonPressedB() {
		// TODO Auto-generated method stub
		
	}

}
