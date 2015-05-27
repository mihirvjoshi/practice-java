package com.practice.java.datastructure.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchDictionary {

	public static HashMap<String,String> getDictionary() {
	    HashMap<String,String> hm=new HashMap<String,String>();
	    hm.put("a","a");
	    hm.put("it","it");
	    hm.put("am","am");
	    hm.put("ram","ram");
	    hm.put("pro","pro");
	    hm.put("grammer","grammer");
	    hm.put("program","program");
	    hm.put("programmer","programmer");
	    hm.put("me","me");
	    hm.put("merit","merit");
	    return hm;
	}
	
	private void countWords(String input, int index){
		String currentValue = "";
		char[] inputArray = input.toCharArray();
	
		if(index != input.length()){
			for(int i=index; i < input.length(); i++) {
				currentValue = currentValue + inputArray[i];	
			}			
			countWords(input, ++index);
		}
	}
	
	public static void main(String[] args) {
		String currentValue = null;
		String input = "programmerit";		
		char[] inputArray = input.toCharArray();
		List<String> myValues = new ArrayList<String>();

		for (int i = 0; i < inputArray.length; i++) {
			currentValue = "";
			for(int j=i; j < inputArray.length; j++) {
				currentValue = currentValue + inputArray[j];				
				if(getDictionary().containsKey(currentValue)){
					System.out.println(currentValue);
					myValues.add(currentValue);
				}
			}
		}
		
	}
}
