package EmployeeManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n========== Employee Management System ==========");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                dao.addEmployee();
                break;

            case 2:
                dao.viewEmployees();
                break;

            case 3:
                dao.searchEmployee();
                break;

            case 4:
                dao.updateEmployee();
                break;

            case 5:
                dao.deleteEmployee();
                break;

            case 6:
                System.out.println("Thank You!");
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
            }
        }
    }
}
