package model;

import java.util.Date;

public class Notification {
	
	private String notification;
	private Date dateTime;
	
	public Notification(String notificationtmp)
	{
		notification = notificationtmp;
		dateTime = new Date();
	} 	
	
	public String GetNotification()
	{
		return notification;
	}
	
	public Date GetNotificationDateTime()
	{
		return dateTime;
	}

}
