package laborator;

public class Lab7 {
    public static void main(String[] args)
    {
        Board board = new Board();
        Player player1 = new Player("Paul",board);
        Player player2 = new Player("Mihai",board);
        player1.start();
        player2.start();
        try
        {
            player1.join();
            player2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}
