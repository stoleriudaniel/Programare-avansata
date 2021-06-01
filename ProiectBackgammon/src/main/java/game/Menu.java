package game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Menu {
    public BorderPane borderPane = new BorderPane ();
    private Scene scene;
    private Stage stage;
    public String option="";
    public Button btnStart = new Button("Start");

    public GridPane multiplayerGrid = new GridPane();
    public GridPane menuGrid = new GridPane();
    public TextField firstPlayerName = new TextField();
    public TextField secondPlayerName = new TextField();
    public Button btnMultiplayer = new Button("Multiplayer");
    public Button btnShowTop = new Button("Top");
    public Button btnExit = new Button("Exit");
    public Button btnStartMultiplayer = new Button("Start");
    public Button btnBackFromMultiplayer = new Button("Back");
    public Menu(Stage stage){
        this.stage=stage;
        borderPane.setPrefWidth (450);
        borderPane.setPrefHeight (225);
        initSizeButtons();
        initMenuGrid();
        initMultiplayerGrid();
        borderPane.setCenter(menuGrid);
        scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Project: Backgammon - Menu");
        stage.centerOnScreen();
    }

    public void show() {
        stage.show();
        btnMultiplayer.setOnAction(e -> {
            borderPane.setCenter(multiplayerGrid);
        });
        btnBackFromMultiplayer.setOnAction(e -> {
            borderPane.setCenter(menuGrid);
        });
        btnStartMultiplayer.setOnAction(e -> {
            System.out.println("clicked");
            if(firstPlayerName.getText().length()>0 && secondPlayerName.getText().length()>0)
            {
                System.out.println("here");
                option="MULTIPLAYER";
                stage.close();
            }
        });
        btnExit.setOnAction(e -> {
            option="EXIT";
            stage.close();
        });
        if(option.equals("EXIT"))
        {
            stage.close();
        }
    }

    public void initSizeButtons() {
        btnStart.setPrefWidth(100);
        btnStart.setPrefHeight(40);

        btnMultiplayer.setPrefWidth(100);
        btnMultiplayer.setPrefHeight(40);

        btnStartMultiplayer.setPrefWidth(100);
        btnStartMultiplayer.setPrefHeight(40);

        btnBackFromMultiplayer.setPrefWidth(100);
        btnBackFromMultiplayer.setPrefHeight(40);

        btnShowTop.setPrefWidth(100);
        btnShowTop.setPrefHeight(40);

        btnExit.setPrefWidth(100);
        btnExit.setPrefHeight(40);
    }

    public void initMenuGrid(){
        menuGrid.setVgap(10);
        menuGrid.setHgap(10);
        menuGrid.setPadding (new Insets(50, 50, 50, 170));
        menuGrid.add(btnMultiplayer,0,0);
        menuGrid.add(btnShowTop,0,1);
        menuGrid.add(btnExit,0,2);
    }

    public void initMultiplayerGrid(){
        multiplayerGrid.setHgap(10);
        multiplayerGrid.setVgap(10);
        multiplayerGrid.setPadding(new Insets(30, 20, 50, 80));
        Label multiplayerGame = new Label("Multiplayer Game");
        multiplayerGame.setFont(Font.font("Courier", FontWeight.BOLD,15));
        multiplayerGrid.add(multiplayerGame,0,0);
        multiplayerGrid.add(new Label("first player name:"),0,1);
        multiplayerGrid.add(firstPlayerName,1,1);
        multiplayerGrid.add(new Label("second player name:"),0,2);
        multiplayerGrid.add(secondPlayerName,1,2);
        multiplayerGrid.add(btnStartMultiplayer,0,3);
        multiplayerGrid.add(btnBackFromMultiplayer,1,3);
    }
}
