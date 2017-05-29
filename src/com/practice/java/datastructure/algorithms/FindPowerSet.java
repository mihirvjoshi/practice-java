package com.practice.java.datastructure.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPowerSet {

	public List<List<Integer>> findSubsets(List<Integer> list, int setSize){
		List<List<Integer>> results=new ArrayList<>();
		List<Integer> subset=list;
		results.add(list);
		findSubsets(subset, setSize-1);
		return results;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[4];
		int[][] a1=new int[4][];

	}

}
