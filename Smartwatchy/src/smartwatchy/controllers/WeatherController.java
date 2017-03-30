package controllers;
import java.util.ArrayList;
import java.util.Date;
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
import model.Time;
import model.Weather;

import javax.xml.parsers.*;
import java.io.*;

public class WeatherController implements Controller{
	private Timer weatherTimer;
	private WeatherTask weatherTask;
	private Weather currentWeather;
	private List<WeatherListener> listeners = new ArrayList<WeatherListener>();
	
	public WeatherController()
	{
		weatherTask = new WeatherTask(this, listeners);
		weatherTimer = new Timer(true);
		weatherTimer.scheduleAtFixedRate(weatherTask, 0, 15000);
		updateCurrentWeather();
	}
	
	public Weather GetCurrentWeather()
	{
		return currentWeather;
	}
	
	public void addListener(WeatherListener toAdd) {
        listeners.add(toAdd);
    }

    private void PushWarning() {
        // Notify everybody that may be interested.
        for (WeatherListener wl : listeners)
            wl.WeatherWarning();
    }
	
	public void updateCurrentWeather() {
		currentWeather = GetCurrentWeatherFromAPI();
	}
	
	@Override
	public void buttonPressedA() {
		updateCurrentWeather();
	}
	
	@Override
	public void buttonPressedB() {
		// Currently unused	
	}
	
	private Weather GetCurrentWeatherFromAPI()
	{
		try {
			JSONObject forecastJSON = new JSONObject(GetWeatherForecastJSON());
			JSONObject todayJSON = forecastJSON.getJSONArray("list").getJSONObject(0);
			String description = todayJSON.getJSONArray("weather").getJSONObject(0).getString("description");
			int weatherID = todayJSON.getJSONArray("weather").getJSONObject(0).getInt("id");
			int morningTemp =  todayJSON.getJSONObject("temp").getInt("morn"); 
			int dayTemp =  todayJSON.getJSONObject("temp").getInt("day");
			int nightTemp =  todayJSON.getJSONObject("temp").getInt("night");		
			int eveningTemp = todayJSON.getJSONObject("temp").getInt("eve");	
			long longTime = todayJSON.getLong("dt") * 1000;
			
			Weather newCurrentWeather = new Weather(description, weatherID, morningTemp, dayTemp, nightTemp, eveningTemp, longTime);
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
	
	private String GetWeatherForecastJSON() throws MalformedURLException, IOException
	{
		BufferedReader br = null;

        try {
        	URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=Emmen&type=accurate&units=metric&appid=997fd862e4b65ba284fb387cd98b35c7");
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
