package com.practice.java.jdk8.lambda;

public class LambdaExp {
	interface Calculate{
		int operation(int x, int y);
	}
	
	interface Display {
		void message(String msg);		
	}
	
	private int operate(int x, int y, Calculate calc){
		return calc.operation(x, y);
	}
	
	public static void main(String args[]) {

		LambdaExp lambda = new LambdaExp();
		Calculate multiply = (int p, int q) -> p * q; // the one with int type declaration for params
		Calculate add = (p, q) -> { //the one without type declaration (silent) and with return type in curly braces.
			return p + q;
		};

		// with parenthesis
		Display msg1 = (msg) -> System.out.println("Operation-> Multiply two numbers below:" );
		System.out.println("6 x 12 = " + lambda.operate(6, 12, multiply));

		Display msg2 = msg -> System.out.println("Operation: " + msg);
		msg2.message("Add two numbers:");
		System.out.println("6 + 12 = " + lambda.operate(6, 12, add));
	}
}
