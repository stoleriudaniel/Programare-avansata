package panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import lab.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1300, H = 900;
    private Rectangle bounds;
    public  BufferedImage image;
    public  Graphics2D graphics;
    private int mouseXpos=70, mouseYpos=70;
    private int x, y;
    private int sides;
    private int radius;
    public DrawingPanel(MainFrame frame)
    {
        this.frame=frame;
        createOffscreenImage();
        init();
    }
    public void init(){
        setLayout(new GridLayout());
        setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(170, 370, 170, 370)));
        setBackground(Color.WHITE);
        setVisible(true);
        frame.configPanel.undoBtn.addActionListener(this::undoButton);
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }


    private void drawShape(int x, int y) {
        if(frame.configPanel.checkBox.isSelected()) {
            int radius = (int) frame.configPanel.sizeField.getValue();
            int sides = (int) frame.configPanel.sidesField.getValue();
            Random random = new Random();
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            graphics.setColor(new Color(r, g, b));
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
    }
    private void drawShapes(){
        if(frame.shapesPanel.shapes.size()>0)
        {
        	int index=0;
            for(Shape shape : frame.shapesPanel.shapes)
            {
                graphics.setColor(frame.shapesPanel.colours.get(index));
                graphics.fill(shape);
                index++;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }
    {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mouseXpos = e.getX();
                mouseYpos = e.getY();
                if(frame.configPanel.checkBox.isSelected()) {
                    drawShape(mouseXpos, mouseYpos);
                    repaint();
                }
                else{
                    int indexSelectedShape = frame.configPanel.shapes.getSelectedIndex();
                    Shape newShape;
                    if(indexSelectedShape==0)
                    {
                        newShape = new RegularPolygon(mouseXpos, mouseYpos, (int) frame.configPanel.sizeField.getValue(), 4);
                        frame.shapesPanel.shapes.add(newShape);
                        int index = frame.configPanel.colours.getSelectedIndex();
                        //"Blue","Green","Yellow","Red"
                        if(index==0)
                            frame.shapesPanel.colours.add(Color.BLUE);
                        else if(index==1)
                            frame.shapesPanel.colours.add(Color.GREEN);
                        else if(index==2)
                            frame.shapesPanel.colours.add(Color.YELLOW);
                        else if(index==3)
                            frame.shapesPanel.colours.add(Color.RED);
                        drawShapes();
                        repaint();
                    }
                    else if(indexSelectedShape==1)
                    {
                        newShape = new RegularPolygon(mouseXpos, mouseYpos, (int) frame.configPanel.sizeField.getValue(), 3);
                        frame.shapesPanel.shapes.add(newShape);
                        int index = frame.configPanel.colours.getSelectedIndex();
                        //"Blue","Green","Yellow","Red"
                        if(index==0)
                            frame.shapesPanel.colours.add(Color.BLUE);
                        else if(index==1)
                            frame.shapesPanel.colours.add(Color.GREEN);
                        else if(index==2)
                            frame.shapesPanel.colours.add(Color.YELLOW);
                        else if(index==3)
                            frame.shapesPanel.colours.add(Color.RED);
                        drawShapes();
                        repaint();
                    }
                }
            }
        });
    }
    public void undoButton(ActionEvent e){
    	System.out.print("kkk");
        frame.shapesPanel.shapes.remove(frame.shapesPanel.shapes.size()-1);
        frame.shapesPanel.colours.remove(frame.shapesPanel.colours.size()-1);
        int[] argbClear = new int[image.getWidth() * image.getHeight()];

        for (int i = 0; i < image.getWidth() * image.getHeight(); i++) {
            argbClear[i] = 0x00000000;
        }
        image.setRGB(0, 0, image.getWidth(), image.getHeight(), argbClear, 0, image.getWidth());
        drawShapes();
        repaint();
    }
}
