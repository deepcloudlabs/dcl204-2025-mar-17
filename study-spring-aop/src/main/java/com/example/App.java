package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.impl.SimpleCalculator;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new AnnotationConfigApplicationContext("com.example.config");
		var calc = container.getBean(SimpleCalculator.class);
		System.out.println(calc.getClass());
		calc.add(3, 5);
		calc.sub(7, 4);
		calc.mul(3, 2);
		calc.div(5, 3);
		container.close();
	}
}
