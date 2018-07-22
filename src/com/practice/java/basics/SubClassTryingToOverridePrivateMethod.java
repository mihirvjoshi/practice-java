package com.practice.java.basics;

public class SubClassTryingToOverridePrivateMethod extends SuperClassToBeOverridden {
	public int temp;
	
	private void overriddenMethod(){
		System.out.println("Hey i'm child method.");
	}

	public void overriddenMethod(String str) throws RuntimeException{
//		super.overriddenMethod(str);
		System.out.println(str.toString());
	}

	public static void main(String args[]) {
		SubClassTryingToOverridePrivateMethod superClass = new SubClassTryingToOverridePrivateMethod();
		superClass.overriddenMethod();

		SuperClassToBeOverridden superClass1 = new SubClassTryingToOverridePrivateMethod();
		superClass1.overriddenMethod(null);
	}
}
