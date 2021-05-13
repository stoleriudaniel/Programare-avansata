package laborator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FreeChart {
    private final Server server;
    public FreeChart(Server server){
        this.server=server;
    }
    public void show()
    {
        try{
            String query="SELECT user_name,connected_times FROM usersconnectiontimes;";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(server.getSingleton().getConnection(),query);
            JFreeChart chart = ChartFactory.createBarChart("Users connections","Users","Connection times",dataset, PlotOrientation.VERTICAL,false,true,true);
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Query chart",chart);
            frame.setVisible(true);
            frame.setSize(400,600);
            SVGGraphics2D g2 = new SVGGraphics2D(400, 600);
            Rectangle r = new Rectangle(0, 0, 400, 600);
            chart.draw(g2, r);
            File f = new File("d:\\Imagini\\SVGBarChart.svg");
            SVGUtils.writeToSVG(f, g2.getSVGElement());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
