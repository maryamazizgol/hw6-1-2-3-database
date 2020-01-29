package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maryam", "JAVA");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1)enter \n2)delete\n3)update");
                int a = scanner.nextInt();
                switch (a) {
                    case 1:
                        System.out.println("code daneshjooe:");
                        String code = scanner.next();
                        System.out.println("nam:");
                        String name = scanner.next();
                        System.out.println("salevorood:");
                        String sal = scanner.next();
                        System.out.println("moadel:");
                        String moadel = scanner.next();



                        PreparedStatement preparedStatement = connection.prepareStatement("insert into student(code,name,sal,moadel) values (?,?,?,?)");
                        preparedStatement.setString(1, code);
                        preparedStatement.setString(2, name);
                        preparedStatement.setString(3, sal);
                        preparedStatement.setString(4, moadel);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        break;



                    case 2:
                        System.out.println("nam:");
                        String namee = scanner.next();
                        PreparedStatement preparedStatement2 = connection.prepareStatement("delete from student WHERE name=?");
                        preparedStatement2.setString(1, namee);
                        preparedStatement2.executeUpdate();
                        preparedStatement2.close();
                        break;


                    case 3:
                        System.out.println("code?:");
                        String sida = scanner.next();
                        System.out.println("kodam beroozresani shavad?:");
                        System.out.println("1)code\n2)name\n3)sal\n4)moadel\n");
                        int b = scanner.nextInt();
                        switch (b) {
                            case 1:
                                PreparedStatement preparedStatement3 = connection.prepareStatement("update student set  code=? where code=?");
                                System.out.println("code jadid :");
                                String codeee = scanner.next();
                                preparedStatement3.setString(1, codeee);
                                preparedStatement3.setString(2, codeee);
                                preparedStatement3.executeUpdate();
                                preparedStatement3.close();
                                break;
                            case 2:
                                PreparedStatement preparedStatement4 = connection.prepareStatement("update student set  name=? where code=?");
                                System.out.println("name jadid :");
                                String nameeee = scanner.next();
                                preparedStatement4.setString(1, nameeee);
                                preparedStatement4.setString(2, codeee);
                                preparedStatement4.executeUpdate();
                                preparedStatement4.close();
                                break;
                            case 3:
                                PreparedStatement preparedStatement5 = connection.prepareStatement("update student set  year=? where code=?");
                                System.out.println("sale jadid :");
                                String sall = scanner.next();
                                preparedStatement5.setString(1, sall);
                                preparedStatement5.setString(2, codeee);
                                preparedStatement5.executeUpdate();
                                preparedStatement5.close();
                                break;
                            case 4:
                                PreparedStatement preparedStatement6 = connection.prepareStatement("update student set  moadel=? where code=?");
                                System.out.println("moadel:");
                                String moadell = scanner.next();
                                preparedStatement6.setString(1, moadell);
                                preparedStatement6.setString(2, codeee);
                                preparedStatement6.executeUpdate();
                                preparedStatement6.close();


                        }
                        break;

                }
            }


        } catch (ClassNotFoundException e) {

            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }    }
}
