package com.ocr.paybuddy.dao;

import java.util.List;

import com.ocr.paybuddy.model.User;

public interface IUserDao {

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_LAST_NAME = "first_name";
	public static final String COLUMN_FIRST_NAME = "last_name";
	public static final String COLUMN_MAIL = "mail";
	public static final String COLUMN_IBAN = "iban";
	public static final String COLUMN_BALANCE = "balance";
	public static final String COLUMN_SOCIALE_MEDIA = "social_media";

	public List<User> getConnectionsFromUserList(int userID);
}
