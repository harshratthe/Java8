package com.java.Bank.dao;

import java.sql.SQLException;

import com.java.Bank.model.Accounts;

public interface  BankDao {
   String createAccount(Accounts accounts) throws ClassNotFoundException, SQLException;
   Accounts searchAccount(int accountno) throws ClassNotFoundException, SQLException;
   String depositAccount(int accountNo, double depositAmount) throws ClassNotFoundException, SQLException;
	String withdrawAccount(int accountNo, double withdrawAmount) throws ClassNotFoundException, SQLException;
}
