package display;

import controllers.*;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class WeatherDisplay extends Display{

	private WeatherController weatherController;

	public WeatherDisplay(){

		setText("This is the weather");
		
		
		weatherController = new WeatherController();
    }
	
	public WeatherController GetController()
	{
		return weatherController;
	}
}
