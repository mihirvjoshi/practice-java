package com.practice.java.strings;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = " Hello ";
		s += " World ";
		s.trim( ); //string is trimmed ??
		System.out.println("\""+ s + "\"");
		s = s.trim( ); //Now string is trimmed ??
		System.out.println("\""+ s + "\"");
	}

}
