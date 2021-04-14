package com.ocr.paybuddy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocr.paybuddy.dao.TransactionDaoImpl;
import com.ocr.paybuddy.dao.UserDaoImpl;
import com.ocr.paybuddy.dto.TransactionDto;
import com.ocr.paybuddy.model.Transaction;
import com.ocr.paybuddy.model.User;
import com.ocr.paybuddy.util.CalculFare;

@Service
public class TransactionService {

	@Autowired
	TransactionDaoImpl transactionDaoImpl;

	@Autowired
	UserDaoImpl userDaoImpl;

	public List<TransactionDto> getUserTransactions(int id) {
		List<TransactionDto> transactionList = new ArrayList<>();
		List<Transaction> listUserTransactions = transactionDaoImpl.getUserTransactions(id);
		for (Transaction transaction : listUserTransactions) {
			TransactionDto transactionDto = new TransactionDto();
			transactionDto.setReceiver(transaction.getReceiver());
			transactionDto.setDescription(transaction.getDescription());
			transactionDto.setAmout(transaction.getAmout());
			transactionList.add(transactionDto);
		}
		return transactionList;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean sendMoney(int idSender, int idReceiver, String description, double amount) throws Exception {
		boolean sendSuccess = false;
		// Calcul du Fare
		double fare = CalculFare.calculTransactionFare(amount);
		// Récupérer la balance du sender
		User sender = userDaoImpl.getUserInfos(idSender);
		// Vérifier si le sendeur à les fonds suffisants
		if (sender.getBalance() >= (amount + fare)) {
			// Récupérer la balance du receiver
			User receiver = userDaoImpl.getUserInfos(idReceiver);
			// Calcul de la nouvelle balance pour le débiteur
			sender.setBalance(sender.getBalance() - (amount + fare));
			// Calcul de la nouvelle balance pour le créditeur
			receiver.setBalance(receiver.getBalance() + amount);
			// Requêtes pour enregistrer la transaction en BDD
			transactionDaoImpl.updateBalance(sender.getBalance(), idSender);
			transactionDaoImpl.updateBalance(receiver.getBalance(), idReceiver);
			transactionDaoImpl.addTransaction(description, amount, fare, idSender, idReceiver);
			return sendSuccess = true;
		} else {
			System.out.println("Not enough money");
			return sendSuccess = false;
		}
	}
}
