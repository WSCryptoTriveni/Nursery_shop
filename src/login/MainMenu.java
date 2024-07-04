package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.DBConnection;
import menu.AdminMenu;
import menu.CustomerMenu;

public class MainMenu {

	private String roleName;
	private Scanner sc = new Scanner(System.in);

	public void login() {
		try (Connection con = DBConnection.createC()) {
			Statement st = con.createStatement();

			System.out.println("Login to Nursery Shop by providing your credentials:");

			System.out.println("Enter username: ");
			String username = sc.nextLine();

			System.out.println("Enter password: ");
			String password = sc.nextLine();

			String fetchQuery = "SELECT user_type FROM login WHERE username = '" + username + "' AND password = '"
					+ password + "'";

			ResultSet rs = st.executeQuery(fetchQuery);

			if (rs.next()) {
				roleName = rs.getString("user_type");
				System.out.println("Login successful as " + roleName);
				System.out.println("Thankyou for Login.");
			} else {
				System.out.println("Wrong credentials. Please check the username and password.");
				login();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
	// Main menu
	public void mainMenu() {
        try {
            if (roleName.equals("admin")) {
                AdminMenu.adminMenu(sc);
            } 
            else if (roleName.equals("customer")) {
            	CustomerMenu.customerMenu(sc);
            }
        } catch (NullPointerException e) {
            System.out.println("Not Found!!");
        }
        sc.next();
    }

}


