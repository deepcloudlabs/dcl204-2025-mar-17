package com.example.banking.app;

import com.example.banking.domain.Account;

// Ctrl + Shift + O
public class BankingApp {

	public static void main(String[] args) {
		// reference variable -> Heap Object
		Account acc1 = new Account("tr1", 10_000);
		System.out.println(acc1.balance);
	}

}
