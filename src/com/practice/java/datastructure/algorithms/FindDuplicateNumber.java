package com.practice.java.datastructure.algorithms;

public class FindDuplicateNumber {

    public static void main(String[] args) {

	int[] numbers = new int[100];     //this array is having duplicate numbers.
	int[] copyNumbers = new int[100]; // this array is having no from 1 to 100
	
	for (int i = 0; i < 100; i++) {
	    if (i == 48 || i == 49) // add duplicate value for element no 48 and 49
		numbers[i] = 49;
	    else {
		numbers[i] = i + 1;
	    }
	    copyNumbers[i] = i + 1;
	}

	int sum = 0;

	 /**
	   Now add all the numbers from both arrays in revers order
	   in such a way that sum is always 101 
	   for ex, 100 + 1 = 101
	   99 + 2 = 101
	 **/
	
	for (int i = 99, j = 0; i >= 0; i--, j++) {

	    sum = copyNumbers[i] + numbers[j];

	    if (sum != 101) {
	    	System.out.println(numbers[j]);
	    }

	}

    }

}
