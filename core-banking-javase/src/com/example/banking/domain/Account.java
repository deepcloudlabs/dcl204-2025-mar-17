package com.example.banking.domain;

public class Account {
   // Attributes: data/property/state
   private String iban;
   public double balance;
   // Behaviors: method	
   // Constructor
   public Account(String iban,double balance) {
	   this.iban = iban;
	   this.balance = balance;
   }
   
}