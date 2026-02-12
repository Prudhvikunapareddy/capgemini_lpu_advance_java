package com.connectdatabase;

import java.sql.*;
import java.util.Scanner;

public class TestEmp {

    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/school",
                "postgres",
                "root");

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Update Salary");
        System.out.println("4. Find Employee");
        System.out.print("Choose Option: ");

        int choice = sc.nextInt();

        if (choice == 1) {

            String sql = "INSERT INTO employee VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());

            System.out.print("Enter Name: ");
            ps.setString(2, sc.next());

            System.out.print("Enter Salary: ");
            ps.setDouble(3, sc.nextDouble());

            ps.executeUpdate();
            System.out.println("Employee Added ");
            ps.close();
        }

        else if (choice == 2) {

            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Employee Deleted ");
            ps.close();
        }

        else if (choice == 3) {

            String sql = "UPDATE employee SET salary=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Salary Updated ");
            ps.close();
        }

        else if (choice == 4) {

            String sql = "SELECT * FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            } else {
                System.out.println("Employee Not Found");
            }

            rs.close();
            ps.close();
        }

        else {
            System.out.println("Invalid Option");
        }

        con.close();
        sc.close();
    }
}
