package com.example;

import java.math.BigDecimal;

public class StudyFloatingPointTypes {

	public static void main(String[] args) {
		// IEEE-754
		// float : 4-Byte
		float x = 3.1415F;
		// double: 8-Byte
		double y = 123.456;
		// CPU: FPU
		double money = 2.0;
		money = money - 1.10;
		System.out.println(money);
		money = 4.35;
		money = 100 * money;
		System.out.println(money);
		x = 1_000_000_000;
		x = x + 50;
		System.out.println("%16.3f".formatted(x));
		boolean isEqual = (0.1 + 0.2) + 0.3 == 0.1 + (0.2 + 0.3);
		System.out.println(isEqual);
		// Immutable
		BigDecimal bd = new BigDecimal("2.0");
		bd = bd.subtract(new BigDecimal("1.1"));
		System.out.println(bd.toPlainString());
		// y = 0 / 0 ; // ALU -> ArithmeticException
		y = 0.0 / 0.0; // FPU -> IEEE-754 -> NaN
		System.out.println("y: "+y);
		y = 1.0 / 0.0; // FPU -> IEEE-754 -> Inf
		System.out.println("y: "+y);
		y = 1.0 / -0.0; // FPU -> IEEE-754 -> -Inf
		System.out.println("y: "+y);
		y = 0.0 / 0.0; // FPU -> IEEE-754 -> NaN
		System.out.println(Double.isNaN(y));
	}

}
