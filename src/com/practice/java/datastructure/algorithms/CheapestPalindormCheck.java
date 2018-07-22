package com.practice.java.datastructure.algorithms;

/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Palindrome is a string that reads the same backward as forward, e.g., madam.

	You are given a string whose length is even, and each character of the string is either 'a', 'b' or '/' Your task is to replace each occurrence of '/' in string with either 'a' or 'b' such that the string becomes a palindrome.
	
	You are also given two integers, aCost and bCost. Replacing '/' with 'a' costs aCost, and replacing '/' with 'b' costs bCost.
	
	Return the minimum cost of replacing '/' by 'a' and 'b' such that the string turns into a palindrome. If it is impossible to obtain a palindrome, return -1.
	
	Constraints
	
	String will contain between 1 and 10000 characters, inclusive.
	The length of string will be even.
	Each character of the string will be either 'a' or 'b' or '/'.
	aCost will be between 1 and 100, inclusive.
	bCost will be between 1 and 100, inclusive.
	Input Format
	
	First line of input will contain the number of test cases. For each test case, there will be of three lines, the first line is the string whose palindrome is to be constructed, the second is the aCost and the third is the bCost
	
	Examples
	
	1
	
	aba/bab/
	
	4
	
	6

	Returns: 10
 * @author Mamta Mihir
 *
 */
class CheapestPalindormCheck {
    private static final char A = 'a';
    private static final char B = 'b';
    private static final char SLASH = '/';

	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] palindrom = line.toCharArray();
        boolean isPalindrom = true;

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br1.readLine();
        int aCost = Integer.parseInt(line1);
        
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String line2 = br2.readLine();
        int bCost = Integer.parseInt(line2);

        int sum = 0;
        
        for (int i = 0; i < palindrom.length/2; i++) {
        	
        	if(palindrom[i]==SLASH){
        		if(palindrom[palindrom.length-1-i]==A){
        			sum = sum + aCost;
        		} else {
        			sum = sum + bCost;
        		}
        		palindrom[i]=palindrom[palindrom.length-1-i];
        	} else if(palindrom[palindrom.length-1-i]==SLASH){
        		if(palindrom[i]==A){
        			sum = sum + aCost;
        		} else {
        			sum = sum + bCost;
        		}
        		palindrom[palindrom.length-1-i]=palindrom[i];
        	} else if(palindrom[i]==SLASH && palindrom[palindrom.length-1-i]==SLASH){
        		sum = sum + Math.min(aCost,bCost);
        	}

        	if(palindrom[i]!=palindrom[palindrom.length-1-i]){
            	isPalindrom = false;
            	break;
            } 
            
        }

        if(isPalindrom)
        	System.out.println(sum);
        else 
        	System.out.println("-1");
    }
}
