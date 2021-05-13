package laborator;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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
                String serverResponse="";
                while(running) {
                    try {
                        serverResponse = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Ooops...");
                        running = false;
                        break;
                    }
                    if (serverResponse.equals("[Server] Server stopped ...")
                                || serverResponse.equals("[Server] Command failed! Server stopped ...")
                                || serverResponse.equals("[Server] Failed! Server stopped ...")
                                || serverResponse.equals("[Server] Stopped ...")
                                || serverResponse.equals("[Server] Exit ...")) {
                        running=false;
                        System.out.println(serverResponse);
                        break;
                    }
                    else if(serverResponse.length()==0) {
                        running=false;
                        break;
                    }
                    else System.out.println(serverResponse);
                    Scanner keyboardScanner = new Scanner(System.in);
                    String line = keyboardScanner.nextLine();
                    out.println(line);
                }
        }
        catch (UnknownHostException e)
        {
            System.err.println("No server listening..." + e);
        }
    }

}
