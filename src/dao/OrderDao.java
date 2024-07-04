package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Order;

public class OrderDao {
	
	static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Order obj) {
        boolean f = false;
        try {
            conn = DBConnection.createC();

            String q = "INSERT INTO order( orderId,productId, product_name,product_price, customerId, customer_name) VALUES (?, ?, ?, ?, ?,?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getOrderId());
            pstmt.setInt(2, obj.getProductId());
            pstmt.setString(3, obj.getProduct_name());
            pstmt.setInt(4, obj. getProduct_price());
            pstmt.setInt(5, obj.getCust_id());
            pstmt.setString(6, obj.getCust_name()); 
           
            pstmt.executeUpdate();

            f = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            closeResources();
        }
        return f;
    }

    // Update 
   public static boolean update(Order obj, int orderId) {
        boolean f = false;
       try {
           conn = DBConnection.createC();

          String q = "UPDATE order SET  productId = ?, product_name = ?, product_price= ?, customerId = ?,customer_name = ?   WHERE orderId = ?";
           pstmt = conn.prepareStatement(q);

           pstmt.setInt(1, obj.getProductId());
           pstmt.setString(2, obj.getProduct_name());
           pstmt.setInt(3, obj. getProduct_price());
           pstmt.setInt(4, obj.getCust_id());
           pstmt.setString(5, obj.getCust_name()); // Converting Date to SQL Date
          
           pstmt.executeUpdate();

            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Delete Method
    public static boolean delete(int orderId) {
        boolean f = false;
        try {
            conn = DBConnection.createC();

            String qDelete = "DELETE FROM order WHERE  orderId=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setInt(1, orderId);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
           e.printStackTrace();
       } finally {
            closeResources();
        }
        return f;
   }

//    // order by orderid
    public static Order getByOrderID(int orderId) {
        Order order = null;
        try {
            conn = DBConnection.createC();

            String q = "SELECT * FROM order WHERE orderId=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, orderId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                order = new Order();
                
                
                order.setProductId(rs.getInt("productId"));
                order.setProduct_name(rs.getString("product_name"));
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return order;
    }

    public static List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            conn = DBConnection.createC();

            String q = "SELECT * FROM order";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setCust_id(rs.getInt("cust_id"));
                order.setProductId(rs.getInt("productId"));
                order.setCust_name(rs.getString("cust_name"));
               
               
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return orders;
    }
    
//    
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



