package com.andieguo.databasejdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * �����װ�����Ӻ͹ر����ݿ����Ӳ���
 * 
 * @author andieguo
 * 
 */
public class DBConnection {

	public static Connection getConnection() {
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection con = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
			// ��������
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			// ����һ������
			con = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	// �ر�ResultSet
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// �ر�Statement
	public static void closeStatement(Statement stm) {
		if (stm != null) {
			try {
				stm.close();
				stm = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// �ر�PreparedStatement
	public static void closePreparedStatement(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
				pstm = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// �ر�Connection
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
	}

	/*
	 * �ر����ݿ����ӣ�ע��رյ�˳��
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		// ע�⣺���򿪵����ȹر�
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {// ������
		System.out.println(getConnection());
	}
}
