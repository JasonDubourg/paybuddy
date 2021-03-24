package com.ocr.paybuddy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ocr.paybuddy.config.Config;

public class ConnectionFactory {

	public static void main(String... args) {
		Config config = new Config();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(config.DB_URL + "?user=" + config.USER + "&" + config.PASS + "=");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM USER");
			while (rs.next()) {
				int id = rs.getInt("id");
				String prenom = rs.getString("first_name");
				String nom = rs.getString("last_name");
				System.out.println("L'utilisateur " + id + " s'appelle " + prenom + " " + nom);
			}

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
