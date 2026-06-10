package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbclearning",
                    "root",
                    "1234"
            );

            StudentDAO dao = new StudentDAO(connection);

            Scanner sc = new Scanner(System.in);

            // INSERT
            System.out.println("Enter name:");
            String name = sc.next();

            System.out.println("Enter age:");
            int age = sc.nextInt();

            System.out.println("Enter city:");
            String city = sc.next();

            Student student = new Student(name, age, city);
            dao.insertStudent(student);

            // DISPLAY
            dao.getAllStudents();

            // UPDATE
            System.out.println("Update format: id field value");
            int id = sc.nextInt();
            String field = sc.next();
            String value = sc.next();

            dao.updateStudent(id, field, value);

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
