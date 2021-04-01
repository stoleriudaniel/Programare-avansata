package panels;

import javax.swing.*;

import lab.MainFrame;

import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    public  JSpinner sidesField;
    public  JLabel sidesLabel;
    public  JSpinner sizeField;
    public  JLabel sizeLabel;
    public  JComboBox shapes;
    public JComboBox colours;
    public  JCheckBox checkBox;
    public JButton undoBtn;
    public ConfigPanel(MainFrame frame)
    {
        this.frame=frame;
        init();
    }
    private void init(){
        shapes = new JComboBox<>(new String[] { "Rectangle", "Triangle" });
        colours = new JComboBox<>(new String[]{"Blue","Green","Yellow","Red"});
        sidesLabel = new JLabel("Number of sides: ");
        sidesField = new JSpinner(new SpinnerNumberModel(3,3,5,1));
        Dimension d = sidesField.getPreferredSize();
        d.width=30; d.height=30;
        sidesField.setPreferredSize(d);
        sizeLabel = new JLabel("Size: ");
        sizeField = new JSpinner(new SpinnerNumberModel(10,10,70,1));
        Dimension d1 = sizeField.getPreferredSize();
        d1.width=30; d1.height=30;
        checkBox = new JCheckBox();
        undoBtn = new JButton("Undo");
        add(undoBtn);
        add(shapes);
        add(colours);
        add(sidesLabel);
        add(sidesField);
        add(sizeLabel);
        add(sizeField);
        add(checkBox);
    }
}
