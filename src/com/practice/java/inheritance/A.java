package com.practice.java.inheritance;

public class A {
	A a;

	public A() {
		this.a=new B();
		System.out.println("A instantiated =>"+a.getClass());
	}
	
}
