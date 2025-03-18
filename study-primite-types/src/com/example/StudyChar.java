package com.example;

import java.util.Locale;

public class StudyChar {

	public static void main(String[] args) {
		// char: 2B
		char x = 'a';
		System.out.println(x);
		System.out.println((int)x);
		x++;
		System.out.println(x);
		System.out.println((int)x);
		System.out.println((char)(x+1));
		// unicode
		x = '\u20ba';
		System.out.println(x);
		String y = "\ud834\udd1e"; // 4B
		System.out.println(y);
		String name = "jack"; // immutable
		System.out.println(name);
		name = name.toUpperCase();
		System.out.println(name);
		String city = "izmir";
		System.out.println(city);
		city = city.toUpperCase(Locale.of("tr", "TR"));
		System.out.println(city);
		
	}

}
