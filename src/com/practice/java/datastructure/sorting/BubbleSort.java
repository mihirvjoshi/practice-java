package com.practice.java.datastructure.sorting;

public class BubbleSort {

    /**
     * This method will sort the integer array using bubble sort algorithm
     * 
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
	
        for (int i = 1; i < arr.length; i++) {
            for (int j=0; j< arr.length - i ; j++){
        	if(arr[j+1] < arr[j]){
        	    int temp = arr[j];
        	    arr[j]=arr[j+1];
        	    arr[j+1]=temp;
        	}
            }
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	
	int[] arr = {3, 7, 4, 9, 5, 2, 6, 1};
	bubbleSort(arr);
	for(int i = 0; i < arr.length; i++){	
	    System.out.println(arr[i]);
	}	
    }

}
