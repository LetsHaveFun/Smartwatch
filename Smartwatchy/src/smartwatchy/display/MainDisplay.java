package display;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.NotificationListener;

public class MainDisplay implements NotificationListener{
	
	private NotificationDisplay notificationDisplay;
	private TimeDisplay timeDisplay;
	private WeatherDisplay weatherDisplay;
	private JFrame frame;
	private JButton button1, button2;
	private JPanel buttonPanel;
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
		buttonPanel = new JPanel();
		button1 = new JButton("bt1");
		buttonPanel.add(button1);
		button2 = new JButton("bt2");
		buttonPanel.add(button2);
		
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
		
		frame.add(curDisplay, BorderLayout.EAST);
		frame.add(buttonPanel, BorderLayout.WEST);
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
				frame.add(curDisplay, BorderLayout.EAST);
				break;
			case "WeatherDisplay":
				System.out.println("test");
				curDisplay = weatherDisplay;
				curDisplayString = "weatherDisplay";
				frame.add(curDisplay, BorderLayout.EAST);
				break;
			case "NotificationDisplay":
				curDisplay = notificationDisplay;
				curDisplayString = "notificationDisplay";
				frame.add(curDisplay, BorderLayout.EAST);
				break;
			default:
				curDisplay = timeDisplay;
				curDisplayString = "timeDisplay";
				frame.add(curDisplay, BorderLayout.EAST);
		}		
	}

}