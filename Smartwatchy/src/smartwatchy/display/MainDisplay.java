package display;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import controllers.NotificationListener;

public class MainDisplay implements NotificationListener{
	
	private NotificationDisplay notificationDisplay;
	private TimeDisplay timeDisplay;
	private WeatherDisplay weatherDisplay;
	private JFrame frame;
	private JButton button1, button2;
	private JPanel contentPane;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 373, 222);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		button1 = new JButton("bt1");
		contentPane.add(button1, BorderLayout.NORTH);

		button2 = new JButton("bt2");
		contentPane.add(button2, BorderLayout.SOUTH);

		contentPane.add(curDisplay, BorderLayout.CENTER);

		
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
		
		
		
		
		frame.setVisible(true);
		
		
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
