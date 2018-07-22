package com.practice.java.reflection;

public class SubClass1_1 extends SubClass1{

	public SubClass1_1(){
		System.out.println("I am SubClass1_1");
	}

	public void dummy(){
		System.out.println("dummy subclass1_1");
	}

	public static void main(String args[]){
		SuperClass supertype = new SubClass1_1(); //invalid code though compiles well.
		supertype.callMethod();
	}
}
