package com.practice.java.basics;

public class ImmutableClassTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ImmutableClass immutableObject = new ImmutableClass("Creating Immutable Class");
	System.out.println(immutableObject.getButDontTryToChangeMe());
    }

}
