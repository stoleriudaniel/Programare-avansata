package laborator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Genres {
    private static String sqlFindByID;
    private static String sqlFindByName;
    private static String sqlInsert;
    public Genres(){
        init();
    }
    public static void init(){
        sqlInsert="INSERT INTO genres(name) VALUES(?)";
        sqlFindByID="SELECT * FROM genres WHERE id=?";
        sqlFindByName="SELECT * FROM genres WHERE name=?";
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
    public static void findByName(String name, Connection con){
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlFindByName);
            pstmt.setString(1, name);
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
    public static void insertNewRow(String name, Connection con){
        try{
            PreparedStatement pstmt = con.prepareStatement(sqlInsert);
            pstmt.setString(1,name);
            pstmt.execute();
        }
        catch (Exception e)
        {
            System.err.println("Exception: " + e);
        }
    }
}
