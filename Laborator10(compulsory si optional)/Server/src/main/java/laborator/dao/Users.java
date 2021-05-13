package laborator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Users {
    private final static String sqlInsertNewUserAccount="INSERT INTO users(user_name,password) VALUES(?,?)";
    private final static String sqlInsertNewFriend="INSERT INTO userfriends(user_name,friend_user_name) VALUES(?,?)";
    private final static String sqlFindByName="SELECT * FROM users WHERE user_name=?";
    private final static String sqlFindPasswordByName="SELECT password FROM users WHERE user_name=?";
    private final static String sqlFindFriends="SELECT friend_user_name FROM userfriends WHERE user_name=?";
    private final static String sqlInsertNewUserInUsersConnectionTimesTable="INSERT INTO usersconnectiontimes(user_name,connected_times) VALUES(?,?)";
    private final static String sqlIncrementUserConnectionTimes="UPDATE usersconnectiontimes SET connected_times=connected_times+1 WHERE user_name=?";
    public Users(){}

    public static void insertNewUserAccount(String userName, String password, Connection connection) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlInsertNewUserAccount);
            pstmt.setString(1,userName);
            pstmt.setString(2,password);
            pstmt.execute();
            pstmt = connection.prepareStatement(sqlInsertNewUserInUsersConnectionTimesTable);
            pstmt.setString(1,userName);
            pstmt.setInt(2,0);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
    }

    public static String[] getUserFriends(String userName, Connection connection)
    {
        String[] friends = new String[10];
        int index=0;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlFindFriends);
            pstmt.setString(1,userName);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next())
            {
                friends[index]=resultSet.getString(1);
                index++;
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
        return friends;
    }

    public static void insertNewFriend(String userName, String friendName, Connection connection)
    {
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlInsertNewFriend);
            pstmt.setString(1,userName);
            pstmt.setString(2,friendName);
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

    public static boolean validPassword(String userName, String password, Connection con){
        boolean validity=false;
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlFindPasswordByName);
            pstmt.setString(1, userName);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next()) {
                validity = resultSet.getString(1).equals(password);
            }
        }
        catch (Exception e)
        {
            System.err.println("Exception: " + e);
        }
        return validity;
    }

    public static void incrementUserConnectionTimes(String userName, Connection con){
        try{
            PreparedStatement pstmt = con.prepareStatement(sqlIncrementUserConnectionTimes);
            pstmt.setString(1,userName);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }
}
