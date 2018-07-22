package com.practice.java.design.patterns.chainofresponsibility;

public enum TradeType {

	BOOK('B'),	PARTY('P');
	
	private char value;
	
	private TradeType(char value){
		this.value = value;
	}
	
}
	
