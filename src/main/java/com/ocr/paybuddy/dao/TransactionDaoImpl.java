package com.ocr.paybuddy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ocr.paybuddy.model.Transaction;

@Component
public class TransactionDaoImpl implements ITransactionDao {

	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public List<Transaction> getUserTransactions(int userID) {
		String query = "SELECT * FROM user INNER JOIN transaction t ON user.id = t.receiver_id where t.sender_id = ?";
		return JdbcTemplate.query(query, new TransactionRowMapper(), userID);
	}

	@Override
	public void updateBalance(double amount, int id) {
		String query = "UPDATE user set balance = ? where id = ?";
		JdbcTemplate.update(query, amount, id);
	}

	public void addTransaction(String description, double amount, double fare, int idSender, int idReceiver) {
		String query = "INSERT INTO transaction (description, amount, fare, sender_id, receiver_id) VALUES (?,?,?,?,?)";
		JdbcTemplate.update(query, description, amount, fare, idSender, idReceiver);
	}

}
