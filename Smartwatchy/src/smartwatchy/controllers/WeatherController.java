package controllers;
import java.util.Timer;
import java.util.TimerTask;

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

	
}
