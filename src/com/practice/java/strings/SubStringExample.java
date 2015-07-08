package com.practice.java.strings;

class SubStringExample {
	public static void main(String args[]) throws Exception {
		String a = "hackerearth";
		a = a.substring(5, 7);
		char b = a.charAt(1);
		a = a + b;
		System.out.println(a);
	}
}
