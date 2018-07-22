package com.practice.java.basics.statics;

import com.practice.java.basics.Parent;


public class Test {
	public static void main(String args[]) {
		Parent p = new Parent(3);
		Child c = new Child(p);
		System.out.println(c.temp);		
	}
}
