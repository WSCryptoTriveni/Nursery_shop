package operation;

import java.util.List;
import java.util.Scanner;

import dao.OrderDao;
import model.Order;

public class OrderOperation {
	
	public static  void addOrder(Scanner sc) {
     
		System.out.println("Enter order ID you want to give:");
        int orderId = sc.nextInt();
        
        System.out.println("Enter Product ID:");
        int productId = sc.nextInt();
        
        System.out.println("Enter Product name:");
        String product_name = sc.next();
        sc.nextLine();
        
        System.out.println("Enter Product price:");
        int product_price = sc.nextInt();
        
        System.out.println("Enter Your ID:");
        int cust_id = sc.nextInt();
        
        System.out.println("Enter Your name:");
        String cust_name = sc.nextLine();
        sc.nextLine();
        
       
        // Creating object of order class
        Order obj = new Order(orderId,productId, product_name, product_price, cust_id, cust_name);

        // Calling method to insert into table and passing the object of order class
        boolean result = OrderDao.insert(obj);
        if (result) {
            System.out.println("The order is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }



    public static void showOrder(Scanner sc) {
        // Get all orders
        List<Order> orders = OrderDao.getAllOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }
//
    public static void showOrderById(Scanner sc) {
        System.out.println("Enter order ID to get data:");
        int orderID = sc.nextInt();
        Order obj = OrderDao.getByOrderID(orderID);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Order with ID " + orderID + " not found.");
        }
    }
//
    public static void deleteOrderById(Scanner sc) {
        System.out.println("Enter order ID to delete:");
        int orderId = sc.nextInt();

        // Calling method to delete a particular record
        boolean result = OrderDao.delete(orderId);
        if (result) {
            System.out.println("The order is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }    
}
