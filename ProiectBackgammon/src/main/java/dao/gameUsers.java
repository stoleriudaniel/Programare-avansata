package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class gameUsers {
    private final static String sqlInsertNewUser="INSERT INTO game_users(name,wins) VALUES(?,?)";
    private final static String sqlIncrementUserWins="UPDATE game_users SET wins=wins+1 WHERE name=?";
    private final static String sqlDeleteAllUsers="DELETE FROM game_users";
    private final static String sqlDeleteUser="DELETE FROM game_users WHERE name=?";
    private final static String sqlFindByName="SELECT * FROM game_users WHERE name=?";
    public gameUsers(){}

    public static void insertNewUser(String name, int wins, Connection connection) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlInsertNewUser);
            pstmt.setString(1,name);
            pstmt.setInt(2,wins);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
    }

    public static void incrementUserWins(String name, Connection connection){
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlIncrementUserWins);
            pstmt.setString(1,name);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
    }

    public static void deleteAllUsers(Connection connection){
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlDeleteAllUsers);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
    }

    public static void deleteUser(String name, Connection connection){
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlDeleteUser);
            pstmt.setString(1,name);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
    }

    public static boolean existsUser(String userName, Connection con){
        int row=0;
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlFindByName);
            pstmt.setString(1, userName);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next()) {
                row = resultSet.getRow();
            }
        }
        catch (Exception e)
        {
            System.err.println("Exception: " + e);
        }
        return row>0;
    }
}
