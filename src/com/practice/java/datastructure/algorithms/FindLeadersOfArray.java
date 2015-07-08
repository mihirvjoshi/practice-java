package com.practice.java.datastructure.algorithms;

/**
 * This class perticularly finds the leaders of the array.
 * Leaders of the array are the ones which has all the elements lower than it.
 * For ex, in below given array leaders are 18, 5 & 2 since they have all elements lower than it.
 * @author Mamta Mihir
 *
 */
public class FindLeadersOfArray {

	
	public static void main(String[] args) {
       int[] a = {16, 17, 3, 18, 4, 5, 2};
       int previousHighest = 0;
       
       previousHighest = a[a.length - 1];       
       System.out.println(previousHighest);
       
       for(int i=a.length - 2; i > 0; i--) {
    	   
    	   if(a[i] > a[i+1] && a[i] > previousHighest) {
    		   previousHighest = a[i];
    		   System.out.println(a[i]);
    	   }
       }
	}

}
