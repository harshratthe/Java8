package com.java.Bank.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.Bank.dao.BankDao;
import com.java.Bank.dao.BankDaoImpl;
import com.java.Bank.model.Accounts;

public class CreateAccount {
          public static void main(String[] args) {
			
        	  
        	 Scanner sc=new Scanner(System.in);
        	 Accounts accounts=new Accounts();
        	 System.out.println("Enter FirstName");
        	 accounts.setFirstname(sc.next());
        	 System.out.println("Enter LASTNAME");
        	 accounts.setLastname(sc.next());
        	 System.out.println("Enter City   ");
     		accounts.setCity(sc.next()); 
     		System.out.println("Enter State  ");
     		accounts.setState(sc.next());
     		System.out.println("Enter Amount  ");
     		accounts.setAmount(sc.nextDouble());
     		System.out.println("Enter CheqFacil (YEs/NO)   ");
     		accounts.setCheqfacil(sc.next());
     		System.out.println("Enter Account Type  (Savings/Current)  ");
     		accounts.setAccountype(sc.next());
     		
            BankDao dao= new BankDaoImpl();     		
     		try {
				System.out.println(dao.createAccount(accounts));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     		
     		
		}
}
