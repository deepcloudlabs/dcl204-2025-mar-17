package com.example.banking.app;

public class StudyVariables {

	public static void main(String[] args) {
		int x = 100;
		A a = new A(42);
		System.out.println(a.x);
		B b = new B(10);
		System.out.println(b.x);
		System.out.println(x);
		A p = new B(4);
		System.out.println(p.x); // 16
		p.fun(); // polymorphism
		System.out.println(p.x); // 16
		p = new A(5);
		p.fun();
		System.out.println(p.x); // 25
	}

}

class A {
	int x;

	public A(int x) {
		this.x = x;
	}

	public void fun() {
		System.out.println("[A::fun] x: " + x);
	}
}

class B extends A {
	int x;

	public B(int x) {
		super(x * x);
		this.x = x;
	}

	public void fun() {
		System.out.println("[B::fun] x: " + x);
	}
}