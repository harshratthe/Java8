package com.java.Bank.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.Bank.dao.BankDao;
import com.java.Bank.dao.BankDaoImpl;
import com.java.Bank.model.Accounts;

public class SearchAccountMain {

	public static void main(String[] args) {
		int accountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No   ");
		accountNo = sc.nextInt();
		BankDao dao = new BankDaoImpl();
		try {
			Accounts accounts = dao.searchAccount(accountNo);
			if (accounts !=null) {
				System.out.println(accounts);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}