package com.example.banking.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CheckingAccountTest {

	@ParameterizedTest
	@CsvSource(value = { "-1", "-1.1", "-0.10", "0.0" })
	@DisplayName("Withdraw with negative amount should fail")
	void withdraw_with_negative_amount_should_fail(double amount) {
		// 1. Test Fixture/Setup
		var acc = new CheckingAccount("tr1", 10_000,500);
		// 2. Call exercise method
		var balance = acc.withdraw(amount);
		// 3. Verification
		assertAll(() -> assertEquals(10_000, balance), () -> assertEquals("tr1", acc.getIban()));
		// 4. Destroy test setup
		// empty/no op
	}

	@Test
	void widthdraw_amount_greater_than_balance_plus_overfraftAmount_should_fail() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new CheckingAccount("tr1", 10_000,500);
		// 2. Call exercise method
		var balance = acc.withdraw(10_501);
		// 3. Verification
		assertAll(() -> assertEquals(10_000, balance), () -> assertEquals("tr1", acc.getIban()));
	}

	@Test
	void widthdraw_all_balance_should_be_successful() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new CheckingAccount("tr1", 10_000,500);
		// 2. Call exercise method
		var balance = acc.withdraw(10_000);
		// 3. Verification
		assertAll(() -> assertEquals(0.0, balance), () -> assertEquals("tr1", acc.getIban()));
	}
	
	@Test
	void widthdraw_all_balance_plus_overdraft_should_be_successful() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new CheckingAccount("tr1", 10_000,500);
		// 2. Call exercise method
		var balance = acc.withdraw(10_500);
		// 3. Verification
		assertAll(() -> assertEquals(-500, balance), () -> assertEquals("tr1", acc.getIban()));
	}
	@Test
	public void toStringTest() {
		// 1. Test Fixture/Setup
		var acc = new CheckingAccount("tr1", 10_000,500);
		// 2. Call exercise method
		var str = acc.toString();		
		// 3. Verification
		assertAll(
			() -> assertTrue(str.contains("CheckingAccount")),	
			() -> assertTrue(str.contains("iban=")),	
			() -> assertTrue(str.contains("balance=")),	
			() -> assertTrue(str.contains("overdraftAmount="))	
		);
	}
	
}
