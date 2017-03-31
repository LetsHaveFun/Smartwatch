package model;

import java.util.Date;

public class Notification {	
	private String notificationMessage;
	private Date dateTime;
	
	public Notification(String notificationMessage)
	{
		this.notificationMessage = notificationMessage;
		dateTime = new Date();
	} 	
	
	public String GetNotificationMessage()
	{
		return notificationMessage;
	}
	
	public Date GetNotificationDateTime()
	{
		return dateTime;
	}

}
