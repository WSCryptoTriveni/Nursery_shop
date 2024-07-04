package menu;
import java.util.Scanner;

import operation.CustomerOperation;

import operation.OrderOperation;
import operation.ProductOperation;

public class CustomerMenu {
	
	// Customer menu
    public static void customerMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("******Customer Menu******");
            System.out.println("1. View Products");
            System.out.println("2. Add Order");        
           
            System.out.println("0. Logout");
 
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
            	case 1:
            		ProductOperation.showProducts(sc);
	                break;    
            	case 2:
            		OrderOperation.addOrder(sc);
                    break;
               
                case 0:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
       

}



