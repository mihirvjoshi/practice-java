package com.practice.java.inheritance;

public class B extends A {
    B b;
	public B() {
//		super();
		this.b=(B) new A();
		System.out.println("B instantiated =>"+b.getClass());
		System.out.println("A instantiated again =>"+a.getClass());
	}

	public static void main(String args[]){
		B b = new B();
		System.out.println(b.getClass());
		A a = (A)new B();
		System.out.println(a.getClass());
	}
}
