package display;

import model.Weather;

import java.text.SimpleDateFormat;

import controllers.WeatherController;
import controllers.WeatherListener;

public class WeatherDisplay extends Display implements WeatherListener{
	private final SimpleDateFormat weatherDateFormat = new SimpleDateFormat("EEE MMMMM d");
	private final SimpleDateFormat updateTimeFormat = new SimpleDateFormat("HH:mm aaa z");
	private WeatherController weatherController;

	public WeatherDisplay(WeatherListener NotificationWeatherListener){		
		weatherController = new WeatherController();
		weatherController.addListener(this);
		weatherController.addListener(NotificationWeatherListener);
    }

	@Override
	public void WeatherWarning(String warningText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void WeatherUpdate() {
		weatherController.updateCurrentWeather();
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
		weatherString += "Weather<br>" + weatherDateFormat.format(weather.GetDateTime()) + "<br>";
		weatherString += weather.GetDescription() + "<br><br>";
		weatherString += "Temperatures<br>";
		weatherString += "Morning: " + weather.GetMorningTemperature() + "C<br>";	
		weatherString += "Day: " + weather.GetDayTemperature() + "C<br>";	
		weatherString += "Evening: " + weather.GetEveningTemperature() + "C<br>";	
		weatherString += "Night: " + weather.GetNightTemperature() + "C<br><br>";
		weatherString += "Last updated<br>" + updateTimeFormat.format(weather.GetUpdateTime());
		weatherString += "</html>";		
		
		return weatherString;
	}
}
