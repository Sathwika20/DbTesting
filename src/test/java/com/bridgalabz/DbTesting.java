package com.bridgalabz;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class DbTesting {

    @BeforeTest
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/dbTesting";
        String user = "root";
        String password = "sathWIKA@20";
        Connection connection = DriverManager.getConnection(url, user, password);
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        return connection;
    }
    @Test
    public void get_table() throws SQLException, ClassNotFoundException {
        Connection connection = this.getConnection();
        String sql = "select *  from studentdata";
        Statement stmt = connection.createStatement();
        ResultSet rs= stmt.executeQuery(sql);
        while (rs.next()) {
            String studentID = rs.getString(1);
            String studentName = rs.getString(2);
            String studentEmail = rs.getString(3);
            String studentPhoneNumber = rs.getString(4);
            System.out.println(studentID + "  " + studentName + "  " + studentEmail + "  " + studentPhoneNumber);
        }
    }
    @Test
    public void insert_into_table() throws SQLException, ClassNotFoundException{
        Connection connection = this.getConnection();
         Statement stmt = connection.createStatement();
        stmt.execute("INSERT INTO studentdata (studentID,studentName,studentEmail,studentPhoneNumber) "
                + "VALUES (6,'Lokesh','lokesh@gmail.com','8945671290')");
    }
    @Test
    public void delete_row() throws SQLException, ClassNotFoundException{
        Connection connection = this.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM studentdata WHERE studentID = 6");

    }
    @Test
    public void update_table() throws SQLException, ClassNotFoundException{
        Connection connection = this.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE studentdata SET studentName = 'Manasa' WHERE studentID = 5");
        stmt.execute("UPDATE studentdata SET studentEmail = 'manasa@gmail.com' WHERE studentID = 5");
    }


}







