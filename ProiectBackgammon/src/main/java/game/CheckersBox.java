package game;

import com.sun.security.jgss.GSSUtil;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CheckersBox {
    public final List<Checker> checkers = new ArrayList<>();
    private Coordinates coordinates;
    public Color color;
    private GraphicsContext gc;
    enum Direction {
        UP, DOWN
    }
    public Direction direction;
    public CheckersBox(){}
    public CheckersBox(GraphicsContext gc, Direction direction, Color color) {
        this.direction=direction;
        this.color=color;
    }

    public void addChecker(Checker checker){
        setNewCoordinates(checker);
        checkers.add(checker);
        //drawChecker(checker);
    }

    public void drawCheckers(){
        for(Checker checker : checkers)
        {
            checker.drawRoundRect(gc,checker.getCoordinates().x,checker.getCoordinates().y);
        }
        System.out.println("checkers.zise()="+checkers.size());
    }

    public void drawChecker(Checker checker){
        double x = coordinates.x + coordinates.width*3;
        //x=checker.getCoordinates().x;
        double y = coordinates.y;
       // y=checker.getCoordinates().y;
        if(direction==Direction.UP)
        {
            y = y + coordinates.height - 11 - (20 * checkers.size());
        }
        else if(direction==Direction.DOWN)
        {
            y = y + 10 + 20 * (checkers.size());
        }
        checker.drawRoundRect(gc,x,y);
    }

    public void setNewCoordinates(Checker checker)
    {
        if(direction==Direction.UP) {
            checker.setCoordinates(new Coordinates(
                    coordinates.x + coordinates.width * 3,
                    coordinates.y + 34 + 15 * (checkers.size()),
                    20,
                    5
            ));
        }
        else{
            checker.setCoordinates(new Coordinates(
                    coordinates.x + coordinates.width * 3,
                    554-coordinates.y + 10 - 15 * (checkers.size()),
                    20,
                    5
            ));
        }
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public Direction getDirection() {
        return direction;
    }
}
