package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import json.JSONException;
import json.JSONObject;
import model.Weather;

public class WeatherController implements Controller{
	private WeatherTask weatherTask;
	private Timer weatherTimer;
	private Weather currentWeather;
	private List<WeatherListener> listeners = new ArrayList<WeatherListener>();
	private List<Long> datesRecieved = new ArrayList<Long>();
	
	public WeatherController()
	{
		weatherTask = new WeatherTask(listeners);
		weatherTimer = new Timer(true);
		weatherTimer.scheduleAtFixedRate(weatherTask, 1000, 300000);
	}
	
	public Weather GetCurrentWeather()
	{
		return currentWeather;
	}
	
	public void addListener(WeatherListener toAdd) {
        listeners.add(toAdd);
    }

    public void PushWarning(String warningText) {
        for (WeatherListener wl : listeners)
            wl.WeatherWarning(warningText);
    }
	
	public void updateCurrentWeather() {
		currentWeather = GetCurrentWeatherFromAPI();
	}
	
	@Override
	public void buttonPressedA() {
		// Currently unused
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
			
			for (Object dayJSON : forecastJSON.getJSONArray("list"))
			{
				JSONObject dayJSONCast = (JSONObject) dayJSON;
				Long dayJSONDateLong = dayJSONCast.getLong("dt");
				if (!datesRecieved.contains(dayJSONDateLong))
				{
					datesRecieved.add(dayJSONDateLong);
					PushWarning("<html>New weather data found!<br>" + dayJSONDateLong + "</html>");
				}
			}
			
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
