package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	public Connection myGetconnection() {
		Connection con=null;
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/adv_java";
		String uname="root";
		String pass="amar123";
		
		 con=DriverManager.getConnection(url,uname,pass);
		 
		}catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("connection is not made"+e);
		}
	   return con;
	}
	
	
	public ResultSet getRows(String query) {
		Connection con=myGetconnection();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return rs;
	}

	public void adduser(String name,String gender,String contact,String uname,String pass) {
		Connection con=myGetconnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into userinfo values(?,?,?,?,?)");
			pstmt.setString(1, name);// fun in PreparedStatement
			pstmt.setString(2, gender);
			pstmt.setString(3,contact);
			pstmt.setString(4,uname);
			pstmt.setString(5,pass);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}




