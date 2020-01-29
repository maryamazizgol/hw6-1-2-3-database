package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int code;
        String name;
        String email;
        int password;
        int age;
        String education;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        Scanner scanner6 = new Scanner(System.in);

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection =
                DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                        , "maryam", "JAVA");
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into information (code,name,email,password,age" +
                        ",education) values (?,?,?,?,?,?,?,?)");
        for (int i = 0; i < 5; i++) {
            System.out.println(" student code : ");
            code = scanner.nextInt();
            System.out.println("name : ");
            name = scanner2.nextLine();
            System.out.println(" email : ");
            email = scanner3.nextLine();
            System.out.println("pass : ");
            password = scanner4.nextInt();
            System.out.println("age : ");
            age = scanner5.nextInt();
            System.out.println("education: ");
            education = scanner6.nextLine();
            preparedStatement.setLong(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setLong(4, password);
            preparedStatement.setLong(5, age);
            preparedStatement.setString(6, education);
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
        connection.close();
    }
}
