package com.practice.java.datastructure.algorithms;

public class PowerSet {
	void powerset(int arr[]){
		System.out.println("{}");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		powerset(arr, 0, 1, arr.length );
	}

	void powerset(int arr[], int start, int power, int size){
		if(power==size){
			return;
		}
		String mainSet=String.valueOf(arr[start]);
		int cursor=start+power;
		for(int j=start+1;j<cursor;j++){
			mainSet=mainSet+","+arr[j];
		}
		for(int k=cursor;k<size;k++){
			System.out.println(mainSet+","+arr[k]);
		}
		start=start+1;
		if(start+power>=size){
			power=power+1;
			start=0;
		}
		powerset(arr, start, power, size);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		new PowerSet().powerset(arr);
	}
}
