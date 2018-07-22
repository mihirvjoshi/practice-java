package com.practice.java.basics;

public class StackOverFlowExample {

	private void overflowMethod(){
		this.overflowMethod();
	}
	
	public static void main(String args[]) {
		StackOverFlowExample stackOverFlowExp = new StackOverFlowExample();
		stackOverFlowExp.overflowMethod();
	}
}
