package controllers;
import java.util.Timer;
import java.util.TimerTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherController implements MainController{
	private Timer updateWeatherTimer;
	
	public WeatherController()
	{
		updateWeatherTimer.schedule(updateWeather(), 5000);
	}
	private TimerTask updateWeather() {
		//calling the weather function to run
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
	
	private StringBuilder GetWeatherJSON() throws MalformedURLException, IOException
	{
		BufferedReader br = null;

        try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Emmen&appid=997fd862e4b65ba284fb387cd98b35c7");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            return sb;
        } finally {

            if (br != null) {
                br.close();
            }
        }
	}

	
}
