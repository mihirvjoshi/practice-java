package com.practice.java.jdk8;

/**
 * In functional interfaces(interface with only one method are by default functional interface) now you can
 * have method body for default & static implmentations. 
 * @author Mihir
 *
 */
@FunctionalInterface
public interface MyFunctionalInterface2 {
	void function(String str);
	
	default void log(String str){
		System.out.println("logging in interface 2::"+str);
	}
	
	static void print(String str){
		System.out.println("printing in inteface 2::"+str);
	}
}
