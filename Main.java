package todo;

import java.util.Scanner;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		String n;
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_db","root","123Smorc123");
		Statement myStmt = myConn.createStatement();
		ResultSet myRs;
		
		while (true) {
			scan = new Scanner(System.in);
			n = scan.nextLine();
			if (n.equals("Add")) {
				System.out.println("What task do you want to add?");
				n = scan.nextLine();
				myStmt.executeUpdate("INSERT INTO table_name (todoName) VALUES (\"" + n + "\")");
			} else if (n.equals("update")) {
				System.out.println("What task do you want to update?");
				n = scan.nextLine();
				myStmt.executeUpdate("UPDATE table_name SET todoComplete = \"Complete\" WHERE todoName = \"" + n + "\"");
			} else if (n.equals("select")) {
				myRs = myStmt.executeQuery("select todoName, todoComplete from table_name");
				while (myRs.next()) {
					System.out.println(myRs.getString("todoName") + " " + myRs.getString("todoComplete"));
				}	
			} else if (n.equals("exit")) break;
		}
		
		//ResultSet myRs = myStmt.executeQuery("select todoName, todoComplete from table_name");
	}

}
