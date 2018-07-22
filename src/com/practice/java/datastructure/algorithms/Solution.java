package com.practice.java.datastructure.algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static String probableMatch(String typed, String phrase) {
	       char[] phraseArray = phrase.toCharArray();
	        char[] typedArray =  typed.toCharArray();
	        char[] resultArray = new char[phraseArray.length];
	        int i=0,j=0;
	        
	        while(j<typedArray.length){
	            
	            if(typedArray[j]==phraseArray[i]){ 
	                i++;j++; //if matched then increment both counter
	            } else {
	                resultArray[i]=phraseArray[i]; //store phrase value to the result array as mismatch.
	                System.out.println(" debugging --> result is :"+resultArray[i]);
	                i++; //if not matched then increment only phrase counter for next pair
	            }
	        }
	         
	        return new String(resultArray);
	       }

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = "D:\\Tools\\workspace\\practice-java\\OUTPUT_PATH";
//				System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res;
		String _typed;
		try {
			_typed = in.nextLine();
		} catch (Exception e) {
			_typed = null;
		}

		String _phrase;
		try {
			_phrase = in.nextLine();
		} catch (Exception e) {
			_phrase = null;
		}

		res = probableMatch(_typed, _phrase);
		bw.write(res);
		bw.newLine();

		bw.close();
	}

}