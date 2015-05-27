package com.practice.java.datastructure;

import java.util.Arrays;
import java.util.Random;

/**
 * This class implements binary search.
 * 
 * Binary search works only on the sorted array and so it's utmost important to first sort the array if it's not.
 * @author Mihir
 *
 */
public class MyBinarySearch {

    static final int ARRAY_SIZE = 1000;
    static final int THRESHOLD = 10;

    static final int MIN_VALUE = 0;
    static final int MAX_VALUE = 100;

    static Random rand = new Random();

    // a function for retrieving a random int in a specific range
    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    static volatile boolean result = false;
    static int[] array = new int[ARRAY_SIZE];
    static int target;

	public boolean search(int[] array, int value){
		
		int mid = array.length/2;
//		System.out.println(array[mid]);
		if(value < array[mid]){
			array = Arrays.copyOf(array, mid);
			return search(array, value);
		} else if(value > array[mid]){
			array = Arrays.copyOfRange(array, mid, array.length);			
			return search(array, value);		
		} else {
			System.out.println("found");
			return true;			
		}
	}	
	
	public static void main(String[] args) {

        for (int i=0 ; i<ARRAY_SIZE ; i++) {
            array[i] = randInt(MIN_VALUE, MAX_VALUE);
        }
        
        target = randInt(MIN_VALUE, MAX_VALUE);
        boolean found = new MyBinarySearch().search(array, target);      
		System.out.println(found);
	}
}
