package com.practice.java.reflection;

public abstract class SuperClass {

	abstract public void dummy();
	
	public SuperClass(){
		System.out.println("I am SuperClass");
	}

	public void callMethod(){
		this.dummy();
		System.out.println("callMethod called in Super class");
	}

	public static void main(String args[]){
		new SubClass1().callMethod(); //over loading
	}

}
