package display;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Maksim
 */
public abstract class Display extends JLabel{
    // Why is this here?	
	public Display()
	{
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Consolas", Font.BOLD, 20));
	}
}
