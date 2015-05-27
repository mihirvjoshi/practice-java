package com.practice.java.datastructure.algorithms;

public class FindtheFinger {

	public int findFinger(int no) {

		int rem = no % 5;
		no = no/5;
		
		return 5 - no - rem;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new FindtheFinger().findFinger(6));
		System.out.println(new FindtheFinger().findFinger(12));
	}

}
