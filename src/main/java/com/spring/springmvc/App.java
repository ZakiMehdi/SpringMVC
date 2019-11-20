package com.spring.springmvc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // Create a variable for the connection string.
        
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("pwd@123");
        ds.setServerName("DESKTOP-N1ONR3Q");
        ds.setPortNumber(1433);
        ds.setDatabaseName("GL");

       // String connectionUrl = "jdbc:sqlserver://DESKTOP-N1ONR3Q:1433;databaseName=GL;user=sa;password=pwd@123";

       // try (Connection con = DriverManager.getConnection(connectionUrl);
        		try(Connection con = ds.getConnection();Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM EMPLOYEE";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("Name") + " ");
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
