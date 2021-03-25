package laborator6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	final MainFrame frame;
	final static int W=800,H=600;
	BufferedImage image;
	Graphics2D graphics;
	public DrawingPanel(MainFrame frame)
	{
		this.frame=frame;
		createOffscreenImage();
		init();
	}
	private void createOffscreenImage() {
		 image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
		 graphics = image.createGraphics();
		 graphics.setColor(Color.RED);
		 graphics.fillRect(0, 0, W, H);
	}
	private void init() {
		 setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
		 setBorder(BorderFactory.createEtchedBorder()); //for fun
		 //drawShape(e.getX(), e.getY());
		 drawShape(100,300);
		 /*this.addMouseListener(new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
				 drawShape(e.getX(), e.getY()); repaint();
			 } //Can’t use lambdas, JavaFX does a better job in these cases
		 });*/
	}
	public void mousePressed(MouseEvent e) {
		 drawShape(e.getX(), e.getY()); repaint();
	 }
	private void drawShape(int x, int y) {
		 int radius = 90; //generate a random number
		 int sides = 4; //get the value from UI (in ConfigPanel)
		 //Color color = new Color; //create a transparent random Color.
		 //graphics.setColor(color);
		 //graphics.fill(new RegularPolygon(x, y, radius, sides));
		 }
}
