package display;

import controllers.ButtonListener;
import controllers.TimeController;
import controllers.TimeListener;
import model.Time;

public class TimeDisplay extends Display implements TimeListener{
	private TimeController timeController;
	
	public TimeDisplay(ButtonListener buttonListener)
	{					
		timeController = new TimeController();
		timeController.addTimeListener(this);
		timeController.addButtonListener(buttonListener);
    }
	
	public TimeController GetController()
	{
		return timeController;
	}

	@Override
	public void TimeTicked() 
	{
		timeController.GetTime().Tick();
		UpdateTimeString();
	}

	@Override
	public void TimeChanged() 
	{
		UpdateTimeString();
	}
	
	private void UpdateTimeString()
	{
		Time currentTime = timeController.GetTime();
		setText(GetTimeString(currentTime));
	}
	
	private String GetTimeString(Time time)
	{
		String timeString = "";
		timeString += GetTimeUnitCounterString(time.GetHours()) + ":";
		timeString += GetTimeUnitCounterString(time.GetMinutes()) + ":";
		timeString += GetTimeUnitCounterString(time.GetSeconds());
		
		return timeString;
	}
	
	private String GetTimeUnitCounterString(int timeUnitCounter)
	{
		if (timeUnitCounter < 10)
		{
			return "0" + timeUnitCounter;
		}		
		return Integer.toString(timeUnitCounter);
	}
}
