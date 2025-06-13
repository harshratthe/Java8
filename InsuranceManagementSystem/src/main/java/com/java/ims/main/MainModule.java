package com.java.ims.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.ims.dao.IPolicyService;
import com.java.ims.dao.InsuranceServiceImpl;
import com.java.ims.entity.Policy;
import com.java.ims.exception.PolicyNotFoundException;

public class MainModule {

	static IPolicyService policyDao;
	static Scanner sc;

	static {
		policyDao = new InsuranceServiceImpl();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("\n**** INSURANCE MANAGEMENT SYSTEM *****\n");
			System.out.println("1. Show All Policies");
			System.out.println("2. Search Policy by ID");
			System.out.println("3. Add New Policy");
			System.out.println("4. Update Policy");
			System.out.println("5. Delete Policy");
			System.out.println("6. Exit \n");
			System.out.print("Enter Your Choice: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					showAllPolicies();
					break;
				case 2:
					searchPolicyById();
					break;
				case 3:
					addPolicy();
					break;
				case 4:
					updatePolicy();
					break;
				case 5:
					deletePolicy();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid choice! Try again.");
			}
		} while (choice != 6);
	}

	
	
	public static void showAllPolicies() {
		try {
			List<Policy> policies = policyDao.getAllPolicies();
			for (Policy policy : policies) {
				System.out.println(policy);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void searchPolicyById() {
		System.out.print("Enter Policy ID: ");
		int id = sc.nextInt();
		try {
			Policy policy = policyDao.getPolicy(id);
			if (policy != null) {
				System.out.println(policy);
			} else {
				throw new PolicyNotFoundException("Policy not found with ID: " + id);
			}
		} catch (ClassNotFoundException | SQLException | PolicyNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void addPolicy() {
		System.out.print("Enter Policy Name: \n");
		sc.nextLine(); 
		String name = sc.nextLine();
		System.out.print("Enter Policy Type:  \n");
		String type = sc.nextLine();
		System.out.print("Enter Coverage Amount:  \n");
		double coverage = sc.nextDouble();
		System.out.print("Enter Premium Amount:  \n");
		double premium = sc.nextDouble();

		Policy policy = new Policy(0, name, type, coverage, premium);

		try {
			boolean added = policyDao.createPolicy(policy);
			System.out.println(added ? " Policy added........." : "Failed to add policy.......");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void updatePolicy() {
		System.out.print("Enter Policy ID to update: \n");
		int id = sc.nextInt();
		sc.nextLine(); 
		System.out.print("Enter New Policy Name: \n");
		String name = sc.nextLine();
		System.out.print("Enter New Policy Type: \n");
		String type = sc.nextLine();
		System.out.print("Enter New Coverage Amount: \n");
		double coverage = sc.nextDouble();
		System.out.print("Enter New Premium Amount: \n");
		double premium = sc.nextDouble();

		Policy policy = new Policy(id, name, type, coverage, premium);

		try {
			boolean updated = policyDao.updatePolicy(policy);
			System.out.println(updated ? " Policy updated..........." : "Update failed..........");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	public static void deletePolicy() {
		System.out.print("Enter Policy ID to delete: ");
		int id = sc.nextInt();

		try {
			boolean deleted = policyDao.deletePolicy(id);
			System.out.println(deleted ? " Policy deleted........" : " Deletion failed........");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
		
	


