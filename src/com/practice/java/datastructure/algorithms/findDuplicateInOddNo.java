package com.practice.java.datastructure.algorithms;

import java.util.HashSet;
import java.util.Set;

public class findDuplicateInOddNo {
	private int findRepeatedNoInOddCount(int[] a1){
		int leftPointer=0;
		int rightPointer=a1.length-1;
		Set<Integer> hashSet=new HashSet<Integer>();				
		while(leftPointer!=rightPointer){
			System.out.println("===========================");
			System.out.println("left=>"+a1[leftPointer]);
			System.out.println("right=>"+a1[rightPointer]);
			//if both are same no and no exists in temp array
			if(a1[leftPointer]==a1[rightPointer]){
				if(hashSet.contains(a1[leftPointer]))
					return a1[leftPointer];
			} else if(hashSet.contains(a1[leftPointer]) && !hashSet.contains(a1[rightPointer])){
				hashSet.remove(a1[leftPointer]);
				hashSet.add(a1[rightPointer]);
			} else if(hashSet.contains(a1[rightPointer]) && !hashSet.contains(a1[leftPointer])){
				hashSet.remove(a1[rightPointer]);
				hashSet.add(a1[leftPointer]);
			} else {
				hashSet.add(a1[rightPointer]);
				hashSet.add(a1[leftPointer]);				
			}
			leftPointer++;
			rightPointer--;			
		}
		//process middle element when left=right
		if(hashSet.contains(a1[rightPointer])){
			hashSet.remove(a1[rightPointer]);
		} else {
			hashSet.add(a1[rightPointer]);
		}
		return hashSet.iterator().next();		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a1=new int[13];
		a1[0]=1;//repeated
		a1[1]=2;
		a1[2]=1;//repeated
		a1[3]=3;
		a1[4]=4;
		a1[5]=2;
		a1[6]=3;
		a1[7]=4;
		a1[8]=5;
		a1[9]=5;
		a1[10]=6;
		a1[11]=6;
		a1[12]=1;//oops!! again 3rd time and so odd count.
		System.out.println(new findDuplicateInOddNo().findRepeatedNoInOddCount(a1));
	}
}
