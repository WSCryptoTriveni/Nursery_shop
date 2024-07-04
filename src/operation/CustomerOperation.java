package operation;

import java.util.List;
import java.util.Scanner;

import dao.CustomerDao;
import model.Customer;

public class CustomerOperation {
	
	public static void addCustomer(Scanner sc) {
        System.out.println("Enter customer ID:");
        int id = sc.nextInt();
        
//        System.out.println("Enter user type (customer/admin):");
//        String user_type = sc.nextLine();
//        sc.nextLine();
        
        System.out.println("Enter Username:");
        String username = sc.next();
        sc.nextLine();
        
        System.out.println("Enter Password:");
        String password = sc.nextLine();
        sc.nextLine();
        
        
        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter last name:");
        String lastName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter email:");
        String email = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Enter phone:");
        String phone = sc.nextLine();
        sc.nextLine();
      
        
        System.out.println("Enter Address:");
        String address = sc.nextLine();
        sc.nextLine();
        
       
        // Creating object of customer class
        Customer obj = new Customer(id, firstName, lastName, email, phone, address,username, password);

        // Calling method to insert into table and passing the object of customer class
        boolean result = CustomerDao.insert(obj);
        if (result) {
            System.out.println("The Customer is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

//    public static void updateCustomer(Scanner sc) {
//        System.out.println("Enter Customer ID to update:");
//        int id = sc.nextInt();
//        
//        System.out.println("Enter user_type:");
//        String user_type = sc.next();
//        sc.nextLine();
//        
//        System.out.println("Enter username:");
//        String username = sc.next();
//        sc.nextLine();
//        System.out.println("Enter password:");
//        String password = sc.next();
//        sc.nextLine();
//
//        System.out.println("Enter first name:");
//        String firstName = sc.nextLine();
//        sc.nextLine();
//
//        System.out.println("Enter last name:");
//        String lastName = sc.nextLine();
//        sc.nextLine();
//
//        System.out.println("Enter email:");
//        String email = sc.next();
//
//        System.out.println("Enter phone:");
//        int phone = sc.nextInt();
//        
//        System.out.println("Enter Address:");
//        String address = sc.next();
//        
//        
//        // Creating object of customer class
//        Customer obj = new Customer(id, user_type, username, password, firstName, lastName, email, phone, address);
//
//        // Calling method to update the record in the table
//        boolean result = CustomerDao.update(obj, id);
//        if (result) {
//            System.out.println("The customer is successfully updated.");
//        } else {
//            System.out.println("Something went wrong.");
//        }
//    }

    public static void showCustomers(Scanner sc) {
        // Get all customers
        List<Customer> customer = CustomerDao.getAllCustomer();
        for (Customer customers : customer) {
            System.out.println(customers);
        }
    }

    public static void showCustomerById(Scanner sc) {
        System.out.println("Enter customer ID to get data:");
        int id = sc.nextInt();
        Customer obj = CustomerDao.getByCustomerID(id);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }

    public static void deleteCustomerById(Scanner sc) {
        System.out.println("Enter customer ID to delete:");
        int customerId = sc.nextInt();

        // Calling method to delete a particular record
        boolean result = CustomerDao.delete(customerId);
        if (result) {
            System.out.println("The customer is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}



