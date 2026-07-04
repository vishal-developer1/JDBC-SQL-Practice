package CRUD_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			System.out.println("Connected Successfully");

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM student");

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println(id + " " + name + " " + age);
			}

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}