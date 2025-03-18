package com.example.domain;

public class StudyIfElse {
	public static void main(String[] args) {
		int x = 108;
		if (x % 2 == 0) { // even 
			System.out.println("even");
		} else {
			System.out.println("odd");			
		}
		int weekDay = 2;
		if (weekDay >=1 && weekDay<5) {
			System.out.println("Work hard!");
		} else if (weekDay == 5) {
			System.out.println("Thanks god. It is Friday!");
		} else {
			System.out.println("Have fun now!");
		}
	}
}
