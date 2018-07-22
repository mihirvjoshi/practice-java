package com.practice.java.jdk8;

/**
 * Functional class is using functional interface 
 * @author Mihir
 *
 */
public class MyFunctionalClass1 implements MyFunctionalInterface1 {

	@Override
	public void function(String str) {

	}

	public static void main(String[] args) {
		MyFunctionalInterface1 mfi = new MyFunctionalClass1();
		mfi.log("hello");
		MyFunctionalInterface1.print("hello");
		MyFunctionalInterface1 myfunction = (msg)->System.out.println("Function " + msg);
		myfunction.function("Test");
	}
}
