package com.java.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class agentupdate {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
		int agentid;
		double pre;
		String name,city,gender;
		boolean ms;
		System.out.println("Enter Agnet ID   ");
		agentid =sc.nextInt();
		System.out.println("Enter  Name  ");
		name = sc.next();
		System.out.println("Enter Gender (MALE/FEMALE)   ");
		gender = sc.next().toUpperCase();
		System.out.println("Enter City   ");
		city = sc.next();
		System.out.println("Enter MaritalStatus  ");
		ms = sc.nextBoolean();
		System.out.println("Enter Premium   ");
		pre = sc.nextDouble();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
			String cmd="Update Agent set name=?,Gender=? , City=?, MaritalStatus=? , Premium=? where agentid= ?";
			PreparedStatement pst=connection.prepareStatement(cmd);
			pst.setString(1, name);
			pst.setString(2, gender);
			pst.setString(3, city);
			pst.setBoolean(4, ms);
			pst.setDouble(5, pre);
			pst.setInt(6,agentid);
			pst.executeUpdate();
			System.out.println("*** Agent Record Updated ***");

				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
