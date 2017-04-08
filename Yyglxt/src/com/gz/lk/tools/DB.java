package com.gz.lk.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

//�������ݿ����ӷ�װDB  �쳣
public class DB {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private void getConnection() {
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// (����������)��ȡ����
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3308/yyglxt", "root", "mysql");
			// (�����Ӷ���ȥ)���������� (���ã�����ͨ���ö�����ķ���ȥ�������ݿ�)
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int update(String sql) {// ��ɾ��
		// �Ȼ�ȡ����
		getConnection();
		int num = -1;//
		try {
			num = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return num;

	}

	public ArrayList<HashMap<String, String>> query(String sql) {
		// ������ȡ���� ���� ArrayList<HashMap<String,String>>
		ArrayList<HashMap<String, String>> arr = new ArrayList<HashMap<String, String>>();// ��������������������ݻ�ȡ������
																							// �˼����ܹ����з���ʹ��
		getConnection();// ��ȡһ������
		try {
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();// ��ȡ������ṹ����
			int count = rsmd.getColumnCount();// ��ȡ�ֶ�����

			while (rs.next()) {

				HashMap<String, String> hm = new HashMap<String, String>();// whileѭ��һ�δ���һ��Hashmap���������洢һ������

				for (int i = 1; i <= count; i++) {
					// rsmd.getColumnName(i)��ȡ�ֶ�����
					hm.put(rsmd.getColumnName(i), rs.getString(i));// ��ȡ�ֶ�����
																	// ����֮��Ӧ������
																	// ����һ��Ԫ�ش����Hashmap������

				}

				arr.add(hm);// ��Hashmap�����ŵ�Arraylist����

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();// �ر�����
		}

		return arr;// �ѷ�װ�õĽ�����ظ����ö�

	}

	public ArrayList<String[]> arrQuery(String sql) {
		ArrayList<String[]> arr = new ArrayList<String[]>();// ��������������������ݻ�ȡ������
															// �˼����ܹ����з���ʹ��
		getConnection();
		try {
			rs = stmt.executeQuery(sql);
			// �ֶ�����
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();

			while (rs.next()) {

				String[] str = new String[count];

				for (int i = 1; i <= count; i++) {

					str[i - 1] = rs.getString(i);

				}
				arr.add(str);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return arr;

	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 2 3
	public ArrayList<String[]> pageQuery(String sql, int currentPageNum,
			int pageCount) {

		String newSql = sql + " limit " + (currentPageNum - 1) * pageCount
				+ "," + pageCount;
		return arrQuery(newSql);

	}

	public static void main(String[] args) {
		DB db = new DB();
		ArrayList<String[]> arr = db.arrQuery("select * from upfilms");

		for (int i = 0; i < arr.size(); i++) {
			String[] st = arr.get(i);
			for (int j = 0; j < st.length; j++) {
				System.out.print(st[j] + " ");
			}
			System.out.println();

		}

	}

}
