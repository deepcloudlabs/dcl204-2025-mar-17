package com.example.banking.domain;
// Ctrl + Shift + F -> Format
// Ctrl + Alt + Arrow (Down) -> Duplicate Line
// Alt + Arrow (Down/Up) -> Move line
// Ctrl + D -> Delete Line
// Alt + Shift + S -> Generate Source code
public class Account extends Object {
	// Attributes: data/property/state
	private final String iban;
	protected double balance;

	// Behaviors: method
	// Constructor
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public double withdraw(double amount) {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0.0) {
			return this.balance;
		}
		// business rule
		if (amount > this.balance) {
			return this.balance;
		}
		// business logic
		this.balance -= amount;
		return this.balance;
	}

	public double deposit(double amount) {
		// validation
		if (amount <= 0.0) {
			return this.balance;
		}
		this.balance += amount;
		return this.balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
	
}