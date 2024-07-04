package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connection.DBConnection;
import model.Product;

import java.util.List;

public class ProductDAO {
	
	static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Product obj) {
        boolean f = false;
        try {
            conn = DBConnection.createC();
        
            String q = "INSERT INTO product(productId, product_name, product_price) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getProductId());
            pstmt.setString(2, obj.getProduct_name());
            pstmt.setInt(3, obj.getProduct_price());

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

    // Update Course
    public static boolean update(Product obj, int productId) {
        boolean f = false;
        try {
            conn = DBConnection.createC();

            String q = "UPDATE product SET product_name = ?,  product_price = ? WHERE productId = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj. getProduct_name());
            pstmt.setInt(2, obj.getProduct_price());
            pstmt.setInt(3, productId);

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
    public static boolean delete(int productId) {
        boolean f = false;
        try {
            conn = DBConnection.createC();

            String qDelete = "DELETE FROM product WHERE productId=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setInt(1, productId);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // product by productID
    public static Product getByProductID(int productId) {
    	 Product product = null;
        try {
            conn = DBConnection.createC();

            String q = "SELECT * FROM product WHERE productId=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, productId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
            	 product = new Product();
            	 product.setProductId(rs.getInt("productId"));
            	 product.setProduct_name(rs.getString("product_name"));
            	 product.setProduct_price(rs.getInt("product_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return product;
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            conn = DBConnection.createC();

            String q = "SELECT * FROM product";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProduct_name(rs.getString("product_name"));
                product.setProduct_price(rs.getInt("product_price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return products;
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



