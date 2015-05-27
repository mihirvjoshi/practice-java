package com.practice.java.design.patterns.command;

public class ReturnGrossAmount implements TagValueProvider {

	@Override
	public void processTag(TagEnumeration tag) {
		System.out.println("Doing something with "+ tag.GROSSAMOUNT.getTagName() +" and having value " + tag.GROSSAMOUNT.getTagValue());
	}

}
