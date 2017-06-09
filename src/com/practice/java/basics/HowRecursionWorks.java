package com.practice.java.basics;

public class HowRecursionWorks {

	public void callRecursion(int stopValue){		
		if(stopValue == 1) {
			return;
		} else {
			callRecursion(stopValue/2);
		}		
		//should print the values in reverse order of calling
		//because all values are stored on the stack
		System.out.println(stopValue);
	}	
	
	public static void main(String[] args) {	 
		new HowRecursionWorks().callRecursion(10);
		System.out.println();		
	}
}
