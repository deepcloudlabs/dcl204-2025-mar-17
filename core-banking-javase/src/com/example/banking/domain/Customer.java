package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer {
	// information hiding: private
	private final String identity;
	private String fullName;
	private final List<Account> accounts;

	public Customer(String identity, String fullName) {
		this.identity = identity;
		this.fullName = fullName;
		this.accounts = new ArrayList<>();
	}

	public String getIdentity() {
		return identity;
	}

	public String getFullName() {
		return fullName;
	}

	public List<Account> getAccounts() {
		return List.copyOf(this.accounts); // information hiding
	}

	// business methods
	public boolean addAccount(Account account) { // polymorphism
		for (var acc : this.accounts) {
			if (acc.getIban().equals(account.getIban()))
				return false;
		}
		this.accounts.add(account);
		return true;
	}

	// since Java SE 8
	public Optional<Account> getAccount(String iban) {
		for (var acc : this.accounts) {
			if (acc.getIban().equals(iban))
				return Optional.of(acc);
		}
		return Optional.empty();
	}
	
    // overloading vs overriding
	public boolean removeAccount(Account account) { // polymorphism
		var foundAccount = getAccount(account.getIban());
		foundAccount.ifPresent(accounts::remove);
		return foundAccount.isPresent();
	}
	
	public boolean removeAccount(String iban) { // polymorphism
		var foundAccount = getAccount(iban);
		foundAccount.ifPresent(accounts::remove);
		return foundAccount.isPresent();
	}

}
