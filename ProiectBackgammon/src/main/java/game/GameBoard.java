package game;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import game.BoardTriangle.Direction;
import javafx.scene.input.KeyEvent;
import javafx.beans.InvalidationListener;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameBoard extends Canvas {
    protected final GraphicsContext gc = getGraphicsContext2D ();
    private double border = 25;
    private double barWidth = 34;
    private final double homeBoxWidth = 50;
    private final List<BoardTriangle> boardTriangles = new ArrayList<>(24);
    private final List<BoardBar> boardBars = new ArrayList<>(4);
    private final Coordinates[] trianglesCoordinates = new Coordinates[24];
    private double pointWidth;
    private double pointHeight;
    public static double width;
    public static double height;
    Player player1;
    Player player2;
    public GameBoard(){
        super (1000, 600);
        initTriangles();
        drawBoard();
        initPlayers();
        player1.drawDices();
        player1.drawCheckers();
        player2.drawCheckers();
    }

    public void initPlayers(){
        CheckersBox checkersBox1 = new CheckersBox();
        checkersBox1.setCoordinates(new Coordinates(width - homeBoxWidth - 2 * border,0,15,height));
        checkersBox1.setColor(java.awt.Color.GRAY);
        checkersBox1.setDirection(CheckersBox.Direction.DOWN);
        checkersBox1.setGc(gc);//5 3 5 2
        player1 = new Player(gc,new int[] { 6, 8, 13, 24 }, new int[] { 5, 3, 5, 2 }, checkersBox1, Color.GRAY, 15, true);
        player1.setTrianglesCoordinates(trianglesCoordinates);
        player1.createCheckers();
        player1.initDices();

        CheckersBox checkersBox2 = new CheckersBox();
        checkersBox2.setCoordinates(new Coordinates(width - homeBoxWidth - 2 * border,0,15,height));
        checkersBox2.setColor(java.awt.Color.BLACK);
        checkersBox2.setDirection(CheckersBox.Direction.UP);
        checkersBox2.setGc(gc);
        player2 = new Player(gc,new int[] { 19, 17, 12, 1 }, new int[] { 5, 3, 5, 2 }, checkersBox2, Color.BLACK,15, false);
        player2.setTrianglesCoordinates(trianglesCoordinates);
        player2.createCheckers();
        player2.initDices();
    }

    private void initTriangles() {
        Color[] boardColors = { Color.rgb(252,234,202), Color.rgb(66,43,3) };
        for (int i = 0; i < 6; i++)
        {
            boardTriangles.add (new BoardTriangle (boardColors[0], Direction.UP));
            boardTriangles.add (new BoardTriangle (boardColors[1], Direction.UP));
        }

        for (int i = 0; i < 6; i++)
        {
            boardTriangles.add (new BoardTriangle (boardColors[0], Direction.DOWN));
            boardTriangles.add (new BoardTriangle (boardColors[1], Direction.DOWN));
        }
    }

    public void drawBoard(){
        width = getWidth();
        height = getHeight();

        double boardWidth = width - homeBoxWidth - border;
        pointWidth = (boardWidth - barWidth - 2 * border) / 12;
        pointHeight = (height - 2 * border) / 2;
        barWidth = boardWidth - 12 * pointWidth - 2 * border;

        double x = border;
        double y = height - border - pointHeight;

        for(int i=11;i>=0;i--)
        {
            boardTriangles.get (i).setCoordinates (new Coordinates (x, y, pointWidth, pointHeight));
            trianglesCoordinates[i] = new Coordinates(x, y, pointWidth, pointHeight);
            x += pointWidth;
            if (i == 6)
                x += barWidth;
        }

        x = border;
        y = border;
        for(int i=12; i<24; i++)
        {
            boardTriangles.get (i).setCoordinates (new Coordinates (x, y, pointWidth, pointHeight));
            trianglesCoordinates[i] = new Coordinates(x, y, pointWidth, pointHeight);
            x += pointWidth;
            if (i == 17)
                x += barWidth;
        }

        double width = getWidth ();
        double height = getHeight ();
        gc.setFill (Color.rgb(242,193,128)); //table color
        gc.fillRect (0, 0, width, height);
        gc.setFill (Color.rgb(130,94,33));
        gc.fillRect (0, 0, width, border);
        gc.fillRect (0, height - border, width, border);
        gc.fillRect (0, 0, border, height);
        gc.fillRect (width - border, 0, border, height);
        gc.fillRect (width - homeBoxWidth - 2 * border, 0, 15, height);
        gc.fillRect ((border+width - homeBoxWidth - 2 * border)/2.0-12,0,12,height);
        gc.fillRect ((border+width - homeBoxWidth - 2 * border+25)/2.0-12,0,12,height);
        for (int i = 0; i <= 23; i++)
            boardTriangles.get(i).draw(gc);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void drawTurnMessage(Player player){
        String name = player.getName();
        String message = name + "'s turn";
        gc.setFill(Color.BLACK);
        gc.setFont(new Font(45));
        gc.fillText (message, 570, 310,300);
    }

    public void drawComputersTurnMessage(){
        String message = "Computer's turn";
        gc.setFill(Color.BLACK);
        gc.setFont(new Font(45));
        gc.fillText (message, 570, 310,300);
    }


    public void drawWinMessage(Player player)
    {
        String message = player.getName() + " win!";
        gc.setFill(Color.GREEN);
        gc.setFont(new Font(45));
        gc.fillText (message, 570, 310,300);
    }
}
