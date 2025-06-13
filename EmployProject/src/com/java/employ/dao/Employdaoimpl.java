	package com.java.employ.dao;

import java.util.List;

import com.java.employ.model.Employ;

public class Employdaoimpl implements Employdao{
         
	static List<Employ> employlist;
	
	
	static {
		employlist=new Arraylist<Employ>();
	}


	@Override
	public List<Employ> showEmploydao() {
		// TODO Auto-generated method stub
		return employlist;
	}


	@Override
	public Employ searchEmploydao(int empno) {
		// TODO Auto-generated method stub
		Employ employFound = null;
		for (Employ employ : employlist) {
			if (employ.getEmpno() == empno) {
				employFound = employ;
				break; 
			}
		} 
		return employFound;
	}


	@Override
	public String addEmploydao(Employ employ) {
		// TODO Auto-generated method stub
		employlist.add(employ);
		return "Employ Record Inserted...";
	}
	
	
}
