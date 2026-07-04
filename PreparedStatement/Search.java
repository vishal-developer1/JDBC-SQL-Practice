package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			System.out.println("Connected Successfully");

			System.out.print("Enter Student ID: ");
			int id = sc.nextInt();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE id = ?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int sid = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				System.out.println("ID   : " + sid);
				System.out.println("Name : " + name);
				System.out.println("Age  : " + age);

			} else {
				System.out.println("Record Not Found");
			}

			con.close();
			sc.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
