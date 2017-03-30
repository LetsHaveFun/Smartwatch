package controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.w3c.dom.*;

import json.JSONException;
import json.JSONObject;
import model.Weather;

import javax.xml.parsers.*;
import java.io.*;

public class WeatherController implements Controller{
	private Timer updateWeatherTimer;
	private List<WeatherListener> listeners = new ArrayList<WeatherListener>();
	
	public WeatherController()
	{
		//updateWeatherTimer.schedule(updateWeather(), 5000);
	}
	
	public void addListener(WeatherListener toAdd) {
        listeners.add(toAdd);
    }

    private void PushWarning() {

        // Notify everybody that may be interested.
        for (WeatherListener wl : listeners)
            wl.WeatherWarning();
    }
	
	private TimerTask updateWeather() {
		//calling the weather function to run
		// overwrite currentWeather
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
	
	public Weather GetCurrentWeather()
	{
		try {
			JSONObject obj = new JSONObject(GetWeatherJSON());
			int tmptemp =  0; //obj.getInt("temp"); 
			
			int tmpcod = obj.getInt("cod");
			
			Weather newCurrentWeather = new Weather(tmptemp, tmpcod);
			return newCurrentWeather;
		} catch (JSONException e) {			
			e.printStackTrace();
			return null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String GetWeatherJSON() throws MalformedURLException, IOException
	{
		BufferedReader br = null;

        try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Emmen&type=accurate&mode=json&units=metric&appid=997fd862e4b65ba284fb387cd98b35c7");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            return sb.toString();
        } finally {

            if (br != null) {
                br.close();
            }
        }
	}

	
}
