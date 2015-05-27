package com.practice.java.design.patterns.command;

public class UglyClassWithNastyIfElseBlocks {

	public void uglyMethodWithNastyIfElseBlocks(String tagName){
		
		if(tagName.equals("NetAmount")){
			System.out.println("Doing something with NetAmount and having value :32B: ");
		} else if(tagName.equals("GrossAmount")){
			System.out.println("Doing something with GrossAmount and having value :32M: ");
		} else if(tagName.equals("SecurityId")){
			System.out.println("Doing something with SecurityId and having value :35B: ");
		}
	}
	
	public void correctMethodWithCommandPattern(TagEnumeration tags){
		TagMapper.tagSchemaMapper.get(tags).processTag(tags);
	}
	
	public static void main(String args[]){
		UglyClassWithNastyIfElseBlocks myclass = new UglyClassWithNastyIfElseBlocks();
		myclass.uglyMethodWithNastyIfElseBlocks("NetAmount");
		myclass.correctMethodWithCommandPattern(TagEnumeration.NETAMOUNT);
	}
}
