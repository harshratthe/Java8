package com.java.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.lms.model.LeaveHistory;
import com.java.lms.model.LeaveStatus;
import com.java.lms.model.LeaveType;
import com.java.lms.util.ConnectionHelper;

public class LeaveHistoryDaoImpl implements LeaveHistoryDao {

	Connection connection;
	PreparedStatement pst;
	
	
	public int datediff(Date startDate, Date endDate) {
		long ms=endDate.getTime() - startDate.getTime();
		long days =(ms/(1000 * 60 * 60 * 24));
		return (int)days;
	}
    
	
	  
	@Override		
	public String applyLeave(LeaveHistory leavehistory) throws ClassNotFoundException, SQLException {
		Employdao employdao=new EmployDaoImpl();
		int leaveBal=employdao.searchEmployDao(leavehistory.getEmpId()).getEmpAvailLeaveBal();
		System.out.println(leaveBal);
		java.util.Date todayUtil = new java.util.Date();
		Date today = new Date(todayUtil.getTime());
		
		Date utilDate1= new Date(leavehistory.getLeaveStartDate().getTime());
		Date utilDate2= new Date(leavehistory.getLeaveEndDate().getTime());
		

		if (datediff(today, utilDate1) < 0) {
			return "Leave-Start Date Cannot be Yesterday...";
		} else if (datediff(today,utilDate2) < 0) {
				return "Leave End-Date Cannot be Yesterday...";
		} else if (datediff(utilDate1, utilDate2) < 0) {
				return "Leave-StartDate Cannot be Greater than Leave-End Date...";
			} else if (datediff(utilDate1, utilDate2) - leaveBal > 0) {
				return "Insufficient Leave Balalnce...";
		} else {
			int days = datediff(utilDate1, utilDate2);
			days++;
			leavehistory.setNoOfDays(days);
			leavehistory.setLeaveStatus(LeaveStatus.PENDING);
			leavehistory.setLeavetype(LeaveType.EL);
			String cmd = "Insert into Leave_History(Emp_ID,LEAVE_START_DATE,LEAVE_END_DATE,LEAVE_NO_OF_DAYS,"
					+ "Leave_Reason,Leave_Type,Leave_Status) values(?,?,?,?,?,?,?)";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, leavehistory.getEmpId());
			pst.setDate(2, leavehistory.getLeaveStartDate());
			pst.setDate(3, leavehistory.getLeaveEndDate());
			pst.setInt(4, days);
			pst.setString(5, leavehistory.getLeaveReason());
			pst.setString(6, leavehistory.getLeavetype().toString());
			pst.setString(7, leavehistory.getLeaveStatus().toString());
			pst.executeUpdate();
			cmd = "Update Employee set EMP_AVAIL_LEAVE_BAL = EMP_AVAIL_LEAVE_BAL - ? "
					+ " Where Emp_ID = ?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, days);
			pst.setInt(2, leavehistory.getEmpId());
			pst.executeUpdate();
			return "Leave Applied Successfully...";
		}
		
		
	}

	@Override
	public LeaveHistory searchbyLeaveId(int LeaveId) throws ClassNotFoundException, SQLException {
		String cmd = "select * from leave_history where LEAVE_ID = ?";
		Connection connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, LeaveId);
		ResultSet rs= pst.executeQuery();
		LeaveHistory leaveHistory = null;
		if (rs.next()) {
			leaveHistory = new LeaveHistory();
			leaveHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveHistory.setEmpId(rs.getInt("EMP_ID"));
			leaveHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveHistory.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leaveHistory.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveHistory.setLeavetype(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveHistory.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveHistory.setLeaveReason(rs.getString("LEAVE_REASON"));
			
		}
		return leaveHistory;
	}

	@Override
	public List<LeaveHistory> showLeaveHistory(int empId) throws ClassNotFoundException, SQLException {
		String cmd = "select * from Leave_History where Emp_ID = ?";
		Connection connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs= pst.executeQuery();
		List<LeaveHistory> listLeaveHistory = new ArrayList<LeaveHistory>();
		LeaveHistory leaveHistory = null;
		while(rs.next()) {
			leaveHistory = new LeaveHistory();
			leaveHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveHistory.setEmpId(rs.getInt("EMP_ID"));
			leaveHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveHistory.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leaveHistory.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveHistory.setLeavetype(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveHistory.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveHistory.setLeaveReason(rs.getString("LEAVE_REASON"));
			listLeaveHistory.add(leaveHistory);
		}
		return listLeaveHistory;
	}
              
	
}
