package com.practice.java.datastructure.algorithms;

public class MergeSortedArrays {

	public int[] merge(int[] a, int[] b){
		
		int[] c = new int[a.length + b.length];
		int i=0,j=0,k=0;
		
		while(k < c.length - 1) {
		
			if(a[i] < b[j]) {				
				c[k]=a[i];
				i++;
			} else {
				c[k]=b[j];
				j++;
			}
			k++;
		}
		
		return c; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,7,8,9,15};
		int[] b = {4,5,6,10,16};
		int[] mergedArray = new MergeSortedArrays().merge(a, b);
		
		for(int i=0; i < mergedArray.length - 1; i++){
			System.out.println(mergedArray[i]);
		}
	}

}
