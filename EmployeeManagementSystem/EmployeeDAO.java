package EmployeeManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDAO {

    Connection con = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    // Insert Employee
    public void addEmployee() {

        try {

            String sql = "INSERT INTO employee VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID : ");
            ps.setInt(1, sc.nextInt());

            sc.nextLine();

            System.out.print("Enter Employee Name : ");
            ps.setString(2, sc.nextLine());

            System.out.print("Enter Department : ");
            ps.setString(3, sc.nextLine());

            System.out.print("Enter Salary : ");
            ps.setDouble(4, sc.nextDouble());

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Employee Added Successfully!");
            else
                System.out.println("Failed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display Employees
    public void viewEmployees() {

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            System.out.println("\n---------------------------------------------");
            System.out.println("ID\tName\tDepartment\tSalary");
            System.out.println("---------------------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + "\t"
                                + rs.getString(2) + "\t"
                                + rs.getString(3) + "\t"
                                + rs.getDouble(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Employee
    public void searchEmployee() {

        try {

            String sql = "SELECT * FROM employee WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID : ");

            ps.setInt(1, sc.nextInt());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nEmployee Found");
                System.out.println("ID : " + rs.getInt(1));
                System.out.println("Name : " + rs.getString(2));
                System.out.println("Department : " + rs.getString(3));
                System.out.println("Salary : " + rs.getDouble(4));

            } else {

                System.out.println("Employee Not Found");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Salary
    public void updateEmployee() {

        try {

            String sql = "UPDATE employee SET salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID : ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary : ");
            double salary = sc.nextDouble();

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Employee Updated Successfully!");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee() {

        try {

            String sql = "DELETE FROM employee WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID : ");

            ps.setInt(1, sc.nextInt());

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Employee Deleted Successfully!");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
