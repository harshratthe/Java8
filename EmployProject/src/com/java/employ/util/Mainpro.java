package com.java.employ.util;

import java.util.Scanner;

import com.java.employ.model.Employ;

public class Mainpro {

	
	static EmployBal employbal;
	static 	Scanner scanner;
	
	
	static {
		employbal=new Employbal();
		scanner = new Scanner(System.in);
	}
	
	public static void searchEmployMain() {
		int empno;
		System.out.println("Enter Employ Number   ");
		empno = scanner.nextInt();
		Employ employ = employBal.searchEmployBal(empno);
		if (employ !=null) {
			System.out.println(employ);
		} else {
			System.out.println("*** Emplo Record Not Found ***");
		}
	}
	
	public static void showEmployMain() {
		List<Employ> employList = employBal.showEmployBal();
		for (Employ employ : employList) {
			System.out.println(employ);
		}
	}
}
