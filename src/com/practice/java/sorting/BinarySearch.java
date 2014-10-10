package com.practice.java.sorting;

import java.util.LinkedList;

public class BinarySearch {
	
	private static LinkedList<String> sortedArray;
	
	BinarySearch(LinkedList<String> searchElements){
		sortedArray = searchElements;
	}
	
	public static boolean search(String searchString){		
		sort(sortedArray);
		return true;
	}
	
	private static void sort(LinkedList<String> searchElements){
		for (String element : searchElements) {			
			if(sortedArray != null && element != null){
				int index=0;
				for (String arrayElement : sortedArray) {
					if(element.compareTo(arrayElement)<0){
						String currentElement = arrayElement;
						sortedArray.add(index, element); 
					}
					index++;
				}				
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		

	}
}
