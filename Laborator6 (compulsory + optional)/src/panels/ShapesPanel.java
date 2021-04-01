package panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapesPanel extends JPanel {
    public List<Shape> shapes;
    public List<Color> colours;
    public ShapesPanel(){
        init();
    }
    private void init(){
        shapes = new ArrayList<>();
        colours = new ArrayList<>();
    }
}