package com.practice.java.basics;

public class PassByValueOrReference {

	private static void bitTrickyMethod(int i, int j) {
		int i1 = 100;
		int j1 = 100;

		i1 = i;
		System.out.println("i1 in method::" + i1);
		i = i1;
		j = j1;
		System.out.println("i,j in method::" + i + "," + j);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 50, j = 50;
		bitTrickyMethod(i, j);
		System.out.println(i);
		System.out.println(j);
	}

}
