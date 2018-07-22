package com.practice.java.design.patterns.command;

public class ReturnNetAmount implements TagValueProvider {

	@Override
	public void processTag(TagEnumeration tag) {
		System.out.println("Doing something with "+ tag.NETAMOUNT.getTagName() +" and having value " + tag.NETAMOUNT.getTagValue());
	}

}
