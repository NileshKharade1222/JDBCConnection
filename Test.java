package Demo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Test {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3307/";
		String dbname="db";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("mysql driver is loaded");
			
			Connection con = (Connection) DriverManager.getConnection(url+dbname,username,password);
			System.out.println("connection is establish");
			
			Statement stmt = (Statement) con.createStatement();
			String query = "select* from login";
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next()) {
				
				System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3));
				
				
			}
			stmt.close();
			rs.close();
			con.close();
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}

}
