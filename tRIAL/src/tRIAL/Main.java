package tRIAL;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		
		  List<User> Users= new ArrayList();
	
	        Scanner sc = new Scanner(System.in);
	        int choice;
                
	        do {
	            System.out.println("\n====== User Menu ======");
	            System.out.println("1. Sign In");
	            System.out.println("2. Sign Up");
	            System.out.println("3. Update Password");
	            System.out.println("4. Remove User");
	            System.out.println("5. Show All Users");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
 
	            choice = sc.nextInt();
 
	            switch (choice) {
	                case 1:
	                	 System.out.println("Enter usuer name:");
		                    String Uname = sc.nextLine();
		                    System.out.println("Enter usuer Password:");
		                    String passd = sc.nextLine();
		                    boolean flag = false;
		                    for (User u : Users) {
		                        if (u.getUname().equals(Uname) && u.getPassd().equals(passd)) {
		                            flag = true;
		                            break;
		                        }
		                    }
	 
		                    if (flag == true) {
		                        System.out.println("Found");
		                    } else {
		                        System.out.println("Not Found");
		                    }
		                    break;
	                	
	                	
	                	
	                case 2:
	                	User u= new User();
	                    
	                    System.out.println("Enter usuer name");
	                    u.setUname(sc.nextLine());
	                    
	                    System.out.println("Enter usuer Password");
	                    u.setPassd(sc.nextLine());
	                    
	                    
	                    System.out.println("Enter usuer Email");
	                    u.setEmail(sc.nextLine());
	                    
	                    
	                    System.out.println("Enter Age");
	                    u.setAge(sc.nextInt());
	                    
	                    Users.add(u);
	                    
 
	                    
	                    
	                    
	                    
	                   
	                    break;
	                case 3:
	                    System.out.println("Update Password selected");
	                    System.out.println("Enter user name:");
	                    String UDname = sc.nextLine();
	                    System.out.println("Enter  Password:");
	                    String UDpass = sc.nextLine();
	          
	                    boolean flag1 = false;
	                    for (User f : Users) {
	                        if (f.getUname().equals(UDname) && u.getPassd().equals(UDpass)) {
	                            flag = true;
	                            System.out.println("enter new password:");
	                            String newpass = sc.nextLine();
	                            f.setPassd(newpass);
	                        }
	                    } 
	                    if (flag1 == true) {
	                        System.out.println("password updated");
	                    } else {
	                        System.out.println("wrong password");
	                    }
	                    break;
	                    
	                    
	                
	                case 4:
	                    System.out.println("Remove User selected");
	                   
	                    System.out.println("Enter user name:");
	                    String delName = sc.nextLine();
	                    System.out.println("Enter password:");
	                    String delPass = sc.nextLine();

	                    boolean flag2 = false;
	                 

	                    for (User f : Users) {
	                        if (f.getUname().equals(delName) && f.getPassd().equals(delPass)) {
	                           Users.remove(f);
	                           flag2 = true;
	                            break;
	                        }
	                    }

	                    if (flag2=true) {
	                        System.out.println(" deleted successfully.");
	                    } else {
	                        System.out.println("nor deleted ");
	                    }
	                    
	                    
	                    
	                    
	                    break;
	                case 5:
	                    System.out.println("Show All Users selected");
	                   
	                    
	                    
	                    for(User obj : Users)
	                    {
	                    	System.out.println(obj.toString());
	                    }
	                    break;
	                case 6:
	                    System.out.println("Exiting the application. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
 
	        } while (choice != 6);
 
		
		
		
		
		
 
	}
 
}
 
 