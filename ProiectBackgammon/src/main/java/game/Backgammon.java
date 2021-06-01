package game;

import dao.gameUsers;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Backgammon extends Application
{
    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;
    private static Singleton singleton;
    private final BorderPane borderPane = new BorderPane ();
    private Game game;
    private Stage primaryStage;
    private FreeChart freeChart;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu menu = new Menu(primaryStage);
        menu.show();
        freeChart = new FreeChart(singleton);
        menu.btnShowTop.setOnAction(e -> {
            freeChart.show();
        });
        menu.btnStartMultiplayer.setOnAction(e -> {
            String namePlayer1 = menu.firstPlayerName.getText();
            String namePlayer2 = menu.secondPlayerName.getText();
            if(namePlayer1.length()>0 && namePlayer2.length()>0) {
                if(!gameUsers.existsUser(namePlayer1,singleton.getConnection()))
                {
                    gameUsers.insertNewUser(namePlayer1,0,singleton.getConnection());
                }
                if(!gameUsers.existsUser(namePlayer2,singleton.getConnection()))
                {
                    gameUsers.insertNewUser(namePlayer2,0,singleton.getConnection());
                }
                game = new Game(primaryStage,singleton,namePlayer1,namePlayer2);
                this.primaryStage = primaryStage;
                this.primaryStage.setTitle("Project: Backgammon - Menu");
                Pane wrapperPane = new Pane();
                borderPane.setCenter(wrapperPane);

                GameBoard board = game.getBoard();
                wrapperPane.getChildren().add(board);
                Scene scene = new Scene(borderPane);
                primaryStage.setScene(scene);
                board.setOnMouseClicked(ee -> {
                    game.mousePressed(ee);
                });
                primaryStage.centerOnScreen();
                primaryStage.show();
            }
        });
    }

    public static void main (String[] args)
    {
        singleton.setUrl("jdbc:mysql://localhost:3307/mydb");
        singleton.setUser("user1");
        singleton.setPassword("STUDENT");
        singleton = Singleton.getInstance();
        Application.launch (args);
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
