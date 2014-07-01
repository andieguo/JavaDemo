package com.andieguo.databasejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBHelper {
	/*
	 * 查询多个对象的方法
	 * 
	 * sql: 要执行的sql语句 obj：可变参数列表
	 */
	public List<Map<String, Object>> queryList(String sql, Object... obj) {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Connection conn = DBConnection.getConnection(); // 获得连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 创建PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 为查询语句设置参数
			setParameter(ps, obj);
			// 获得ResultSet结果集
			rs = ps.executeQuery();
			// 获得结果集信息
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获得列的总数
			int columnCount = rsmd.getColumnCount();
			Map<String, Object> row = null;
			// 遍历结果集，根据信息封装成Map
			while (rs.next()) {
				row = new HashMap<String, Object>();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					row.put(columnLabel, rs.getObject(columnLabel));
				}
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			DBConnection.close(rs, ps, conn);
		}
		return data;
	}

	/*
	 * 查询一个对象的方法
	 * 
	 * sql: 要执行的sql语句 obj：可变参数列表
	 */
	public Map<String, Object> query(String sql, Object... obj) {
		Map<String, Object> data = null;
		Connection conn = DBConnection.getConnection(); // 获得连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 创建PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 为查询语句设置参数
			setParameter(ps, obj);
			// 获得ResultSet结果集
			rs = ps.executeQuery();
			// 获得结果集信息
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获得列的总数
			int columnCount = rsmd.getColumnCount();
			// 遍历结果集，根据信息封装成Map
			while (rs.next()) {
				data = new HashMap<String, Object>();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					data.put(columnLabel, rs.getObject(columnLabel));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			DBConnection.close(rs, ps, conn);
		}
		return data;
	}

	/*
	 * 增加、修改、删除的方法
	 * 
	 * obj: 可变参数列表
	 */
	public int update(String sql, Object... obj) {
		Connection conn = DBConnection.getConnection(); // 获得连接
		PreparedStatement ps = null;
		int rows = 0;
		try {
			// 创建PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 为查询语句设置参数
			setParameter(ps, obj);
			// 获得受影响的行数
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			DBConnection.close(null, ps, conn);
		}
		return rows;
	}

	/*
	 * 为预编译对象设置参数
	 */
	public void setParameter(PreparedStatement ps, Object... obj) throws SQLException {
		if (obj != null && obj.length > 0) {
			// 循环设置参数
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
		}
	}

}
