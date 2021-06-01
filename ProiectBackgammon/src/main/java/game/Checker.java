package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Checker {
    private static double radius = 23;
    public Color color;
    private int triangleNo; //de la 1
    private int checkerNo; //de la 1
    private Coordinates coordinates;
    private double startPoint;
    public Checker(){};
    public Checker(Color color){
        this.color=color;
    }
    public Checker(int triangleNo, Color color) {
        this.triangleNo=triangleNo;
        this.color=color;
    }

    public void drawOval (GraphicsContext gc, double x, double y)
    {
        double w = radius * 2 - 2;
        double h = radius * 2 - 2;
        gc.setFill(color);
        gc.fillOval (x - radius + 1, y - radius + 1, w, h);
    }

    public void drawRoundRect (GraphicsContext gc, double x, double y)
    {
        gc.setFill(color);
        gc.fillRoundRect (x - radius, y - 7, radius * 2, 14, 8, 8);
    }

    public boolean contains(double x, double y) {
        double w = radius * 2 - 2;
        double h = radius * 2 - 2;
        return (x>=coordinates.x - radius && y>=coordinates.y - radius && x<=coordinates.x + radius && y<=coordinates.y+radius);
    }

    public static void setRadius(double radius) {
        Checker.radius = radius;
    }

    public void setCheckerNo(int checkerNo) {
        this.checkerNo = checkerNo;
    }

    public int getCheckerNo() {
        return checkerNo;
    }

    public static double getRadius() {
        return radius;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setTriangleNo(int triangleNo) {
        this.triangleNo = triangleNo;
    }

    public int getTriangleNo() {
        return triangleNo;
    }

    public void setStartPoint(double startPoint) {
        this.startPoint = startPoint;
    }

    public double getStartPoint() {
        return startPoint;
    }
}
