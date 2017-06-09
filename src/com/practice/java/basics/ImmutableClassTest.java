package com.practice.java.basics;

public class ImmutableClassTest {
	public static void main(String[] args) {
		ImmutableClass immutableObject = new ImmutableClass("Creating Immutable Class");
		System.out.println(immutableObject.getButDontTryToChangeMe());
	}
}
