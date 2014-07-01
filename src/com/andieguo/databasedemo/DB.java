package com.andieguo.databasedemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private Connection conn = null;
	public DB(String url,String username,String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet runSql(String sql) throws SQLException{
		Statement statement= conn.createStatement();
		return statement.executeQuery(sql);
	}
	
}
