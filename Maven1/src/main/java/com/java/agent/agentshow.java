package com.java.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class agentshow {
       public static void main(String[] args) {
		
    	   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
			String cmd="Select * from Agent ";
			PreparedStatement pst=connection.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("Agent ID  " +rs.getInt("agentID"));
				System.out.println("Name " + rs.getString("Name"));
				System.out.println("City  " +rs.getString("city"));
				System.out.println("Gender  " +rs.getString("gender"));
				System.out.println("Marital Status  " + rs.getBoolean("MaritalStatus"));
				System.out.println("PREMIUM  " +rs.getDouble("premium"));
				System.out.println("---------------------------------------------------------");
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
