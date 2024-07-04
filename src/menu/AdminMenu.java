package menu;

import java.util.Scanner;
import operation.CustomerOperation;

import operation.OrderOperation;
import operation.ProductOperation;



public class AdminMenu {
	// Admin menu
	   public static void adminMenu(Scanner sc) {
	   int choice;
	   do {
           System.out.println("\nWelcome to Admin Page\n");
           System.out.println("Press 1 for Product operations");
           System.out.println("Press 2 for Customer operations");
         
           System.out.println("Press 3 for Order operations");
           System.out.println("Press 0 to Logout from Admin menu");

           System.out.print("\nEnter your choice: ");
           choice = sc.nextInt();
           switch (choice) {
               case 1:
                   manageProduct(sc);
                   break;
               case 2:
                   manageCustomers(sc);
                   break;
               
               case 3:
            	   manageOrders(sc);
                   break;
               case 0:
                   System.out.println("Logged out successfully from Admin page.");
                   break;
               default:
                   System.out.println("Invalid choice. Please try again.");
           }
       } while (choice != 0);


}

	private static void manageOrders(Scanner sc) {
		
		 int choice;
	       do {
	           System.out.println("\nWelcome to Order operation\n");
	          
	           System.out.println("Press 1 to View all Orders");
	           System.out.println("Press 2 to View Order by order Id");
	           
	           System.out.println("Press 0 for returning to admin menu");
	           
	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	                   OrderOperation.showOrder(sc);
	                   break;
	               case 2:
	            	   OrderOperation.showOrderById(sc);
	                   break;
	              
	               case 0:
	                   System.out.println("Returning back to admin menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   
	}
	private static void manageCustomers(Scanner sc) {
		int choice;
	       do {
	           System.out.println("\nWelcome to Customer operation\n");
	           System.out.println("Press 1 to Add a Customer");
	           //System.out.println("Press 2 to Update Customer");
	           System.out.println("Press 2 to View all Customers");
	           System.out.println("Press 3 to View Customer by Id");
	           System.out.println("Press 4 to Delete Customer by Id");
	           System.out.println("Press 0 for returning to admin menu");

	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	            	   CustomerOperation.addCustomer(sc);
	                   break;
	               case 2:
	            	   CustomerOperation.showCustomers(sc);
	                   break;
	               case 3:
	            	   CustomerOperation.showCustomerById(sc);
	                   break;
	               case 4:
	            	   CustomerOperation.deleteCustomerById(sc);
	                   break;
	               
	               case 0:
	                   System.out.println("Returning back to admin menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }


		
	

	private static void manageProduct(Scanner sc) {
		
		int choice;
	       do {
	           System.out.println("\nWelcome to Product operation\n");
	           System.out.println("Press 1 to Add a Product");
	           System.out.println("Press 2 to Update a Product");
	           System.out.println("Press 3 to View all Product");
	           System.out.println("Press 4 to View Product by Id");
	           System.out.println("Press 5 to Delete Product by Id");
	           System.out.println("Press 0 for returning to admin menu");

              System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	            	   ProductOperation.addProduct(sc);
	                   break;
	               case 2:
	            	   ProductOperation.updateProduct(sc);
	                   break;
	               case 3:
	            	   ProductOperation.showProducts(sc);
	                   break;
	               case 4:
	            	   ProductOperation.showProductById(sc);
	                   break;
	               case 5:
	            	   ProductOperation.deleteProductsById(sc);
	                   break;
	               case 0:
	                   System.out.println("Returning back to admin menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }

	
		
	}

