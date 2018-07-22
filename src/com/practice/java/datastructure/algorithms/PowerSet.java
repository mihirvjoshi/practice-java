package com.practice.java.datastructure.algorithms;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {
	
	void powersetLessEfficient(int arr[]){
		Set<Set> powerSet = new HashSet<Set>();
		powerSet.add(new HashSet());
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
	
	void powersetMostEfficient(int arr[], int start, String subset){
		String newSubset="";
		if(start==arr.length)return;
		for (int i = start; i < arr.length; i++) {
			newSubset=subset+",";			
			newSubset=newSubset+arr[i];
			powersetMostEfficient(arr, i+1, newSubset);
			System.out.println(newSubset.substring(1, newSubset.length()));
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4};
//		new PowerSet().powerset(arr);
		System.out.println("============================================");
		int[] arr1 = {1,2,3,4,5};
//		new PowerSet().powerset(arr1);
		new PowerSet().powersetMostEfficient(arr1, 0, "");
	}
}
