package laborator;

import laborator.dao.Users;
import laborator.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ClientThread extends Thread{
    private Socket socket = null;
    private String command="";
    private final Server server;
    private User user;
    private boolean logged=false;
    private boolean running=true;
    private boolean alreadySentResponse=false;
    private String friendMsg="No message.";
    private boolean timeOccured=false;
    public ClientThread(Server server, Socket socket){
        this.server=server;
        this.socket=socket;
    }
    public void run(){
        String response="";
        String request="";
        try{
            while(running) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                if(!server.isRunning()){
                    out.println("[Server] Server stopped ...");
                    running=false;
                    logged=false;
                    break;
                }
                else {
                    if (getCommand().isEmpty()) {
                        response = "[Server] Write the command ...";
                    } else {
                        response = "[Server] Received the request. Write a new command ...";
                    }
                    if(!alreadySentResponse) {
                        out.println(response);
                    }
                    alreadySentResponse=false;
                    try {
                        request = CompletableFuture.supplyAsync(() -> {
                            try {
                                return in.readLine();
                            } catch (IOException e) {
                                System.out.println("Socket closed ...");
                            }
                            return null;
                        }).get(5, TimeUnit.MINUTES);
                    } catch (TimeoutException e) {
                        System.out.println("Time out has occurred");
                        running=false;
                        timeOccured=true;
                        break;
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("Oops .. " + e);
                    }
                    if (!server.isRunning()) {
                        out.println("[Server] Command failed! Server stopped ...");
                        running=false;
                        logged=false;
                        break;
                    }
                    if (request.equals("Login")) {
                        if(!server.isRunning()){
                            out.println("[Server] Failed! Server stopped ...");
                            running=false;
                            logged=false;
                            break;
                        }
                        if (logged) {
                            response = "[Server] Already logged in. Write the command ...";
                            out.println(response);
                        } else {
                            setCommand("Login");
                            String userName="", password="";
                            response = "[Server] Enter the username:";
                            out.println(response);
                            try {
                                userName = CompletableFuture.supplyAsync(() -> {
                                    try {
                                        return in.readLine();
                                    } catch (IOException e) {
                                        System.out.println("Socket closed ...");
                                    }
                                    return null;
                                }).get(5, TimeUnit.MINUTES);
                            } catch (TimeoutException e) {
                                System.out.println("Time out has occurred");
                                running=false;
                                timeOccured=true;
                                break;
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Oops .. " + e);
                            }
                            response = "[Server] Enter the password:";
                            out.println(response);
                            try {
                                password = CompletableFuture.supplyAsync(() -> {
                                    try {
                                        return in.readLine();
                                    } catch (IOException e) {
                                        System.out.println("Socket closed ...");
                                    }
                                    return null;
                                }).get(5, TimeUnit.MINUTES);
                            } catch (TimeoutException e) {
                                System.out.println("Time out has occurred");
                                running=false;
                                timeOccured=true;
                                break;
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Oops .. " + e);
                            }
                            if (!server.isRunning()) {
                                out.println("[Server] Failed! Server stopped ...");
                                running=false;
                                logged=false;
                                break;
                            }
                            if (Users.existsUser(userName, server.getSingleton().getConnection())
                                    && Users.validPassword(userName, password, server.getSingleton().getConnection()))
                            {
                                user = new User(userName, password);
                                logged = true;
                                Users.incrementUserConnectionTimes(userName,server.getSingleton().getConnection());
                                response = "[Server] Succesfully logged in! Write the command ...";
                                out.println(response);
                                alreadySentResponse=true;
                            } else {
                                response = "[Server] Invalid account! Write the command ...";
                                out.println(response);
                                alreadySentResponse=true;
                            }
                        }
                    }
                    else if(request.equals("Register")) {
                        if(!server.isRunning()){
                            out.println("[Server] Failed! Server stopped ...");
                            logged=false;
                            running=false;
                            break;
                        }
                        if(logged==true)
                        {
                            response="[Server] Cannot register, already logged in. Write the command ...";
                            out.println(response);
                            alreadySentResponse=true;
                        }
                        else {
                            setCommand("Register");
                            String userName="", password="";
                            response = "[Server] Enter the username:";
                            out.println(response);
                            try {
                                userName = CompletableFuture.supplyAsync(() -> {
                                    try {
                                        return in.readLine();
                                    } catch (IOException e) {
                                        System.out.println("Socket closed ...");
                                    }
                                    return null;
                                }).get(5, TimeUnit.MINUTES);
                            } catch (TimeoutException e) {
                                System.out.println("Time out has occurred");
                                running=false;
                                timeOccured=true;
                                break;
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Oops .. " + e);
                            }
                            response = "[Server] Enter the password:";
                            out.println(response);
                            try {
                                password = CompletableFuture.supplyAsync(() -> {
                                    try {
                                        return in.readLine();
                                    } catch (IOException e) {
                                        System.out.println("Socket closed ...");
                                    }
                                    return null;
                                }).get(5, TimeUnit.MINUTES);
                            } catch (TimeoutException e) {
                                System.out.println("Time out has occurred");
                                running=false;
                                timeOccured=true;
                                break;
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Oops .. " + e);
                            }
                            if (!server.isRunning()) {
                                out.println("[Server] Failed! Server stopped ...");
                                running=false;
                                logged = false;
                                break;
                            }
                            if (Users.existsUser(userName, server.getSingleton().getConnection())) {
                                response = "[Server] User already exists. Write the command ...";
                                out.println(response);
                                alreadySentResponse = true;
                            } else {
                                Users.insertNewUserAccount(userName, password, server.getSingleton().getConnection());
                                response = "[Server] Registration succesfully! Write the command ...";
                                out.println(response);
                                alreadySentResponse=true;
                            }
                        }
                    }
                    else {
                        response = "[Server] Invalid command! Write the command ...";
                        out.println(response);
                        alreadySentResponse=true;
                    }
                    while (logged) {
                        try {
                            request = CompletableFuture.supplyAsync(() -> {
                                try {
                                    return in.readLine();
                                } catch (IOException e) {
                                    System.out.println("Socket closed ...");
                                }
                                return null;
                            }).get(5, TimeUnit.MINUTES);
                        } catch (TimeoutException e) {
                            System.out.println("Time out has occurred");
                            running=false;
                            timeOccured=true;
                            break;
                        } catch (InterruptedException | ExecutionException e) {
                            System.out.println("Oops .. " + e);
                        }
                        if(!server.isRunning()){
                            out.println("[Server] Failed! Server stopped ...");
                            logged=false;
                            running=false;
                            break;
                        } else if (request.equals("Register")) {
                            response = "[Server] Cannot register, already logged in. Write the command ...";
                            out.println(response);
                        } else if(request.equals("AddFriend")){
                            response="[Server] Write the username: ";
                            out.println(response);
                            String friendName = "";
                            try {
                                friendName = CompletableFuture.supplyAsync(() -> {
                                    try {
                                        return in.readLine();
                                    } catch (IOException e) {
                                        System.out.println("Socket closed ...");
                                    }
                                    return null;
                                }).get(5, TimeUnit.MINUTES);
                            } catch (TimeoutException e) {
                                System.out.println("Time out has occurred");
                                running=false;
                                timeOccured=true;
                                break;
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Oops .. " + e);
                            }
                            if(!server.isRunning()) {
                                out.println("[Server] Failed! Server stopped ...");
                                logged = false;
                                running=false;
                                alreadySentResponse=true;
                                break;
                            }
                            if(!Users.existsUser(friendName,server.getSingleton().getConnection()))
                            {
                                response = "[Server] User does not exists! Write the command ...";
                                out.println(response);
                            }
                            else{
                                Users.insertNewFriend(user.getUserName(),friendName,server.getSingleton().getConnection());
                                Users.insertNewFriend(friendName,user.getUserName(),server.getSingleton().getConnection());
                                response = "[Server] Friend added! Write the command ...";
                                out.println(response);
                            }
                        } else if(request.equals("Send")){
                            response = "[Server] Write the message to friends ...";
                            out.println(response);
                            String msg = "";
                            try {
                                msg = CompletableFuture.supplyAsync(() -> {
                                    try {
                                        return in.readLine();
                                    } catch (IOException e) {
                                        System.out.println("Socket closed ...");
                                    }
                                    return null;
                                }).get(5, TimeUnit.MINUTES);
                            } catch (TimeoutException e) {
                                System.out.println("Time out has occurred");
                                running=false;
                                timeOccured=true;
                                break;
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Oops .. " + e);
                            }
                            String[] friends = Users.getUserFriends(user.getUserName(),server.getSingleton().getConnection());
                            for(String friend : friends)
                            {
                                for(int index=0;friend!=null && index<server.clients.size();index++)
                                    if(server.clients.get(index).user.getUserName().equals(friend))
                                    {
                                        server.clients.get(index).setFriendMsg("Message from " + user.getUserName() + ": "+ msg);
                                    }
                            }
                            response = "[Server] The message has been sent! Write the command ...";
                            out.println(response);
                        } else if(request.equals("Read")){
                            response = getFriendMsg();
                            out.println("[Server] "+ response + "  Write the command ...");
                        } else if (request.equals("Stop")) {
                            setCommand("Stop");
                            response = "[Server] Stopped ...";
                            out.println(response);
                            logged=false;
                            running=false;
                            break;
                        } else if (request.equals("Exit")) {
                            setCommand("Exit");
                            response = "[Server] Exit ...";
                            out.println(response);
                            logged=false;
                            running=false;
                            break;
                        }
                        else {
                            response="[Server] Invalid command! Write the command ...";
                            out.println(response);
                            alreadySentResponse=true;
                        }
                    }
                    if(!server.isRunning() && alreadySentResponse==false){
                        out.println("[Server] Server stopped ...");
                        logged=false;
                        running=false;
                        break;
                    }
                }
            }
            logged=false;
            if(getCommand().equals("Stop"))
            {
                server.stop();
                server.pool.shutdown();
            }
            if(timeOccured)
            {
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println("[Server] Time occured ...");
            }
        }
        catch (IOException e)
        {
            System.err.println("Comunication error... " + e);
        }
        finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println ("Socket closed"); }
        }
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setFriendMsg(String friendMsg) {
        this.friendMsg = friendMsg;
    }

    public String getFriendMsg() {
        return friendMsg;
    }
}
