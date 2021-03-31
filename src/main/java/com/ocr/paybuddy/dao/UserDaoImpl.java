package com.ocr.paybuddy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ocr.paybuddy.model.User;

@Component
public class UserDaoImpl implements IUserDao {

	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public List<User> getConnectionsFromUserList(int userID) {
		String query = "SELECT * FROM user INNER JOIN connection ON user.id = connection.buddy_id WHERE owner_id =?";
		return JdbcTemplate.query(query, new UserRowMapper(), userID);
	}

}
