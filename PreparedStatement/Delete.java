package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			System.out.println("Connection Success");

			PreparedStatement pstm = con.prepareStatement("DELETE FROM student WHERE id=?");
			pstm.setInt(1, id);

			int i = pstm.executeUpdate();
			if (i>0) {
			    System.out.println("Record Deleted");
			}else {
			    System.out.println("Record Not Found");			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

