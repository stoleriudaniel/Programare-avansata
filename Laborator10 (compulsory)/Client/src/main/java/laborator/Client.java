package laborator;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException
    {
        String serverAdress = "127.0.0.1";
        boolean running=true;
        int PORT = 8100;
        try(
                Socket socket = new Socket(serverAdress,PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            while(running) {
                System.out.println(in.readLine());
                Scanner keyboardScanner = new Scanner(System.in);
                out.println(keyboardScanner.nextLine());
            }
        }
        catch (UnknownHostException e)
        {
            System.err.println("No server listening..." + e);
        }
    }

}
