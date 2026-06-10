package com.JDBC;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /* Class.forName("com.mysql.cj.jdbc.Driver"); needed to load and register the driver for older way but doesn't require for maven.
        */
        //Establish connection
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url,user,password);
        //creating statement
        Statement statement = connection.createStatement();
        //execute the statement
        ResultSet resultSet = statement.executeQuery("select * from studentInfo");
        //process the result
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " +
                    resultSet.getString("sname") + " " +
                    resultSet.getInt("sage") + " " +
                    resultSet.getString("scity"));
        }
        // close the connection
        statement.close();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the number of data to be inserted");
        int count = scanner.nextInt();
        while(count>0) {
            System.out.println("Enter student name");
            String sname = scanner.next();
            System.out.println("Enter student sage");
            int sage = scanner.nextInt();
            System.out.println("Enter student scity");
            String scity = scanner.next();
            /* PreparedStatement created
               Use prepared statement to prevent sql injection
             */
            String sql = "INSERT INTO studentInfo (sname, sage, scity) VALUES ( ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sname);
            ps.setInt(2, sage);
            ps.setString(3, scity);
            //PreparedStatement executed.
            int rows = ps.executeUpdate();
            //close the prepared statement
                ps.close();
                //decrement the counter
                count--;

            }



        //update the database
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Information update format 'index:fieldName:fieldValue' ");
        try {
                String update = bufferedReader.readLine();
                StringTokenizer stringTokenizer = new StringTokenizer(update,":");
                int index = Integer.parseInt(stringTokenizer.nextToken());
                System.out.println(index + " ");
                String fieldName = stringTokenizer.nextToken();
                System.out.println(fieldName + " ");
                String fieldValue = stringTokenizer.nextToken();
                System.out.println(fieldValue + " ");
                String sql = "UPDATE studentInfo SET " + fieldName + " = ? WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);

               // ps.setString(1, fieldName);
                ps.setString(1, fieldValue);
                ps.setInt(2, index);
            System.out.println(ps + " ");
                int rows = ps.executeUpdate();

            }
        catch(Exception e) {
                System.out.println(e.getMessage());
            }



        connection.close();
    }

}


