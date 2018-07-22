package com.practice.java.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringExperiments1 {
	
	//below declarations will create two string objects and two references
	static String s1 = new String("string 1"); //new object s1
	static String s2 = "string 2"; //new object s2
	static String s3 = s1;	//same object s1
	static String s4 = "string 2";	//same object s2
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("s1 & s3 are equals ?? " + (s1==s3));
		s1="string 1 changed";
		s3=new String();
		s3=s1;
		System.out.println("Still s1 & s3 are equals ?? " + (s1==s3));
		System.out.println("s1::" + s1);		
		System.out.println("s1 & s3 are equals :: "+(s2==s4));
	}

}
