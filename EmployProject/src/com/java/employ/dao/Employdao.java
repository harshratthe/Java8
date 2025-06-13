package com.java.employ.dao;

import java.util.List;

import com.java.employ.model.Employ;

public interface Employdao {
      
	List<Employ> showEmploydao();
	Employ searchEmploydao(int empno);
	String addEmploydao(Employ employ);	
}
