package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

import java.util.Random;

public class Dice {
    private Color colorDiceOn = Color.GRAY;
    private Color colorDotsOn = Color.BLACK;
    private int index;
    private boolean current = false;
    private double size = 50;
    private int valueDice=0;
    private static final Random randomValue = new Random ();
    private double dotRadius=5;
    public Coordinates coordinates = new Coordinates(300,300,size,size);

    public Dice(Color color){
        valueDice=randomValue.nextInt(6)+1;
        if(color==Color.BLACK)
        {
            colorDiceOn = Color.BLACK;
            colorDotsOn = Color.GRAY;
        }
        else if(color==Color.GRAY){
            colorDiceOn = Color.GRAY;
            colorDotsOn = Color.BLACK;
        }
    }

    public void setDiceRandomValue() {
        valueDice = 1 + randomValue.nextInt (6);
    }

    public int getValueDice() {
        return valueDice;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public void drawMark(GraphicsContext gc)
    {
        gc.setStroke (Color.rgb(130,94,33));
        //gc.setStroke (Color.GREEN);
        gc.setLineWidth (6);
        gc.setLineCap (StrokeLineCap.ROUND);
        double radius = size / 2;
        double offset = size / 1.3;
        //sus
        gc.strokeLine (coordinates.x - radius, coordinates.y - offset + 6, coordinates.x + radius, coordinates.y - offset + 6);
        //jos
        gc.strokeLine (coordinates.x - radius, coordinates.y + offset - 6, coordinates.x + radius, coordinates.y + offset - 6);
        //stanga
        gc.strokeLine (coordinates.x - radius - 8, coordinates.y - offset + 7, coordinates.x - radius - 8, coordinates.y + offset - 7);
        //dreapta
        gc.strokeLine (coordinates.x + radius + 8, coordinates.y - offset + 7, coordinates.x + radius + 8, coordinates.y + offset - 7);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill (colorDiceOn);
        gc.fillRect (coordinates.x - size / 2, coordinates.y - size / 2, size, size);
        gc.setFill(colorDotsOn);
        if(valueDice == 1) {
            gc.fillOval(coordinates.x - dotRadius, coordinates.y - dotRadius, dotRadius * 2, dotRadius * 2);
        }
        else if(valueDice == 2) {
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
        }
        else if(valueDice == 3) {
            gc.fillOval(coordinates.x - dotRadius, coordinates.y - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
        }
        else if(valueDice == 4) {
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
        }
        else if(valueDice == 4) {
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
        }
        else if(valueDice == 5) {
            gc.fillOval(coordinates.x - dotRadius, coordinates.y - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
        }
        else if(valueDice == 6) {
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x + size / 4 - dotRadius, coordinates.y - size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - size / 4 - dotRadius, coordinates.y + size / 4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - dotRadius, coordinates.y - size/4 - dotRadius, dotRadius * 2, dotRadius * 2);
            gc.fillOval(coordinates.x - dotRadius, coordinates.y + size/4 - dotRadius, dotRadius * 2, dotRadius * 2);
        }
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setValueDice(int valueDice) {
        this.valueDice = valueDice;
    }
}
