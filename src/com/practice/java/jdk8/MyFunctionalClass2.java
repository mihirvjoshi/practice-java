package com.practice.java.jdk8;

/**
 * This Functional class is using two functional interfaces and both interfaces have same method signatures,
 * and so here class must have it's own implementations or otherwise it'll not compile due to conflicts. 
 * @author Mihir
 *
 */
public class MyFunctionalClass2 implements MyFunctionalInterface1, MyFunctionalInterface2 {

	@Override
	public void function(String str) {}

	public void log(String str){
		System.out.println("logging::"+str);
	}
	
	public static void main(String[] args) {
		MyFunctionalInterface1 mfi = new MyFunctionalClass2();
		mfi.log("hello");
		MyFunctionalInterface1.print("hello");
		
		MyFunctionalInterface1 myfunction = (msg)->System.out.println("Function 1 " + msg);
		myfunction.function("Test");
	}
}
