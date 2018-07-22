package com.practice.java.datastructure.algorithms;

public class NonAdjacentSubArray {

	public static int findNonAdjacentSubArray(int[] a){

		int sumOfOdd=0, sumOfEven=0;
		
		for (int i = 0; i < a.length; i++) {
			if(i%2==0){
				sumOfEven=sumOfEven + a[i];
			} else {
				sumOfOdd=sumOfOdd + a[i];	
			}
		}
		return sumOfEven > sumOfOdd ? sumOfEven:sumOfOdd;
	}
	
	
	public static void main(String[] args) {
		int[] a = {5,  45, 10, 40, 50, 35};
			//{3, 11, 5, 10, 7};
		
		System.out.println(findNonAdjacentSubArray(a));
	}

}
