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
	private String lastDisplayString;
	
	public MainDisplay(){		
		notificationDisplay = new NotificationDisplay(this);
		timeDisplay = new TimeDisplay(this);
		weatherDisplay = new WeatherDisplay(notificationDisplay.GetController());
		curDisplay = timeDisplay;
		curDisplayString = "TimeDisplay";
		
		makeFrame();
	}
	
	public void makeFrame()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 300, 600);
		
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
	
	private void buttonOneAction()
	{
		switch (curDisplayString)
		{
			case "TimeDisplay":
				timeDisplay.GetController().buttonPressedA();
				break;
			case "WeatherDisplay":
				weatherDisplay.GetController().PushWarning("Weather updated");
				weatherDisplay.WeatherUpdate();
				break;
			case "NotificationDisplay":
				if (notificationDisplay.GetController().NotificationsLeft())
				{
					notificationDisplay.ShowNewNotification();
				}
				else 
				{
					switchMode(lastDisplayString);
				}
				break;		
		}
	}
	
	private void buttonTwoAction()
	{
		switch (curDisplayString)
		{
			case "TimeDisplay":
				if (timeDisplay.GetController().GetMode() == 0)
				{
					weatherDisplay.WeatherUpdate();
					switchMode("WeatherDisplay");
				}
				else
				{
					timeDisplay.GetController().buttonPressedB();
				}
				break;
			case "WeatherDisplay":
				switchMode("TimeDisplay");
				break;
			case "NotificationDisplay":
				notificationDisplay.GetController().buttonPressedB();
				switchMode(lastDisplayString);
				break;		
		}
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
	
	private void switchMode(String nextDisplay)
	{
		removeCurPanel();
		addNewDisplay(nextDisplay);
		frame.revalidate();	
	}	
	
	private void removeCurPanel(){
		contentPane.remove(curDisplay);
		contentPane.repaint();
	}	
	
	private void addNewDisplay(String nextDisplay){
		switch (nextDisplay)
		{
			case "TimeDisplay":
				curDisplay = timeDisplay;
				curDisplayString = "TimeDisplay";
				contentPane.add(curDisplay, BorderLayout.CENTER);
				changeButton(1, "Edit Time");
				changeButton(2, "Show Weather");
				break;
			case "WeatherDisplay":
				curDisplay = weatherDisplay;
				curDisplayString = "WeatherDisplay";
				contentPane.add(curDisplay, BorderLayout.CENTER);
				changeButton(1, "Update");
				changeButton(2, "Show Time");
				break;
			case "NotificationDisplay":
				curDisplay = notificationDisplay;
				curDisplayString = "NotificationDisplay";
				contentPane.add(curDisplay, BorderLayout.CENTER);
				changeButton(1, "Close Notification");
				changeButton(2, "Clear Notifications");
				break;
		}		
	}
	
	@Override
	public void ButtonChange(int button, String newText)
	{
		changeButton(button, newText);
	}
	
	@Override
	public void NewNotification() {
		if (!curDisplayString.equals("NotificationDisplay"))
		{
			lastDisplayString = curDisplayString;
			switchMode("NotificationDisplay");
			notificationDisplay.ShowNewNotification();
		}				
	}

	@Override
	public void CheckNotification() {
		// Currently unused		
	}
}
