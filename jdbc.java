//Pgrogram to perform JDBC connection in JAVA
package com.test;

import java.util.Scanner;
import java.sql.*;

public class test {

	static Connection connection;
	static String url = "jdbc:postgresql://localhost:5432/test";
	static String user = "postgres";
	static String password = "123";
	//private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		test test = new test();
		test.initialize();
		test.select();
		System.out.println(test.update(19,""));

		

	public void initialize() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection created!");
		} catch (ClassNotFoundException Cs) {
			System.out.println("Class not found");
		} catch (NullPointerException e) {
			System.out.println("Null");
		}
	}
	
	public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Connection closed");
        }
    }

	public void select() throws SQLException {
		String sql = "select * from test_table order by id";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
		if( (Name!=null && Name.length()!=0) && (City!=null && City.length()!=0) )
		{
		String sql = "insert into test_table values(?,?,?) ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// System.out.println("Enter id");
		preparedStatement.setInt(1, Id);
		// System.out.println("Enter name:");
		preparedStatement.setString(2, Name);
		// System.out.println("Enter City: ");
		preparedStatement.setString(3, City);
		int flag =preparedStatement.executeUpdate();

		//select();
		return flag;
		}
			else 
				return -1;

	}

	public int update(int Id , String Name) throws SQLException {
		if( Name!=null && Name.length()!=0)
		{
		String sql = "update test_table set test_name =? where Id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//System.out.println("Enter id");
		preparedStatement.setInt(2, Id );
		//System.out.println("Enter name");
		preparedStatement.setString(1, Name);
		int flag = preparedStatement.executeUpdate();

		//select();
		//System.out.println("Updated");
		return flag;
		}
			else 
				
			return -1;

	}

	public int delete(int Id) throws SQLException {
		String sql = "delete from test_table where id= ?  ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, Id);
		int flag = preparedStatement.executeUpdate();
		//select();
		 return flag;
	}

}
