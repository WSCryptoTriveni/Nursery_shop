package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Customer;
public class CustomerDao {

	
	static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Customer obj) {
        boolean f = false;
        try {
            conn = DBConnection.createC();

            String q = "INSERT INTO customer(customerId, firstname, lastname, email, phone, address,username,password) VALUES (?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, obj.getId());
//            pstmt.setString(2, obj.getUser_type());
           
            pstmt.setString(2, obj.getFirstName());
            pstmt.setString(3, obj.getLastName());
            pstmt.setString(4, obj. getEmail());
            pstmt.setString(5, obj.getPhone());
            pstmt.setString(6, obj.  getAddress());
            pstmt.setString(7, obj.getUsername());
            pstmt.setString(8, obj.getPassword());
         

            pstmt.executeUpdate();

            // Retrieve the auto-generated key (ID)
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                // You might want to handle the auto-generated key if required
            }

            f = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            closeResources();
        }
        return f;
    }

    // Delete Method
    public static boolean delete(int id) {
        boolean f = false;
        try {
            conn = DBConnection.createC();

            String qDelete = "DELETE FROM customer WHERE customerId=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            f = true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }


    // Student by StudentID
    public static Customer getByCustomerID(int id) {
        Customer customer = null;
        try {
            conn = DBConnection.createC();

            String q = "SELECT * FROM customer WHERE customerId=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("customerId"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));  
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return customer;
    }

    public static List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            conn = DBConnection.createC();

            String q = "SELECT * FROM customer";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customerId"));
                   
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));  
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return customers;
    }

    // Close resources method
    private static void closeResources() {
        try {
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
