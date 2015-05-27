package com.practice.java.datastructure.sorting;

public class InsertionSort {

    /**
     * This method will sort the integer array using insertion sort algorithm
     * 
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	
	int[] arr = {3, 7, 4, 9, 5, 2, 6, 1};
//	insertionSort(arr);
	for(int i = 0; i < arr.length; i++){	    
	    for (int j=0; j < i; j++){		
		if(arr[j] > arr[i]){
		    int temp = arr[i];
		    arr[i]=arr[j];
		    arr[j]=temp;
		}
	    }
	}
	
	for(int i = 0; i < arr.length; i++){	
	    System.out.println(arr[i]);
	}	
    }

}
