package com.laborator.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private static Connection connection = null;
    private static String url;
    private static String driver;
    private static String user;
    private static String password;
    private static Singleton instance = null;
    private Singleton(){}
    public static Connection getConnection(){
        if(connection!=null){
            return connection;
        }
        try {
            connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
        }
        catch (SQLException e){
            System.err.println("SQLException:" + e);
        }
        return connection;
    }
    public static Singleton getInstance()
    {
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
    public static void setConnection(Connection con) {
        connection = con;
    }
    public static String getUrl(){
        return url;
    }
    public static void setUrl(String newUrl){
        url=newUrl;
    }
    public static String getPassword() {
        return password;
    }

    public static String getUser() {
        return user;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setUser(String user) {
        Singleton.user = user;
    }

    public static void setPassword(String password) {
        Singleton.password = password;
    }

    public static void setDriver(String driver) {
        Singleton.driver = driver;
    }
}