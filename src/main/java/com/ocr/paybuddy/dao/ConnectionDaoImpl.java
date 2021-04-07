package com.ocr.paybuddy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConnectionDaoImpl {

	@Autowired
	JdbcTemplate JdbcTemplate;

	public void addConnection(int owner_id, int buddy_id) {
		String query = "INSERT INTO connection (owner_id, buddy_id) VALUES (?,?)";
		JdbcTemplate.update(query, owner_id, buddy_id);
	}
}
