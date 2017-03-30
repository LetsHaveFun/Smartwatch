package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class WeatherTask extends TimerTask{
	private WeatherController weatherController;
	private List<WeatherListener> listeners = new ArrayList<WeatherListener>();
	
	public WeatherTask(WeatherController weatherController, List<WeatherListener> listeners)
	{
		this.weatherController = weatherController;
		this.listeners = listeners;
	}
	
	private void PushTimeTicked()
	{
		// Notify everybody that may be interested.
        for (WeatherListener wl : listeners)
            wl.WeatherUpdate();
	}
	
	@Override
    public void run() {
		weatherController.updateCurrentWeather();
		PushTimeTicked();
    }
}
