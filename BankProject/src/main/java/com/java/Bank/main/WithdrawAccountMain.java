package com.java.Bank.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.Bank.dao.BankDao;
import com.java.Bank.dao.BankDaoImpl;

public class WithdrawAccountMain {

	public static void main(String[] args) {
		int accountNo;
		double withdrawAmount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo and Withdraw Amount  ");
		accountNo = sc.nextInt();
		withdrawAmount = sc.nextDouble();
		BankDao dao = new BankDaoImpl();
		try {
			System.out.println(dao.withdrawAccount(accountNo, withdrawAmount));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}