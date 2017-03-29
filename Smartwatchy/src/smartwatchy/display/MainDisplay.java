package display;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainDisplay implements ActionListener{
	
	private NotificationDisplay notificationDisplay;
	private TimeDisplay timeDisplay;
	private WeatherDisplay weatherDisplay;
	private JFrame frame;
	private JButton button1, button2;
	private JPanel displayPanel, buttonPanel;
	private Display curDisplay;
	
	public MainDisplay(){
		
		notificationDisplay = new NotificationDisplay();
		timeDisplay = new TimeDisplay();
		weatherDisplay = new WeatherDisplay();
		curDisplay = timeDisplay;
		
		makeFrame();
	}
	
	public void makeFrame()
	{
		frame = new JFrame();
		displayPanel = new JPanel();
		buttonPanel = new JPanel();
		button1 = new JButton("bt1");
		buttonPanel.add(button1);
		button2 = new JButton("bt2");
		buttonPanel.add(button2);
		
		
		
		frame.add(curDisplay, BorderLayout.EAST);
		frame.add(buttonPanel, BorderLayout.WEST);
		frame.setVisible(true);
		
		frame.pack();
		
	}
	public void removeCurPanel(){
		frame.remove(curDisplay);
		
	}
	public void addNewDisplay(String nextDisplay){
		if(nextDisplay=="TimeDisplay"){
			curDisplay = timeDisplay;
			frame.add(curDisplay, BorderLayout.EAST);
		}
		else if(nextDisplay=="WeatherDisplay"){
			curDisplay = weatherDisplay;
			frame.add(curDisplay, BorderLayout.EAST);
		}
		else{
			curDisplay = weatherDisplay;
			frame.add(curDisplay, BorderLayout.EAST);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==button1)
		{
			//curDisplay.Controller.ButtonPressedA();
			
		}
	}
}
