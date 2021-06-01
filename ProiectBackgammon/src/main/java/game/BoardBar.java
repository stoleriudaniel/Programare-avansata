package game;

import game.Coordinates;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BoardBar
{
    enum Direction
    {
        UP, DOWN, LEFT, RIGHT
    }
    Direction direction;
    private Color color;
    protected Coordinates coordinates;
    public BoardBar(Color color, Direction direction)
    {
        this.color=color;
        this.direction=direction;
    }

    public void draw (GraphicsContext gc)
    {
        gc.setFill (color);
        gc.fillRect (coordinates.x, coordinates.y, coordinates.width, coordinates.height);
    }
    public void setCoordinates (Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }
}