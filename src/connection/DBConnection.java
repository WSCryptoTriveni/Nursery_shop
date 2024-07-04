package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3307/jdbcdemo";
	static Connection conn;

	// Database Credentials
		static final String username = "root";
		static final String password = "root";
	
	
//	String url="jdbc:mysql://localhost:3306/jdbcdemo";
//	String username="root";
//	String password="";
//	Static Connection conn;

	public static Connection createC() {
		
		try {
			//load the driver
			Class.forName(JDBC_DRIVER);
			
			conn= DriverManager.getConnection(URL,username,password);
			
			
		}catch (Exception e) {
			System.out.println(e);
		}

		return conn;
	}

}
