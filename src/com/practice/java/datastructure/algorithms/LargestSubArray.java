package com.practice.java.datastructure.algorithms;

import java.util.HashMap;

public class LargestSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arrayMain = {2,55,9,7,33,4,8,10};
		int subArrayCounter = 0;
		int subArray[] = new int[8];
		HashMap temp = new HashMap();
		
		for(int i=0; i<arrayMain.length;i++){
			if(i != arrayMain.length-1){				
				if(arrayMain[i] < arrayMain[i+1] && subArray.length > 0){
					subArray[subArrayCounter]=arrayMain[i];
					subArray[++subArrayCounter]=arrayMain[i+1];
				}
				if(arrayMain[i]>arrayMain[i+1] && (subArray !=null && subArray.length >=2)){					
					subArray[++subArrayCounter]=arrayMain[i+1];
					temp.put(subArrayCounter, subArray);
//					subArray=null;
//					subArrayCounter=0;
					break;
				}				
			}
		}
		
		System.out.println(subArray.toString());
		String output = null;
		for(int i=0; i<subArray.length;i++){
			output = output + ","+ subArray[i];
		}
		System.out.println(output);	
	}
}
