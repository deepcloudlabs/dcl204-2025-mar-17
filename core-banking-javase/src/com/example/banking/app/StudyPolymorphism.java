package com.example.banking.app;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

public class StudyPolymorphism {
	public static void main(String[] args) {
		Account acc;
		if (ThreadLocalRandom.current().nextBoolean()) {
			acc = new Account("tr1", 10_000);
		} else {
			acc = new CheckingAccount("tr1", 10_000,500);
		}
		System.out.println(acc.getClass());
		acc.withdraw(1_000);
	}
}
