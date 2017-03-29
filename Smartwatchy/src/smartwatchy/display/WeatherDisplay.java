package display;

import controllers.*;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class WeatherDisplay extends Display{

	protected WeatherController weatherController;

	public WeatherDisplay(){
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JTextArea textArea = new JTextArea();
		textArea.setRows(2);
		textArea.setText("This is the weather");
		add(textArea);
    }
}
