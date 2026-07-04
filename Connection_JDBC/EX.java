package Connection_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EX {

	public static void main(String[] args) {

		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");

			// Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			System.out.println("Connected Successfully");

			 // Close Connection
			con.close();
			System.out.println("Connection Closed");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
	}
}