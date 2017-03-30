package display;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import controllers.ButtonListener;
import controllers.NotificationListener;

public class MainDisplay implements NotificationListener, ButtonListener{
	
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
		timeDisplay = new TimeDisplay(this);
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
		frame.setBounds(100, 100, 500, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		button1 = new JButton("Edit Time");
		contentPane.add(button1, BorderLayout.NORTH);

		button2 = new JButton("Show Weather");
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
	
	@Override
	public void ButtonChange(int button, String newText)
	{
		changeButton(button, newText);
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

	private void changeButton(int button, String buttonText)
	{
		if(button==1)
		{
			button1.setText(buttonText);
		}
		else if(button==2)
		{
			button2.setText(buttonText);
		}
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
				changeButton(1, "Edit Time");
				changeButton(2, "Show Weather");
				break;
			case "WeatherDisplay":
				curDisplay = weatherDisplay;
				curDisplayString = "weatherDisplay";
				frame.add(curDisplay, BorderLayout.CENTER);
				changeButton(1, "Update");
				changeButton(2, "Show Time");
				break;
			case "NotificationDisplay":
				curDisplay = notificationDisplay;
				curDisplayString = "notificationDisplay";
				frame.add(curDisplay, BorderLayout.CENTER);
				changeButton(1, "Close Notification");
				changeButton(2, "Clear Notifications");
				break;
			default:
				curDisplay = timeDisplay;
				curDisplayString = "timeDisplay";
				frame.add(curDisplay, BorderLayout.CENTER);
		}		
	}
}
