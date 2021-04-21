package laborator.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Movies {
    private static String sqlFindByID;
    private static String sqlFindByTitle;
    private static String sqlInsert;
    public Movies(){
        init();
    }

    public static void init(){
        sqlInsert="INSERT INTO movies(title,release_date,duration,score) VALUES(?,?,?,?)";
        sqlFindByID="SELECT * FROM movies WHERE id=?";
        sqlFindByTitle="SELECT * FROM movies WHERE title=?";
    }

    public static void findByID(int id, Connection con){
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlFindByID);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnNumbers = rsmd.getColumnCount();
            while(resultSet.next()){
                for(int i=1;i<=columnNumbers;i++)
                {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Exception: " + e);
        }
    }
    public static void findByTitle(String title, Connection con){
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlFindByTitle);
            pstmt.setString(1, title);
            ResultSet resultSet = pstmt.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnNumbers = rsmd.getColumnCount();
            while(resultSet.next()){
                for(int i=1;i<=columnNumbers;i++)
                {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Exception: " + e);
        }
    }
    public static void insertNewRow(String title, String releaseDate, int duration, int score, Connection con) {
        try {
            System.out.println("title:"+title);
            System.out.println("releaseDate:"+releaseDate);
            System.out.println("duration:"+duration);
            System.out.println("score:"+score);
            System.out.println("#########################################################");
            PreparedStatement pstmt = con.prepareStatement(sqlInsert);
            pstmt.setString(1, title);
            pstmt.setDate(2, java.sql.Date.valueOf(releaseDate));
            pstmt.setInt(3, duration);
            pstmt.setInt(4, score);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }
}
