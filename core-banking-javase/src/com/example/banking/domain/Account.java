package com.example.banking.domain;

public class Account {
	// Attributes: data/property/state
	private String iban;
	private double balance;

	// Behaviors: method
	// Constructor
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	// business method
	public double withdraw(double amount) {
		// validation
		if (amount <= 0.0) {
			return this.balance;
		}
		// business rule
		if (amount > this.balance) {
			return this.balance;
		}
		// business logic
		this.balance = this.balance - amount;
		return this.balance;
	}

	public double deposit(double amount) {
		// validation
		if (amount <= 0.0) {
			return this.balance;
		}
		this.balance = this.balance + amount;
		return this.balance;
	}
}