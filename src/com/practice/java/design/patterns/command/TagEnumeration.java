package com.practice.java.design.patterns.command;

public enum TagEnumeration {

	NETAMOUNT("NetAmount", ":32B:"),
	
	GROSSAMOUNT("GrossAmount", ":32M:"),
	
	SECURITYID("SecurityId", ":35B:");

	private String tagName;
	
	private String tagValue;
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	private TagEnumeration(String tagName, String tagValue){
		this.tagName = tagName;
		this.tagValue = tagValue;
	}
}
