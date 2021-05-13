package laborator;

import laborator.dao.Users;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Server {
    public static final int PORT = 8100;
    public static List<ClientThread> clients = new ArrayList<>();
    public static ExecutorService pool = Executors.newFixedThreadPool(10);
    private boolean running;
    private ServerSocket serverSocket = null;
    private static Singleton singleton;
    public Server() throws IOException{
        singleton = Singleton.getInstance();
        singleton.setUrl("jdbc:mysql://localhost:3307/mydb");
        singleton.setUser("user1");
        singleton.setPassword("STUDENT");
        running=true;
        //PerformSFTP performSFTP = new PerformSFTP();
        //performSFTP.perform();
        try{
            FreeChart freeChart = new FreeChart(this);
            freeChart.show();
            serverSocket = new ServerSocket(PORT);
            while(isRunning()){
                if(isRunning()) {
                    System.out.println("[Server] Waiting for a client ...");
                    Socket socket = serverSocket.accept();
                    System.out.println("[Server] Connected!");
                    if(isRunning())
                    {
                        ClientThread clientThread = new ClientThread(this,socket);
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
            if(serverSocket!=null) {
                serverSocket.close();
            }
        }
    }
    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
    }

    public boolean isRunning() {
        return running;
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
