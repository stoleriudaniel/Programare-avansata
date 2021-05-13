package com.laborator.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Persons {
    private final static String sqlFindById="SELECT name FROM persons WHERE id=?";
    private final static String sqlDeletePerson="DELETE FROM persons WHERE id=?";
    WHERE condition;
    public Persons(){}
    public static String findById(int id, Connection connection)
    {
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlFindById);
            pstmt.setInt(1,id);
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            return resultSet.getString(1);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
        return "";
    }

    public static void delete(int id, Connection connection)
    {
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlDeletePerson);
            pstmt.setInt(1,id);
            pstmt.execute();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            System.out.println("Function complete.");
        }
    }
}
