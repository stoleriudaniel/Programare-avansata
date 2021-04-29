package laborator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    private String command;
    public ClientThread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try{
            while(true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println("[Server] Introduceti comanda...");
                setCommand(in.readLine());
                if(getCommand().equals("Stop"))
                {
                    System.out.println("Stop");
                    Server.setRunning(false);
                }
            }
        }
        catch (IOException e)
        {
            System.err.println("Comunication error... " + e);
        }
        finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
