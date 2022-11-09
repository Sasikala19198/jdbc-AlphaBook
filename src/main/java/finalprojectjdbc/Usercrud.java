package finalprojectjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Usercrud {
	
	private User u1;

	public User getUser() {
		return u1;
	}

	public void setUser(User user) {
		this.u1 = u1;
	}
		
	public void signUp(User u1) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");		
	    ps.setString(1, u1.getFirstname());
		ps.setString(2, u1.getLastname());
		ps.setString(3, u1.getGender());
		ps.setLong(4, u1.getContactnumber());
		ps.setString(5, u1.getDateofbirth());
	    ps.setString(6, u1.getEmailid());
		ps.setString(7, u1.getPassword());
		
		ps.executeUpdate();
		con.close();
		System.out.println("Your Signin Successfully");
				
	}
	
	public void logIn(String emailid,String password,User u1) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		PreparedStatement ps=con.prepareStatement("select * from user where emailid=? and password=?");	
		ps.setString(1, u1.getEmailid());
		ps.setString(2, u1.getPassword());
		ResultSet rs= ps.executeQuery();
		String emaild="";
		String pw="";
		while(rs.next())
		{
			emaild=rs.getString(6);
			pw=rs.getString(7);
		}
		if(pw.equals(u1.getPassword()) && emaild.equals(u1.getEmailid()))
		{
			System.out.println("Your login successful");
		}
		else{
			System.out.println("Invalid Id or Password");
		}
		
		con.close();
	}
}

