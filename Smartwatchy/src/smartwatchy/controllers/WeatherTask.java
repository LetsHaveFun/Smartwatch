package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class WeatherTask extends TimerTask{
	private List<WeatherListener> listeners = new ArrayList<WeatherListener>();
	
	public WeatherTask(List<WeatherListener> listeners)
	{
		this.listeners = listeners;
	}
	
	private void PushWeatherUpdate()
	{
        for (WeatherListener wl : listeners)
            wl.WeatherUpdate();
	}
	
	@Override
    public void run() {
		PushWeatherUpdate();
    }
}
