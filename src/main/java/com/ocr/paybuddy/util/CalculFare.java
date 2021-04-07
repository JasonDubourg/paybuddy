package com.ocr.paybuddy.util;

public class CalculFare {

	private static final double pourcentFare = 0.005;

	public static double calculTransactionFare(double amount) {
		return amount * pourcentFare;
	}

}
