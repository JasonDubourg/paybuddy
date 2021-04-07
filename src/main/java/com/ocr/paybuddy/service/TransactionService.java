package com.ocr.paybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocr.paybuddy.dao.TransactionDaoImpl;
import com.ocr.paybuddy.dao.UserDaoImpl;
import com.ocr.paybuddy.dto.ListUserTransactionsDto;
import com.ocr.paybuddy.model.User;
import com.ocr.paybuddy.util.CalculFare;

@Service
public class TransactionService {

	@Autowired
	TransactionDaoImpl transactionDaoImpl;

	@Autowired
	UserDaoImpl userDaoImpl;

	public ListUserTransactionsDto getUserTransactions(int id) {
		ListUserTransactionsDto listUserTransactions = new ListUserTransactionsDto(
				transactionDaoImpl.getUserTransactions(id));
		return listUserTransactions;
	}

	@Transactional(rollbackFor = Exception.class)
	public void sendMoney(int idSender, int idReceiver, String description, double amount) throws Exception {
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
		} else {
			System.out.println("Not enough money");
		}
		throw new Exception("Error send money");
	}

}
