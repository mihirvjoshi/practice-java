package com.practice.java.reflection;

public class SubClass2 extends SuperClass{

	public SubClass2(){
		System.out.println("I am SubClass2");
	}
	
	public void callMethod(){
		super.callMethod();
		System.out.println("Method called in Sub class2");
	}

	@Override
	public void dummy() {
		System.out.println("dummy called in SubClass2");
		
	}
}
