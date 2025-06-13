package com.java.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployInsert {
            public static void main(String[] args) {
				Scanner sc=new Scanner(System.in);
				int empno;
				double basic;
				String name,dept,desig,gender;
				System.out.println("Enter Empno: ");
				empno=sc.nextInt();
				System.out.println("Enter Name : ");
				name=sc.next();
				System.out.println("Enter Gender: ");
				gender=sc.next();
				System.out.println("Enter Department: ");
				dept=sc.next();
				System.out.println("Enter Designation: ");
				desig=sc.next();
				System.out.println("Enter Salary: ");
				basic=sc.nextDouble();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexamarch", "root", "root");
					String cmd= "Insert into Employ(empno,name,gender,dept,desig,basic) values(?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(cmd);
					pst.setInt(1, empno);
					pst.setString(2,name);
					pst.setString(3, gender);
					pst.setString(4, dept);
					pst.setString(5, desig);
					pst.setDouble(6, basic);
					pst.executeUpdate();
					System.out.println("Employ record Inserted ..... ");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

          }
}
