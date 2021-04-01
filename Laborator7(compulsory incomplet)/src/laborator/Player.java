package laborator;

public class Player extends Thread{
    private String name;
    public Board board;
    public Player(String name, Board board){
        this.name=name;
        this.board=board;
    }

    @Override
    public void run() {
        synchronized (board)
        {
            board.testMethod(name);
        }
    }
}
