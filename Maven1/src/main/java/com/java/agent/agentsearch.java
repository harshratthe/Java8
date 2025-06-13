package com.java.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class agentsearch {
            public static void main(String[] args) {
            	Scanner sc=new Scanner(System.in);
        		int agentid;
        		System.out.println("Enter agentid ");
        		agentid=sc.nextInt();
        		
        		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
} 
