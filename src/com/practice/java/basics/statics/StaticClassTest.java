package com.practice.java.basics.statics;

public class StaticClassTest {
	private static StaticClassTest myClass = null;
	
	private StaticClassTest(){		
	}
	
	public StaticClassTest(String string) {
		
	}

	public static final StaticClassTest getInstance(){
		if(myClass == null){
			myClass = new StaticClassTest();
		}
		return myClass;
	}

	public static void methodOne(){
		System.out.println("first method without args in superclass");
	}

	public static String methodOne(String test){
		System.out.println("first method");
		return test;
	}
	
	public void StaticClassTest(String args) {
		System.out.print(args);
	}
	
	public static void main(String args[]) {
		new StaticClassTest().StaticClassTest("temp");
	}

}
