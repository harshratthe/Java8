package com.java.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.model.LeaveHistory;

public interface LeaveHistoryDao {
      String applyLeave(LeaveHistory leavehistory) throws ClassNotFoundException, SQLException;
      LeaveHistory searchbyLeaveId(int LeaveId) throws ClassNotFoundException, SQLException;
      List<LeaveHistory> showLeaveHistory(int empId) throws ClassNotFoundException, SQLException;
}
