package controllers;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationController implements MainController{
	
	private Timer updateNotificationsTimer;
	
	public NotificationController()
	{
		updateNotificationsTimer.schedule(getNotifications(), 12000);
	}
	private TimerTask getNotifications() {
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
