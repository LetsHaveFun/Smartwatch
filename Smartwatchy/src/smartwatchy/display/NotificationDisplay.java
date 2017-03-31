package display;

import controllers.NotificationController;
import controllers.NotificationListener;

public class NotificationDisplay extends Display{
    private NotificationController notificationController;

	public NotificationDisplay(NotificationListener mainListener){		
		notificationController = new NotificationController();
		notificationController.addListener(mainListener);
    }
	
	public NotificationController GetController()
	{
		return notificationController;
	}
	
	public void ShowNewNotification() {
		setText(notificationController.GetFirstNotification().GetNotificationMessage());	
	}
}