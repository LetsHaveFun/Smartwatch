package display;

import controllers.*;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class NotificationDisplay extends Display{
    
	protected NotificationController notificationController;

	public NotificationDisplay(){
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JTextArea textArea = new JTextArea();
		textArea.setRows(2);
		textArea.setText("This is the notifications");
		add(textArea);
    }
}