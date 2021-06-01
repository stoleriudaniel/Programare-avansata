package game;

import dao.gameUsers;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
public class Game {
    protected final Stage stage;
    protected GameBoard gameBoard;
    protected Player player1;
    protected Player player2;
    private Singleton singleton;
    public Game(Stage stage, Singleton singleton, String namePlayer1, String namePlayer2) {
        this.stage=stage;
        this.singleton=singleton;
        gameBoard = new GameBoard ();
        gameBoard.getPlayer1().setName(namePlayer1);
        gameBoard.getPlayer2().setName(namePlayer2);
        player1 = gameBoard.getPlayer1();
        player2 = gameBoard.getPlayer2();
        gameBoard.drawTurnMessage(player1);
    }

    public void refreshBoard(){
        gameBoard.gc.clearRect(0,0,gameBoard.getWidth(),gameBoard.getHeight());
        gameBoard.drawBoard();
        gameBoard.player1.drawCheckers();
        gameBoard.player1.getCheckersBox().drawCheckers();
        gameBoard.player2.drawCheckers();
        gameBoard.player2.getCheckersBox().drawCheckers();
        if(gameBoard.player1.getCheckersCount()>0 && gameBoard.player2.getCheckersCount()>0) {
            if (gameBoard.player1.isCurrent()) {
                gameBoard.player1.drawDices();
                gameBoard.player1.getCurrentDice().drawMark(gameBoard.player1.getGc());
                if (gameBoard.player1.getCheckersCount() > 0) {
                    gameBoard.drawTurnMessage(gameBoard.player1);
                }
            } else if (gameBoard.player2.isCurrent()) {
                gameBoard.player2.drawDices();
                gameBoard.player2.getCurrentDice().drawMark(gameBoard.player1.getGc());
                if (gameBoard.player2.getCheckersCount() > 0) {
                    gameBoard.drawTurnMessage(gameBoard.player2);
                }
            }
        }
        else if(gameBoard.player1.getCheckersCount()==0)
        {
            gameBoard.drawWinMessage(player1);
            gameUsers.incrementUserWins(player1.getName(),singleton.getConnection());
        }
        else if(gameBoard.player2.getCheckersCount()==0)
        {
            gameBoard.drawWinMessage(player2);
            gameUsers.incrementUserWins(player2.getName(),singleton.getConnection());
        }
    }

    GameBoard getBoard ()
    {
        return gameBoard;
    }

    protected void mousePressed (MouseEvent e)
    {
        player1 = gameBoard.getPlayer1();
        player2 = gameBoard.getPlayer2();
        if(player1.getCurrentCheckersCount()>0 && player1.isCurrent() && gameBoard.player1.isClickOnChecker(e.getX(),e.getY())) {
            System.out.println("player1: checker click true");
            Checker checker = player1.getCheckerClicked(e.getX(),e.getY());
            if(player2.isOpponentColumn(player1,checker)) {
                if (player2.canMoveToOpponentColumn(player1, checker)){
                    player1.moveChecker(checker);
                    //player1.reverseCheckers();
                    //player2.reverseCheckers();
                    if(player1.existsNextDice())
                    {
                        player1.setNextDiceToCurrent();
                    }
                    else{
                        player1.setCurrent(false);
                        player2.setCurrent(true);
                        player2.initDices();
                        player1.reverseCheckers();
                        player2.reverseCheckers();
                    }
                }
                else{
                    System.out.println("Mutare invalida, coloana oponentului!");
                }
            }
            else if(player1.canMove(checker,player1))
            {
                player1.moveChecker(checker);
                if(player1.existsNextDice())
                {
                    player1.setNextDiceToCurrent();
                }
                else{
                    player1.setCurrent(false);
                    player2.setCurrent(true);
                    player2.initDices();
                    player1.reverseCheckers();
                    player2.reverseCheckers();
                }
            }
        }
        else if(player2.getCurrentCheckersCount()>0 && player2.isCurrent() && gameBoard.player2.isClickOnChecker(e.getX(),e.getY()))
        {
            System.out.println("player2: checker click true");
            Checker checker = player2.getCheckerClicked(e.getX(),e.getY());
            if(player1.isOpponentColumn(player2,checker)) {
                if (player1.canMoveToOpponentColumn(player2, checker)){
                    player2.moveChecker(checker);
                    if(player2.existsNextDice())
                    {
                        player2.setNextDiceToCurrent();
                    }
                    else{
                        player1.setCurrent(true);
                        player2.setCurrent(false);
                        player1.initDices();
                        player1.reverseCheckers();
                        player2.reverseCheckers();
                    }
                }
                else{
                    System.out.println("Mutare invalida, coloana oponentului!");
                }
            }
            else if(player2.canMove(checker,player2))
            {
                player2.moveChecker(checker);
                if(player2.existsNextDice())
                {
                    player2.setNextDiceToCurrent();
                }
                else{
                    player1.setCurrent(true);
                    player2.setCurrent(false);
                    player1.initDices();
                    player1.reverseCheckers();
                    player2.reverseCheckers();
                }
            }
        }
        else System.out.println("checker click false");
        System.out.println("player1 count checkers:"+gameBoard.player1.getCurrentCheckersCount());
        System.out.println("player2 count checkers:"+gameBoard.player2.getCurrentCheckersCount());
        refreshBoard();
    }
}