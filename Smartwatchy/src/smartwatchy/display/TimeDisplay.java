package display;

import controllers.*;
import model.Time;

import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class TimeDisplay extends Display implements TimeListener{
	private TimeController timeController;
	JTextArea timeText;
	
	public TimeDisplay()
	{	
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		timeText = new JTextArea();
		timeText.setRows(2);
		this.add(timeText);

		timeController = new TimeController();
		timeController.addListener(this);
    }
	
	public TimeController GetController()
	{
		return timeController;
	}

	@Override
	public void TimeTicked() 
	{
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
		timeText.setText(GetTimeString(currentTime));
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
