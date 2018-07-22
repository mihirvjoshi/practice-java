package com.practice.java.basics.statics;

import com.practice.java.basics.Parent;

public class Child extends Parent {
	protected int temp=2;
	
	public Child(Parent p){
	}
	
	public Child(){
		
	}
	
	public void test(){
		System.out.println(this.temp);
	}
}
