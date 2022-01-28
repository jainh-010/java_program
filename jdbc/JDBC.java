package com.test;

import java.util.Scanner;
import java.sql.*;

public class JDBC {

    static Connection connection;
    static String url = "jdbc:postgresql://localhost:5432/test";
    static String user = "postgres";
    static String password = "123";

    private static final Scanner in = new Scanner(System.in);

    public void initialize() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection created!");
        }
        catch (ClassNotFoundException Cs) {
            System.out.println("Class not found");
        } catch (NullPointerException e) {
            System.out.println("Null");
        }
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

//    public static void main(String[] args) throws SQLException {
//
//        JDBC test = new JDBC();
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(url, user, password);
//            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres", "123");
//            int choice;
//            System.out.println("Enter Choice: \n 1. Insert \n 2. Update  \n 3. Delete");
//            test.select();
//            choice = in.nextInt();
//            switch (choice) {
//                case 1: //test.insert();
//                    break;
//                case 2:
//                    test.update();
//                    break;
//                case 3:
//                    test.delete();
//                    break;
//                default:
//                    System.out.println("Wrong input");
//                    break;
//            }
//        }
//        //catch (Exception e) {e.printStackTrace();}
//        catch (ClassNotFoundException Cs) {
//            System.out.println("Class not found");
//        } catch (NullPointerException e) {
//            System.out.println("Null");
//        } finally {
//            System.out.println("Connection closed.");
//            connection.close();
//            in.close();
//        }
//    }

    public void select() throws SQLException {
        String sql = "select * from test_table order by id";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("test_name");
                String address = rs.getString("address");
                System.out.println(id + "\t" + name + "\t" + address);
            }

        }
    }

    public int insert(int Id, String Name, String City) throws SQLException {

        String sql = "insert into test_table values(?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //System.out.println("Enter id");
        preparedStatement.setInt(1, Id);
        //System.out.println("Enter name:");
        preparedStatement.setString(2, Name);
        //System.out.println("Enter City: ");
        preparedStatement.setString(3, City);
        int s = preparedStatement.executeUpdate();


        select();
        return s;
    }

    public void update() throws SQLException {

        String sql = "update test_table set test_name =? where Id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Enter id");
        preparedStatement.setInt(2, in.nextInt());
        System.out.println("Enter name");
        preparedStatement.setString(1, in.next());
        preparedStatement.executeUpdate();


        select();
        System.out.println("Updated");
    }

    public void delete() throws SQLException {

        String sql = "delete from test_table where id= ?  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, in.nextInt());
        preparedStatement.executeUpdate();

        select();
        System.out.println("Deleted");
    }

}