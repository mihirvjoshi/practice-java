package com.practice.java.basics.statics;

public class StaticClassTwoTest extends StaticClassTest {
	
	public StaticClassTwoTest(String string) {
		super(string);
	}

	public static void main (String args[]) {
//		StaticClassTest test =  new StaticClassTwoTest();
//		test.methodOne();
//		new StaticClassTest("temp");
		StaticClassTest.getInstance().main(args);
	}
	
	public static void methodOne(){
		System.out.println("first method without args");
	}

	public static String methodOne(String test){
		String temp = test + String.valueOf(Math.random());
	
		System.out.println("first method" + temp );
		return temp;
	}

}
