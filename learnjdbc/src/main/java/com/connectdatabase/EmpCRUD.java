package com.connectdatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EmpCRUD {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school";
		String un ="postgres";
		String pwd = "root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection(url,un,pwd);
			Statement stmt = connect.createStatement();
			String sqli = "insert into employee values(101,'prince',100000),(102,'abhiram',200000),(103,'prudhvi',25896312)";
			String sqlu = "update employee set name = 'abhi' where name ='abhiram'";
			
			stmt.execute(sqlu);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
