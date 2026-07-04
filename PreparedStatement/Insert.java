package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		System.out.print("Enter Name: ");
		String name = sc.next();

		System.out.print("Enter Age: ");
		int age = sc.nextInt();

		System.out.println(id + " " + name + " " + age + " ");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			System.out.println("Connection Success");

			PreparedStatement pstm = con.prepareStatement("INSERT INTO student VALUES (?, ?, ?)");
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			
			int i = pstm.executeUpdate();
			if (i>0) {
				System.out.println("Record Inserted");
			}else {
			    System.out.println("Record Not Inserted");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}