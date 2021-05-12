package com.vijay.jdbctest;
import java.sql.*;
public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//Loading the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//creating a connection
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/web_customer_tracker","springstudent","springstudent");
			System.out.println(con.getClass());
			System.out.println("Connection Successful");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
