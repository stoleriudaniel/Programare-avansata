package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;

public class BoardTriangle {
    enum Direction
    {
        UP, DOWN
    }
    private Direction direction;
    private Color color;
    private Coordinates coordinates;
    protected double[] triangleX = new double[4];
    protected double[] triangleY = new double[4];

    public BoardTriangle(Color color, Direction direction)
    {
        this.color=color;
        this.direction=direction;
    }

    public void setCoordinates (Coordinates coordinates)
    {
        this.coordinates=coordinates;

        if (direction == direction.DOWN)
        {
            this.triangleX[0] = coordinates.x;
            this.triangleY[0] = coordinates.y;

            this.triangleX[1] = coordinates.x + coordinates.width;
            this.triangleY[1] = coordinates.y;

            this.triangleX[2] = coordinates.x + coordinates.width / 2;
            this.triangleY[2] = coordinates.y + coordinates.height * .85;

            this.triangleX[3] = coordinates.x;
            this.triangleY[3] = coordinates.y;
        }
        else
        {
            this.triangleX[0] = coordinates.x;
            this.triangleY[0] = coordinates.y + coordinates.height;

            this.triangleX[1] = coordinates.x + coordinates.width;
            this.triangleY[1] = coordinates.y + coordinates.height;

            this.triangleX[2] = coordinates.x + coordinates.width / 2;
            this.triangleY[2] = coordinates.y + coordinates.height * .15;

            this.triangleX[3] = coordinates.x;
            this.triangleY[3] = coordinates.y + coordinates.height;
        }
    }


    public void draw (GraphicsContext gc)
    {
        gc.setFill (color);
        gc.fillPolygon (triangleX, triangleY, triangleX.length);
    }
}
