package laborator;

import java.util.Map;
import java.util.Random;

public class Board{
    private int tokensNumber;
    private Map<Integer, Integer> tokens;
    public Board(){

    }
    public Board(int tokensNumber){
        this.tokensNumber=tokensNumber;
        init();
    }
    public void init()
    {
        Random rand = new Random();
        for(int index=0;index<tokensNumber;index++) {
            int randValue = rand.nextInt(500) + 1;
            tokens.put(index,randValue);
        }
    }
    public synchronized void testMethod(String msg)
    {
        System.out.println("Sending  "  + msg );
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("msg: " + msg);
    }
}
