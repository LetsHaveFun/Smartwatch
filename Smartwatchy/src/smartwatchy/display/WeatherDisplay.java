package display;

import controllers.*;
import model.Time;
import model.Weather;

import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class WeatherDisplay extends Display{
	private WeatherController weatherController;

	public WeatherDisplay(){		
		weatherController = new WeatherController();
		UpdateWeatherString();
    }
	
	public WeatherController GetController()
	{
		return weatherController;
	}
	
	private void UpdateWeatherString()
	{
		Weather currentWeather = weatherController.GetCurrentWeather();
		setText(GetWeatherString(currentWeather));
	}
	
	private String GetWeatherString(Weather weather)
	{
		String weatherString = "<html>";		
		weatherString += "Weather today: " + weather.GetDescription() + "<br><br>";
		weatherString += "Temperatures:<br>";
		weatherString += "Morning: " +weather.GetMorningTemperature() + "<br>";	
		weatherString += "Day: " +weather.GetDayTemperature() + "<br>";	
		weatherString += "Evening: " +weather.GetEveningTemperature() + "<br>";	
		weatherString += "Night: " +weather.GetNightTemperature() + "<br>";
		weatherString += "</html>";		
		
		return weatherString;
	}
}
