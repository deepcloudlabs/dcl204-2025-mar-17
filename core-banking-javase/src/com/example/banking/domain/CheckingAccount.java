package com.example.banking.domain;

// Account         -> Super Class/Base Class
// CheckingAccount -> Sub-class  /Derived Class
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public double withdraw(double amount) {
		// validation
		if (amount <= 0.0)
			return this.balance;
		// business rule
		if (amount > (this.balance+this.overdraftAmount))
			return this.balance;
		this.balance -= amount;	
		return this.balance;
	}
	
	@Override
	public String toString() {
		return "CheckingAccount [iban=" + getIban() + ", balance=" + balance + ", overdraftAmount=" + getOverdraftAmount()+ "]";
	}
}
