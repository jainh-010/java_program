package com.test;
import java.util.Scanner;
import java.sql.*;

public class jdbc {
	
	private static Connection connection = null;
	
	public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);

	test test = new test();
	try {
	Class.forName("org.postgresql.Driver");
	connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres", "123");
	int choice;
	test.select();
	
	System.out.println("Enter Choice: \n 1. Insert \n 2. Update  \n 3. Delete");
	choice = in.nextInt();
	
	switch(choice) {
	case 1 : test.insert();
	break;
	case 2 : test.update();
	break;
	case 3 : test.delete();
	break;		
	default:  System.out.println("Wrong input");
	break;
	}
	}
	catch (Exception e) {e.printStackTrace();
	} 
	
	in.close();
	}
	
	public void select() throws SQLException {
		String sql = "select * from test_table order by id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet rs = preparedStatement.executeQuery(); 
		while(rs.next()) {
			int id = rs.getInt("id");
			String  name = rs.getString("test_name");
			String address = rs.getString("address");
			System.out.println(id +"\t"+ name +"\t"+address );
		}
		rs.close(); 
	}
	
	public void insert() throws SQLException {
		Scanner in = new Scanner(System.in);
		String sql = "insert into test_table values(?,?,?) ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("Enter id");
		preparedStatement.setInt(1,in.nextInt());
		System.out.println("Enter name:");
		preparedStatement.setString(2, in.next());
		System.out.println("Enter City: ");
		preparedStatement.setString(3, in.next());
		preparedStatement.executeUpdate();
		System.out.println("Query insterted successfully.");
		in.close();
		select();
	}
	public void update() throws SQLException {
		Scanner in = new Scanner(System.in);
		String sql = "update test_table set test_name =? where Id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("Enter name");
		preparedStatement.setString(1,in.nextLine());
		System.out.println("Enter id");
		preparedStatement.setInt(2,in.nextInt());
		preparedStatement.executeUpdate();
		in.close();
		select();
		System.out.println("Updated");
	}
	public void delete() throws SQLException{
		Scanner in = new Scanner(System.in);
		String sql = "delete from test_table where id= ? ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1,in.nextInt());
				preparedStatement.executeUpdate();		
				in.close();
				select();
		System.out.println("Deleted");
	}
	
}
