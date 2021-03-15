package todo;

import java.sql.*;

public class SQL{
	private Connection myConn;
	private Statement myStmt;
	private ResultSet myRs;
	
	public SQL(String port, String dbName, String login, String password) throws SQLException {
		this.myConn = DriverManager.getConnection("jdbc:mysql://" + port + "/" + dbName,
				login, password);
	}
	
	public void select(String columnName, String tableName) throws SQLException {
		this.myStmt = this.myConn.createStatement();
		this.myRs = this.myStmt.executeQuery("SELECT " + columnName +" FROM " + tableName);
		while (this.myRs.next()) {
			System.out.println(myRs.getString("todoName") + " " + myRs.getString("todoComplete"));
		}	
	}
	
	public void delete(String tableName) throws SQLException {
		this.myStmt = this.myConn.createStatement();
		this.myStmt.executeQuery("DELETE FROM " + tableName);
	}
	
	public void add(String tableName, String columnName, String updateName) throws SQLException {
		this.myStmt = this.myConn.createStatement();
		this.myStmt.executeQuery("INSERT INTO " + tableName 
				+ " (" + columnName + ") VALUES (\"" + updateName + "\")");
	}
	
	public void update(String tableName, String updateColumnName, String updateWord,
			String checkColumnName, String checkCellName) throws SQLException {
		this.myStmt = this.myConn.createStatement();
		this.myStmt.executeQuery("UPDATE " + tableName 
				+ " SET " + updateColumnName + " = \"" + updateWord 
				+ "\" WHERE " + checkColumnName + " = \"" +
				checkCellName + "\"");
	}
	
	public Statement getStatement() throws SQLException {
		return this.myStmt = this.myConn.createStatement();
	}
}
