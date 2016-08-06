package com.andieguo.databasedemo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.andieguo.propertiesdemo.PropertiesHelper;

public class DBHelper {

	public static DB getDB() {
		String url = PropertiesHelper.getProperty("url");// 从类路径下面进行加载
		String username = PropertiesHelper.getProperty("username");
		String password = PropertiesHelper.getProperty("password");
		String database = PropertiesHelper.getProperty("database");
		return new DB(url + database, username, password);

	}

	public static void main(String[] args) {
		DB db = getDB();
		try {
			ResultSet rs = db.runSql("select * from admin");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
