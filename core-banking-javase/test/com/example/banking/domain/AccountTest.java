package com.example.banking.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class AccountTest {

	@ParameterizedTest  
	@CsvSource(value = { "-1", "-1.1", "-0.10", "0.0" })
	@DisplayName("Withdraw with negative amount should fail")
	void withdraw_with_negative_amount_should_fail(double amount) {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000);
		// 2. Call exercise method
		var balance = acc.withdraw(amount);
		// 3. Verification
		assertAll(() -> assertEquals(10_000, balance), () -> assertEquals("tr1", acc.getIban()));
		// 4. Destroy test setup
		// empty/no op
	}

	@Test
	void widthdraw_amount_greater_than_balance_should_fail() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000);
		// 2. Call exercise method
		var balance = acc.withdraw(10_001);
		// 3. Verification
		assertAll(() -> assertEquals(10_000, balance), () -> assertEquals("tr1", acc.getIban()));
	}

	@Test
	void widthdraw_all_balance_should_be_successful() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000);
		// 2. Call exercise method
		var balance = acc.withdraw(10_000);
		// 3. Verification
		assertAll(() -> assertEquals(0.0, balance), () -> assertEquals("tr1", acc.getIban()));
	}

	@ParameterizedTest
	@CsvSource(value = { "-1", "-1.1", "-0.10", "0.0" })
	@DisplayName("Deposit with negative amount should fail")
	void deposit_with_negative_amount_should_fail(double amount) {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000);
		// 2. Call exercise method
		var balance = acc.deposit(amount);
		// 3. Verification
		assertAll(() -> assertEquals(10_000, balance), () -> assertEquals("tr1", acc.getIban()));
		// 4. Destroy test setup
		// empty/no op
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "deposit_values.csv")
	void deposit_positive_amount_should_be_successful(double initialBalance,double amount,double depositAmount) throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", initialBalance);
		// 2. Call exercise method
		var balanceAfterDeposit = acc.deposit(amount);
		// 3. Verification
		assertAll(
				() -> assertEquals(depositAmount, balanceAfterDeposit,0.001), 
				() -> assertEquals(depositAmount, acc.getBalance(),0.001), 
				() -> assertEquals("tr1", acc.getIban())
		);
	}
	
	@Test
	public void toStringTest() {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000);
		// 2. Call exercise method
		var str = acc.toString();		
		// 3. Verification
		assertAll(
			() -> assertTrue(str.contains("iban=")),	
			() -> assertTrue(str.contains("balance="))	
		);
	}
	
}
