package com.practice.java.datastructure.algorithms;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {
	void powerset(int arr[]){
		Set<Set> powerSet = new HashSet<Set>();
		System.out.println("{}");
		for (int i = 0; i < arr.length; i++) {
			Set<Integer> subSet = new HashSet<Integer>();
			subSet.add(arr[i]);
			powerSet.add(subSet);
		}
		powerset(arr, 0, 1, arr.length , powerSet);
		System.out.println(powerSet.toString());
	}

	void powerset(int arr[], int start, int power, int size, Set<Set> powerSet){
		if(power==size){
			return;
		}
		Set<Integer> currentSet=new HashSet<Integer>();
		int cursor=start+power;
		for(int j=start;j<cursor;j++){
			currentSet.add(arr[j]);
		}
		for(int k=cursor;k<size;k++){
			Set<Integer> subSet=new HashSet<Integer>();
			subSet.addAll(currentSet);
			subSet.add(arr[k]);
			powerSet.add(subSet);
		}
		start=start+1;
		if(cursor>=size){
			power=power+1;
			start=0;
		}
		powerset(arr, start, power, size, powerSet);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		new PowerSet().powerset(arr);
	}
}
