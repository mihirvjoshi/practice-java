package com.practice.java.reflection;

public class SubClass1 extends SuperClass{

	public SubClass1(){
		System.out.println("I am SubClass1");
	}

	public void callMethod(){
		super.callMethod();
		System.out.println("callMethod called in Sub class1");
	}
	
	public void dummy(){
		System.out.println("dummy subclass1");
	}

	public static void main(String args[]){
		SuperClass supertype = new SubClass1(); //invalid code though compiles well.
		supertype.callMethod();
	}
}
