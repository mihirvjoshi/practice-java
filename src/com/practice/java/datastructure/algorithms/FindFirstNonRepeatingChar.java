package com.practice.java.datastructure.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingChar {

	private char findFirstNonRepeatingCharacter(String str){
		char[] counter=str.toLowerCase().toCharArray();
		char nonrepeatingChar='\0'; boolean isFirst=true;
		Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < counter.length; i++) {
			if(charMap.get(counter[i])!=null){
				charMap.put(counter[i], charMap.get(counter[i])+1);
				if(counter[i]==nonrepeatingChar){
					isFirst=true;
				}
			} else {
				if(isFirst){
					nonrepeatingChar=counter[i];
					isFirst=false;
				}
				charMap.put(counter[i], 1);
			}
		}
		return nonrepeatingChar;
	}
	
	public static void main(String[] args) {
		System.out.println(new FindFirstNonRepeatingChar().findFirstNonRepeatingCharacter("aabccd"));
	}
}
