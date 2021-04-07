package com.ocr.paybuddy.dao;

import java.util.List;

import com.ocr.paybuddy.model.Transaction;

public interface ITransactionDao {

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_AMOUNT = "amount";
	public static final String COLUMN_FARE = "fare";
	public static final String COLUMN_SENDER_ID = "sender_id";
	public static final String COLUMN_RECEIVER = "first_name";

	public List<Transaction> getUserTransactions(int userID);

	public void updateBalance(double amount, int id);

	public void addTransaction(String description, double amount, double fare, int idSender, int idReceiver);

}
