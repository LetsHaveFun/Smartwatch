package model;

import java.sql.Timestamp;

public class Notification {
	
	private String notification;
	private Timestamp timestamp;
	
	public Notification(String notificationtmp, Timestamp timestamptmp)
	{
		notification = notificationtmp;
		timestamp = timestamptmp;
	}
	
	public Notification GetNotification()
	{
		return this;
	}
	public String GetNotificationString()
	{
		return notification;
	}
	public Timestamp GetNotificationTimestamp()
	{
		return timestamp;
	}

}
