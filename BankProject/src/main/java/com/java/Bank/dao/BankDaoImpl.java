package com.java.Bank.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.Bank.model.Accounts;
import com.java.Bank.util.ConnectionHelper;

public class BankDaoImpl implements BankDao {

	PreparedStatement pst;
	Connection connection;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="select case when max(accountNo) IS NULL THEN 1 "
				+ "else  max(accountno)+1 end accno from Accounts";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int accno=rs.getInt("accno");
		return accno;
				
	}
	
	          
	@Override
	public String createAccount(Accounts accounts) throws ClassNotFoundException, SQLException {
		int accno=generateAccountNo();
		accounts.setAccountno(accno);
		connection=ConnectionHelper.getConnection();
        String cmd="Insert into Accounts(Accountno,FirstName,LastName,City,State,Amount,CheqFacil,AccountType) "
        		+ "values(?,?,?,?,?,?,?,?)";
        pst=connection.prepareStatement(cmd);
        pst.setInt(1,accno);
        pst.setString(2,accounts.getFirstname());
        pst.setString(3, accounts.getLastname());
        pst.setString(4, accounts.getCity());
        pst.setString(5, accounts.getState());
        pst.setDouble(6,accounts.getAmount());
        pst.setString(7, accounts.getCheqfacil());
        pst.setString(8,accounts.getAccountype());
        pst.executeUpdate();
        
        return "Account created with Accno " + accno ;
        
        		
		
		
		
	}

	@Override
	public Accounts searchAccount(int accountno) throws ClassNotFoundException, SQLException {
		  String cmd="select * from Accounts where accountno=?";
		  connection=ConnectionHelper.getConnection();
		  pst=connection.prepareStatement(cmd);
		  pst.setInt(1, accountno);
		  ResultSet rs=pst.executeQuery();
		  Accounts accounts=null;
		  if(rs.next()) {
			  accounts=new Accounts();
			  accounts.setAccountno(rs.getInt(accountno));
			  accounts.setFirstname(rs.getString("firstname"));
			  accounts.setLastname(rs.getString("lastname"));
				accounts.setCity(rs.getString("city"));
				accounts.setState(rs.getString("state"));
				accounts.setAmount(rs.getDouble("amount")); 
				accounts.setCheqfacil(rs.getString("cheqFacil"));
				accounts.setAccountype(rs.getString("accountType"));
		  }
		  return accounts;
	}


	@Override
	public String depositAccount(int accountNo, double depositAmount) throws ClassNotFoundException, SQLException {
		Accounts accounts = searchAccount(accountNo);  
		if (accounts !=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Accounts set Amount = Amount + ? Where AccountNo = ?";
			pst = connection.prepareStatement(cmd);
			pst.setDouble(1, depositAmount);
			pst.setInt(2, accountNo);
			pst.executeUpdate();
			cmd = "Insert into Trans(AccountNo, TransAmount, TransType) values(?, ?, ?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.setDouble(2, depositAmount);
			pst.setString(3,"C");
			pst.executeUpdate();
			return "Amount Credited to the Account...";
		}
		return "Account No Not Found...";
	}


	@Override
	public String withdrawAccount(int accountNo, double withdrawAmount) throws ClassNotFoundException, SQLException {
		Accounts accounts = searchAccount(accountNo);
		if (accounts !=null) {
			double balance = accounts.getAmount() - withdrawAmount;
			if (balance > 0) {
				connection = ConnectionHelper.getConnection();
				String cmd = "Update Accounts set Amount = Amount - ? Where AccountNo = ?";
				pst = connection.prepareStatement(cmd);
				pst.setDouble(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd = "Insert into Trans(AccountNo, TransAmount, TransType) values(?, ?, ?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setDouble(2, withdrawAmount);
				pst.setString(3,"D");
				pst.executeUpdate();
				return "Amount Debited to the Account...";
			} else {
				return "Insufficient Funds...";
			}
		}
		return "Account No Not Found...";
	}

}
