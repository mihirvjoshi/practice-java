package com.practice.java.inheritance;

public class ChildClass extends BaseClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BaseClass b = new ChildClass();
		try {
			b.commonMethodWithException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * overriding method from base but without Exception in the signature
	 */
	@Override
	public void commonMethodWithException()  {
		System.out.println("I'm overridden child without Exception in the method signature");		
	}
}
