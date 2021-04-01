package lab;

import javax.swing.*;

import panels.ConfigPanel;
import panels.ControlPanel;
import panels.DrawingPanel;
import panels.ShapesPanel;

import java.awt.*;

public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
    public DrawingPanel canvas;
    public ControlPanel controlPanel;
    public ShapesPanel shapesPanel;
    public MainFrame(){
        super("My Drawing Aplication");
        init();
    }
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        configPanel = new ConfigPanel(this);
        add(configPanel,BorderLayout.NORTH);
        canvas = new DrawingPanel(this);
        add(canvas,BorderLayout.CENTER);
        controlPanel = new ControlPanel(this);
        add(controlPanel,BorderLayout.SOUTH);
        shapesPanel = new ShapesPanel();
        pack();
    }
}
