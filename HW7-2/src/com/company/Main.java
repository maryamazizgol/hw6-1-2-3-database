package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws  Exception {

        Scanner scanner = new Scanner(System.in);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "MARYAM", "JAVA");


                    System.out.println("code :");
                    String employeecode = scanner.next();
                    System.out.println("fathername :");
                    String fathername = scanner.next();
                    System.out.println("codemelli :");
                    String melicode = scanner.next();
                    System.out.println("semat :");
                    String semat = scanner.next();
                    System.out.println("sen :");
                    int sen = scanner.nextInt();
                    System.out.println("hoghogh :");
                    int salary = scanner.nextInt();
                    System.out.println("sabeghe :");
                    int sabeghe = scanner.nextInt();

                    PreparedStatement preparedStatement1 = connection.prepareStatement("insert into employee(employeecode,fathername," +
                            "melicode,semat,sen,salary,sabeghe)VALUES(?,?,?,?,?,?,?)");
                    preparedStatement1.setString(1, employeecode);
                    preparedStatement1.setString(2, fathername);
                    preparedStatement1.setString(3, melicode);
                    preparedStatement1.setString(4, semat);
                    preparedStatement1.setLong(5, sen);
                    preparedStatement1.setLong(6, salary);
                    preparedStatement1.setLong(7, sabeghe);
                    preparedStatement1.executeQuery();
                    preparedStatement1.close();



        connection.close();
    }
}
