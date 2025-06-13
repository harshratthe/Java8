package com.java.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class agentdelete {
   public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int agentid;
	System.out.println("Enter AgentId to be deleted: ");
	agentid=sc.nextInt();
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
		String cmd="delete from agent where agentid=?";
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setInt(1, agentid);
		pst.executeUpdate();
		System.out.println("Record Deleted");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
