package laborator6;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	DrawingPanel canvas;
	public MainFrame() {
		super("My Drawing Aplication");
		init();
	}
	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		canvas = new DrawingPanel(this);
		
		//add(canvas,CENTER);
		
		pack();
	}
}
