package panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import lab.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.spi.FileTypeDetector;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    private final JFileChooser openFileChooser;
    private final JFileChooser saveFileChooser;
    public ControlPanel(MainFrame frame)
    {
        this.frame=frame;
        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("d:\\Imagini"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images","png"));
        saveFileChooser = new JFileChooser();
        saveFileChooser.setCurrentDirectory(new File("d:\\Imagini"));
        saveFileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images","png"));
        init();
    }
    private void init(){
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::saveImage);
        loadBtn.addActionListener(this::loadImage);
        resetBtn.addActionListener(this::resetImage);
        exitBtn.addActionListener(this::exitFrame);

    }
    private void saveImage(ActionEvent e){
        int returnValue = saveFileChooser.showSaveDialog(this);
        File file = saveFileChooser.getSelectedFile();
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream(file.getAbsolutePath()));
            }
            catch (IOException ex)
            {
                System.err.println(ex);
            }
        }
    }
    private void loadImage(ActionEvent e){
        int returnValue = openFileChooser.showOpenDialog(this);
        File file = openFileChooser.getSelectedFile();
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                frame.canvas.image = ImageIO.read(new FileInputStream(file.getAbsolutePath()));
                frame.canvas.repaint();
            }
            catch (IOException ex)
            {
                System.err.println(ex);
            }
        }
    }
    private void resetImage(ActionEvent e)
    {
        int[] argbClear = new int[frame.canvas.image.getWidth() * frame.canvas.image.getHeight()];

        for (int i = 0; i < frame.canvas.image.getWidth() * frame.canvas.image.getHeight(); i++) {
            argbClear[i] = 0x00000000;
        }
        frame.canvas.image.setRGB(0, 0, frame.canvas.image.getWidth(), frame.canvas.getHeight(), argbClear, 0, frame.canvas.image.getWidth());
        frame.canvas.repaint();
    }
    private void exitFrame(ActionEvent e)
    {
        frame.dispose();
    }
}