package display;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import controllers.NotificationListener;

public class MainDisplay implements NotificationListener{
	
	private NotificationDisplay notificationDisplay;
	private TimeDisplay timeDisplay;
	private WeatherDisplay weatherDisplay;
	private JFrame frame;
	private JButton button1, button2;
	private Display curDisplay;
	private String curDisplayString;
	
	public MainDisplay(){		
		notificationDisplay = new NotificationDisplay();
		timeDisplay = new TimeDisplay();
		weatherDisplay = new WeatherDisplay();
		curDisplay = timeDisplay;
		curDisplayString = "timeDisplay";
		
		makeFrame();
	}
	
	public void makeFrame()
	{
		frame = new JFrame();
		button1 = new JButton("bt1");
		button2 = new JButton("bt2");
		
		button1.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  buttonOneAction();
			  }
		});
		
		button2.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  buttonTwoAction();
			  }
		});
		
		frame.add(curDisplay, BorderLayout.CENTER);
		frame.add(button1, BorderLayout.NORTH);
		frame.add(button2, BorderLayout.SOUTH);
		frame.setVisible(true);
		
		frame.pack();
		
	}

	@Override
	public void NewNotification() {
		switchMode("NotificationDisplay");		
	}
	
	private void buttonOneAction()
	{
		if(curDisplayString.equals("timeDisplay"))
		{
			timeDisplay.GetController().buttonPressedA();
		}
		else if(curDisplayString.equals("weatherDisplay"))
		{
			weatherDisplay.GetController().buttonPressedA();
		}
		else
		{
			notificationDisplay.notificationController.buttonPressedA();
		}
	}
	
	private void buttonTwoAction()
	{
		if(curDisplayString.equals("timeDisplay"))
		{
			if (timeDisplay.GetController().GetMode() == 0)
			{
				switchMode("WeatherDisplay");
			}
			else
			{
				timeDisplay.GetController().buttonPressedB();
			}
		}
		else if(curDisplayString.equals("weatherDisplay"))
		{
			weatherDisplay.GetController().buttonPressedB();
		}
		else
		{
			notificationDisplay.notificationController.buttonPressedB();
		}
	}
	
	private void switchMode(String nextDisplay)
	{
		removeCurPanel();
		addNewDisplay(nextDisplay);
		frame.revalidate();		
	}	

	private void removeCurPanel(){
		frame.remove(curDisplay);
	}	
	
	private void addNewDisplay(String nextDisplay){
		switch (nextDisplay)
		{
			case "TimeDisplay":
				curDisplay = timeDisplay;
				curDisplayString = "timeDisplay";
				frame.add(curDisplay, BorderLayout.CENTER);
				break;
			case "WeatherDisplay":
				curDisplay = weatherDisplay;
				curDisplayString = "weatherDisplay";
				frame.add(curDisplay, BorderLayout.CENTER);
				break;
			case "NotificationDisplay":
				curDisplay = notificationDisplay;
				curDisplayString = "notificationDisplay";
				frame.add(curDisplay, BorderLayout.CENTER);
				break;
			default:
				curDisplay = timeDisplay;
				curDisplayString = "timeDisplay";
				frame.add(curDisplay, BorderLayout.CENTER);
		}		
	}
}
