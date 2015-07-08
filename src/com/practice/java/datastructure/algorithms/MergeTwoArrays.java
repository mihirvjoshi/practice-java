package com.practice.java.datastructure.algorithms;


public class MergeTwoArrays {

	public int[] merge(int a1[], int a2[]) {
	    int n = a1.length, m = a2.length; 
	    int ind = m + n - 1; // fill resulting array from the end 
	    m = m-1; n = n-1;
	    while (m >= 0 && n >= 0) 
	    { 
	        if (a1[n] >= a2[m]) {
	            a1[ind] = a1[n]; 
	            --n; 
	        } else { 
	            a1[ind] = a2[m]; 
	            --m; 
	        } 
	        --ind; 
	    } 
		
		return a1;
	}
	
	
	public static void main(String[] args) {
		int[] a1=new int[8];
		int[] a2= new int[4];

		a1[0] = 2;a1[1]=4;a1[2]=4;a1[3]=8;
		a2[0] = 1;a2[1]=5;a2[2]=7;a2[3]=9;

		a1=new MergeTwoArrays().merge(a1, a2);
//		System.out.println(new MergeTwoArrays().merge(a1, a2).toString());
		
		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]);
		}
	}

}
