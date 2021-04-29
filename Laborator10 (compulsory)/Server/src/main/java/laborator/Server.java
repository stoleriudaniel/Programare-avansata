package laborator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final int PORT = 8100;
    public static List<ClientThread> clients = new ArrayList<>();
    public static ExecutorService pool = Executors.newFixedThreadPool(10);
    private static boolean running;
    public Server() throws IOException{
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            while(isRunning()){
                if(isRunning()) {
                    System.out.println("[Server] Waiting for a client ...");
                    Socket socket = serverSocket.accept();
                    System.out.println("[Server] Connected!");
                    //new ClientThread(socket).run();
                    if(isRunning())
                    {
                        ClientThread clientThread = new ClientThread(socket);
                        clients.add(clientThread);
                        pool.execute(clientThread);
                    }
                }
            }
        } catch (IOException e)
        {
            System.err.println("Ooops... " + e);
        }
        finally {
            serverSocket.close();
        }
    }
    public static void main(String[] args) throws IOException
    {
        setRunning(true);
        Server server = new Server();
    }

    public static void setRunning(boolean running) {
        Server.running = running;
    }

    public static boolean isRunning() {
        return running;
    }
}
