package com.practice.java.design.patterns.command;

public class ReturnSecurityId implements TagValueProvider {

	@Override
	public void processTag(TagEnumeration tag) {
		System.out.println("Doing something with "+ tag.SECURITYID.getTagName() +" and having value " + tag.SECURITYID.getTagValue());
	}

}
