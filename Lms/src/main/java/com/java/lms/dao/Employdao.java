package com.java.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.model.Employ;

public interface  Employdao {
	List<Employ> showEmployDao() throws SQLException, ClassNotFoundException;
	Employ searchEmployDao(int empno) throws ClassNotFoundException, SQLException;
}
