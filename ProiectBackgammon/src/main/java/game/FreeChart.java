package game;

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
    private static Singleton singleton;
    public FreeChart(Singleton singleton){
        this.singleton=singleton;
    }
    public void show()
    {
        try{
            String query="SELECT name, wins FROM game_users;";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(singleton.getConnection(),query);
            JFreeChart chart = ChartFactory.createBarChart("Users wins","Users","Wins",dataset, PlotOrientation.VERTICAL,false,true,true);
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Query chart",chart);
            frame.setVisible(true);
            frame.setSize(400,600);
            SVGGraphics2D g2 = new SVGGraphics2D(400, 600);
            Rectangle r = new Rectangle(0, 0, 400, 600);
            chart.draw(g2, r);
            //File f = new File("d:\\Imagini\\SVGBarChart.svg");
            //SVGUtils.writeToSVG(f, g2.getSVGElement());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}