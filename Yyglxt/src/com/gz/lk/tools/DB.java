package com.gz.lk.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

//进行数据库连接封装DB  异常
public class DB {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private void getConnection() {
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// (驱动管理者)获取连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3308/yyglxt", "root", "mysql");
			// (用连接对象去)创建语句对象 (作用：可以通过该对象里的方法去操作数据库)
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int update(String sql) {// 增删改
		// 先获取连接
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
		// 把数据取出来 放在 ArrayList<HashMap<String,String>>
		ArrayList<HashMap<String, String>> arr = new ArrayList<HashMap<String, String>>();// 创建集合用来保存从数据获取的数据
																							// 此集合能够进行反复使用
		getConnection();// 获取一个连接
		try {
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();// 获取结果集结构对象
			int count = rsmd.getColumnCount();// 获取字段总数

			while (rs.next()) {

				HashMap<String, String> hm = new HashMap<String, String>();// while循环一次创建一个Hashmap对象用来存储一条数据

				for (int i = 1; i <= count; i++) {
					// rsmd.getColumnName(i)获取字段名称
					hm.put(rsmd.getColumnName(i), rs.getString(i));// 获取字段名称
																	// 和与之对应的数据
																	// 当成一个元素存放在Hashmap对象中

				}

				arr.add(hm);// 把Hashmap对象存放到Arraylist当中

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();// 关闭连接
		}

		return arr;// 把封装好的结果返回给调用端

	}

	public ArrayList<String[]> arrQuery(String sql) {
		ArrayList<String[]> arr = new ArrayList<String[]>();// 创建集合用来保存从数据获取的数据
															// 此集合能够进行反复使用
		getConnection();
		try {
			rs = stmt.executeQuery(sql);
			// 字段总数
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
