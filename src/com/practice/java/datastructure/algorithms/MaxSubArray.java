package com.practice.java.datastructure.algorithms;

public class MaxSubArray {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, -9, 6, 7, -8, 1, 9 };
		System.out.println(findMaxSubArray(array));
	}

	public static int findMaxSubArray(int[] array) {
		int max = 0, cumulativeSum = 0, i = 0, start = 0, end = 0, savepoint = 0;
		while (i < array.length) {
			if (cumulativeSum + array[i] > max) {
				max = cumulativeSum;
				savepoint = start;
				end = i;
			}
			i++;
			System.out.println("i :" + i + "savepoint :" + savepoint);
		}
		return max;
	}

}