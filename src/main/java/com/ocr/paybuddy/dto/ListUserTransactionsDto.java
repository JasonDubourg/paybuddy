package com.ocr.paybuddy.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ocr.paybuddy.model.Transaction;

@Component
public class ListUserTransactionsDto {

	private List<Transaction> listUserTransaction;

	public ListUserTransactionsDto(List<Transaction> listUserTransaction) {
		this.listUserTransaction = listUserTransaction;
	}

	public List<Transaction> getListUserTransaction() {
		return listUserTransaction;
	}

	public void setListUserTransaction(List<Transaction> listUserTransaction) {
		this.listUserTransaction = listUserTransaction;
	}

}
