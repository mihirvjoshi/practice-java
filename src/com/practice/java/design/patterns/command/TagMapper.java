package com.practice.java.design.patterns.command;

import java.util.HashMap;
import java.util.Map;

public class TagMapper {

	public static Map<TagEnumeration, TagValueProvider> tagSchemaMapper = new HashMap<TagEnumeration, TagValueProvider>();
	
	static {
		tagSchemaMapper.put(TagEnumeration.NETAMOUNT, new ReturnNetAmount());
		tagSchemaMapper.put(TagEnumeration.GROSSAMOUNT, new ReturnGrossAmount());
		tagSchemaMapper.put(TagEnumeration.SECURITYID, new ReturnSecurityId());
	}
}
	
