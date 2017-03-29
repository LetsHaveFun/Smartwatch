package display;

import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class TimeDisplay extends Display{
	
	
	public TimeDisplay(){
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JTextArea textArea = new JTextArea();
		textArea.setRows(2);
		textArea.setText("This is the time");
		add(textArea);
    }
}
