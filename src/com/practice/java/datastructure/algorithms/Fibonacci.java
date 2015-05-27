package com.practice.java.datastructure.algorithms;

class Fibonacci {

	public int generate(int pos) {
		int sum = 0, x = 0, y = 0;

		for (int i = 1; i < pos; i++) {
			sum = sum + x + i;
		}

		return sum;
	}

	public static void main(String args[]) {
		int prev, next, sum, n;
		prev = next = 1;
		for (n = 1; n <= 10; n++) {
			System.out.println(prev);
			sum = prev + next;
			prev = next;
//			next = sum;
		}
	}
}
