package com.practice.java.design.patterns.chainofresponsibility;

public interface DispenseChain {

	   void setNextChain(DispenseChain nextChain);
	     
	   void dispense(Currency cur);
}
