package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		System.out.print("Enter New Name: ");
		String name = sc.next();

		System.out.print("Enter New Age: ");
		int age = sc.nextInt();


		System.out.println(id + " " + name + " " + age + " ");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			System.out.println("Connection Success");

			PreparedStatement pstm = con.prepareStatement("UPDATE student SET name=?, age=? WHERE id=?");
			pstm.setString(1, name);
			pstm.setInt(2, age);
			pstm.setInt(3, id);
			
			int i = pstm.executeUpdate();
			if (i>0) {
			    System.out.println("Record Updated");
			}else {
			    System.out.println("Record Updated");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

