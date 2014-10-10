package com.practice.java.basics;
public class PrintSubsets {
	static int m_cElements = 1;
	private static void printSubsets(String prefix, String str)
	{
	   if(str.equals(""))
	      System.out.println((m_cElements++)+": {"+prefix+"}");
	   else
	   {
//		  System.out.println("substring:"+str.substring(1));
	      printSubsets(prefix, str.substring(1)); 
	      printSubsets(prefix+str.substring(0,1), str.substring	(1));
	   }
	}

	public static void main(String[] args) {
		System.out.println("abcd".substring(0,1));
		new PrintSubsets().printSubsets("","abcd");
	}
}
