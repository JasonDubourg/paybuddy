package com.ocr.paybuddy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ocr.paybuddy.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
		User user = new User(rs.getInt(IUserDao.COLUMN_ID), rs.getString(IUserDao.COLUMN_FIRST_NAME),
				rs.getString(IUserDao.COLUMN_LAST_NAME), rs.getString(IUserDao.COLUMN_MAIL),
				rs.getString(IUserDao.COLUMN_PASSWORD), rs.getString(IUserDao.COLUMN_SOCIALE_MEDIA),
				rs.getDouble(IUserDao.COLUMN_BALANCE), rs.getString(IUserDao.COLUMN_IBAN));
		return user;
	}

}
