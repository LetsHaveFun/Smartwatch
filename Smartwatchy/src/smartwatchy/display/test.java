package display;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class test extends JPanel {

	/**
	 * Create the panel.
	 */
	public test() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JButton btnAsdasd = new JButton("asdasd");
		add(btnAsdasd);
		
		JTextArea txtrRgsfg = new JTextArea();
		txtrRgsfg.setRows(2);
		txtrRgsfg.setText("rgsfg\r\n\r\nasdada\r\n");
		add(txtrRgsfg);

	}

}
