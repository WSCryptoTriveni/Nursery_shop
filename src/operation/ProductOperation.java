package operation;
import java.util.List;
import java.util.Scanner;

import model.Product;

import dao.ProductDAO;

public class ProductOperation {
	
	public static void addProduct(Scanner sc) {
		System.out.println("Enter Product ID:");
        int productId = sc.nextInt();
       

        System.out.println("Enter Product Name:");
        String product_name = sc.next();
        sc.nextLine();

        System.out.println("Enter Product price:");
        int price = sc.nextInt();
        
        // Creating object of Product class
        Product obj = new Product(productId, product_name, price);
       
        
        boolean result = ProductDAO.insert(obj);
        if (result) {
            System.out.println(" The product is successfully added.");
            System.out.println("To continue follow the steps...");
        } else {
            System.out.println("Something went wrong.");
        }
	}
	
	public static void updateProduct(Scanner sc) {
		System.out.println("Enter Id to which update product:");
        int productId = sc.nextInt();
        
        System.out.println("Enter Product Name:");
        String  product_name = sc.next();
        sc.nextLine();

        System.out.println("Enter product Price:");
        int price = sc.nextInt();
        
        // Creating object of Product class
        Product obj = new Product(productId, product_name,price);

       
        boolean result = ProductDAO.update(obj, productId );
        if (result) {                        
        	System.out.println("The product is successfully updated.");
        } else {
            System.out.println("Something went wrong.");
        }  
	}
        
    public static void showProducts(Scanner sc) {
    	//Get all Course
    	List<Product> product = ProductDAO.getAllProducts();
        for (Product products : product) {
        	System.out.println(products);
        }
    }
    
    public static void showProductById(Scanner sc) {
    	System.out.println("Enter Product id to get data:");
        int productId = sc.nextInt();
        Product obj = ProductDAO.getByProductID(productId);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Products with ID " + productId + " not found.");
        }
    }
    
    public static void deleteProductsById(Scanner sc) {
    	System.out.println("Enter Product id to delete:");
        int productId = sc.nextInt();

        // Calling method to delete a particular row
        boolean result = ProductDAO.delete(productId);
        if (result) {
            System.out.println("The product is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}

	