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
	 * ��ѯ�������ķ���
	 * 
	 * sql: Ҫִ�е�sql��� obj���ɱ�����б�
	 */
	public List<Map<String, Object>> queryList(String sql, Object... obj) {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Connection conn = DBConnection.getConnection(); // �������
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ����PreparedStatement����
			ps = conn.prepareStatement(sql);
			// Ϊ��ѯ������ò���
			setParameter(ps, obj);
			// ���ResultSet�����
			rs = ps.executeQuery();
			// ��ý������Ϣ
			ResultSetMetaData rsmd = rs.getMetaData();
			// ����е�����
			int columnCount = rsmd.getColumnCount();
			Map<String, Object> row = null;
			// �����������������Ϣ��װ��Map
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
			// �ر�����
			DBConnection.close(rs, ps, conn);
		}
		return data;
	}

	/*
	 * ��ѯһ������ķ���
	 * 
	 * sql: Ҫִ�е�sql��� obj���ɱ�����б�
	 */
	public Map<String, Object> query(String sql, Object... obj) {
		Map<String, Object> data = null;
		Connection conn = DBConnection.getConnection(); // �������
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ����PreparedStatement����
			ps = conn.prepareStatement(sql);
			// Ϊ��ѯ������ò���
			setParameter(ps, obj);
			// ���ResultSet�����
			rs = ps.executeQuery();
			// ��ý������Ϣ
			ResultSetMetaData rsmd = rs.getMetaData();
			// ����е�����
			int columnCount = rsmd.getColumnCount();
			// �����������������Ϣ��װ��Map
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
			// �ر�����
			DBConnection.close(rs, ps, conn);
		}
		return data;
	}

	/*
	 * ���ӡ��޸ġ�ɾ���ķ���
	 * 
	 * obj: �ɱ�����б�
	 */
	public int update(String sql, Object... obj) {
		Connection conn = DBConnection.getConnection(); // �������
		PreparedStatement ps = null;
		int rows = 0;
		try {
			// ����PreparedStatement����
			ps = conn.prepareStatement(sql);
			// Ϊ��ѯ������ò���
			setParameter(ps, obj);
			// �����Ӱ�������
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر�����
			DBConnection.close(null, ps, conn);
		}
		return rows;
	}

	/*
	 * ΪԤ����������ò���
	 */
	public void setParameter(PreparedStatement ps, Object... obj) throws SQLException {
		if (obj != null && obj.length > 0) {
			// ѭ�����ò���
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
		}
	}

}
