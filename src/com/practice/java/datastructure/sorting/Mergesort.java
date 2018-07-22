package com.practice.java.datastructure.sorting;

import java.util.Arrays;

public class Mergesort {
	  private int[] resultingArray;
	  private int[] tempArray;
	  private int number;

	  public void sort(int[] values) {
	    this.resultingArray = values;
	    number = values.length;
	    this.tempArray = new int[number];
	    mergesort(0, number - 1);
	  }

	  private void mergesort(int low, int high) {
	    // check if low is smaller then high, if not then the array is sorted
	    if (low < high) {
	      // Get the index of the element which is in the middle
	      int middle = low + (high - low) / 2;
	      // Sort the left side of the array
	      mergesort(low, middle);
	      // Sort the right side of the array
	      mergesort(middle + 1, high);
	      // Combine them both
	      System.out.println("Calling merge => low " + low + " middle " + middle + " high " + high);
	      merge(low, middle, high);
	    }
	  }

	  private void merge(int low, int middle, int high) {

	    // Copy both parts into the helper array
	    for (int i = low; i <= high; i++) {
	    	tempArray[i] = resultingArray[i];
	    }

    	System.out.println("preparing helper" + Arrays.toString(tempArray));
	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while (i <= middle && j <= high) {
	      if (tempArray[i] <= tempArray[j]) {
	        resultingArray[k] = tempArray[i];
	        i++;
	      } else {
	        resultingArray[k] = tempArray[j];
	        j++;
	      }
	      k++;
	    }
    	System.out.println("resultingArray before " + Arrays.toString(resultingArray));
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) {
		  resultingArray[k] = tempArray[i];
	      k++;
	      i++;
	    }	    
    	System.out.println("resultingArray after " + Arrays.toString(resultingArray));
	  }
	  
	  public static void main(String args[]) {
		  int[] a = {10, 2, 5, 3, 11, 9};
		  Mergesort sorted = new Mergesort();
		  sorted.sort(a);
		  System.out.println(Arrays.toString(sorted.resultingArray));
	  }
	} 
