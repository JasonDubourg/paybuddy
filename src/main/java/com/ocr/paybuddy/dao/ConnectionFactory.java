package com.ocr.paybuddy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static final String DB_URL = "jdbc:mariadb://localhost:3306/paybuddy";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String... args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL + "?user=" + USER + "&" + PASS + "=");
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
