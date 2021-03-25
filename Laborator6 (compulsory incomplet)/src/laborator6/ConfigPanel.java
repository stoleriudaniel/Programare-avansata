package laborator6;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel{
	final MainFrame frame;
	JLabel sidesLabel;
	JSpinner sidesField;
	//JComboBox colorCombo;
	public ConfigPanel(MainFrame frame)
	{
		this.frame=frame;
		init();
	}
	private void init() {
		//create label and the spinner
		sidesLabel = new JLabel("Number of sides:");
		sidesField = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		sidesField.setValue(6);
		
		add(sidesLabel);
		add(sidesField);
		//add(colorCombo);
	}
}
