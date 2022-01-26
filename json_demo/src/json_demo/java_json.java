package json_demo;
import java.sql.*;



public class java_json {
	private static Connection connection = null;
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","123");
			System.out.println("Connection established");
			java_json js = new java_json();
			js.view();
		}
		catch (Exception e)
		{e.printStackTrace();}
	}
	
	public void view() throws SQLException{
		String sql ="select * from " ;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		int id = rs.getInt("Id");
		String name = rs.getString("test_name");
		System.out.println(id + name);
		
	}

}
