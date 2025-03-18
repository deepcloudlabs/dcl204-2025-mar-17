package com.example.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void load_negative_weight_should_return_false() {
		// Test Fixture/Setup
		Vehicle v = new Vehicle(1_000, 0);
		// call exercise method
		boolean result = v.load(-1);
		// verification
		assertFalse(result);
		assertEquals(1_000, v.getMaxLoad());
		assertEquals(0, v.getCurrentLoad());
	}
	
	@Test
	void load_over_weight_should_return_false() {
		// Test Fixture/Setup
		Vehicle v = new Vehicle(1_000, 0);
		// call exercise method
		boolean result = v.load(1001);
		// verification
		assertFalse(result);
		assertEquals(1_000, v.getMaxLoad());
		assertEquals(0, v.getCurrentLoad());
	}	
	@Test
	void load_normal_weight_should_return_true() {
		// Test Fixture/Setup
		Vehicle v = new Vehicle(1_000, 0);
		// call exercise method
		boolean result = v.load(1000);
		// verification
		assertTrue(result);
		assertEquals(1_000, v.getMaxLoad());
		assertEquals(1_000, v.getCurrentLoad());
	}
}
