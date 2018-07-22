package com.practice.java.basics;

public class SuperClassToBeOverridden {

	protected int temp = 1;
	private void overriddenMethod(){
		System.out.println("Hey i'm parent method.");
	}
	
	public void overriddenMethod(String str) throws NullPointerException{
		System.out.println(str.toString());
	}
}
