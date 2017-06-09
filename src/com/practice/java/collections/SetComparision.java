package com.practice.java.collections;

public class SetComparision {

	public static void main(String[] args) {

		int[] setA = { 1, 2, 3, 6, 7, 8, 9 };
		int[] setB = { 2, 4, 5, 6, 8, 10 };
		int[] setC = new int[10];

		if (setA.length > setB.length) {
			for (int i = 0; i < setA.length; i++) {
				for (int j = 0; j < setB.length; j++) {
//					System.out.println("A is " + setA[i]);
//					System.out.println("B is " + setB[j]);
					if (setA[i] < setB[j]) {
						setC[i] = setA[i];
						System.out.println(setC[i]);
						break;
					}
				}
			}
		}
	}
}
