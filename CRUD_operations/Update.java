package CRUD_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			System.out.println("Connected Successfully");

			Statement stm = con.createStatement();

			int i = stm.executeUpdate("UPDATE student SET name='Rahul', age=23 WHERE id=101");

			if (i > 0) {
				System.out.println("Record Updated");
			} else {
				System.out.println("Record Not Updated");
			}

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}