package com.ocr.paybuddy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ocr.paybuddy.model.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Transaction transaction = new Transaction(rs.getInt(ITransactionDao.COLUMN_ID),
				rs.getString(ITransactionDao.COLUMN_DESCRIPTION), rs.getDouble(ITransactionDao.COLUMN_AMOUNT),
				rs.getDouble(ITransactionDao.COLUMN_FARE), rs.getString(ITransactionDao.COLUMN_SENDER_ID),
				rs.getString(ITransactionDao.COLUMN_RECEIVER));
		return transaction;
	}
}
