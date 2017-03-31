package display;
import java.awt.*;
import javax.swing.*;

public abstract class Display extends JLabel{
	public Display()
	{
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Consolas", Font.BOLD, 20));
	}
}
