package laborator6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	final MainFrame frame;
	 JButton saveBtn = new JButton("Save");
	 public ControlPanel(MainFrame frame)
	 {
		 this.frame=frame;
		 init();
	 }
	 private void init() {
		 setLayout(new GridLayout(1,4));
		 //saveBtn.addActionListener(this::save);
	 }
	 /*private void save(ActionEvent e)
	 {
		 try {
			 ImageIO.write(frame.canvas.image, "PNG", new File("D:/testImage.png"));
		 }
		 catch(IOException ex) {
			 System.err.println(ex);
		 }
	 }*/
}
