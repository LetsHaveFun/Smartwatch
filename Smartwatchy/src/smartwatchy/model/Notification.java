package model;

import java.sql.Timestamp;

public class Notification {
	
	public String notification;
	public Timestamp timestamp;
	
	public Notification(String notificationtmp, Timestamp timestamptmp)
	{
		notification = notificationtmp;
		timestamp = timestamptmp;
	}
	
	public Notification GetNotification()
	{
		return this;
	}

}
