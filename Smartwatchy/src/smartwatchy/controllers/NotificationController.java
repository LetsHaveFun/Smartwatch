package controllers;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationController implements MainController{
	
	private Timer updateNotificationsTimer;
	
	public NotificationController()
	{
		updateNotificationsTimer.schedule(updateNotifications(), 2000);
	}
	private TimerTask updateNotifications() {
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
