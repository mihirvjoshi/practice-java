package com.practice.java.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompareLists {
	
	static List<String> list1 = new LinkedList<String>();
	static List<String> list2 = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(int i=0; i < 20; i++){
			String temp = "String" + i;
			list1.add(temp);
			list2.add(temp);
		}
		
		System.out.println("====================================");
		for(int i=0; i < 20; i++){
			System.out.println(list1.get(i));
		}
		System.out.println("====================================");
		System.out.println("====================================");
		
		for(int i=0; i < 20; i++){
			System.out.println(list2.get(i));
		}		
		System.out.println("====================================");

	}
}
