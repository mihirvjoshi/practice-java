package com.practice.java.design.patterns.chainofresponsibility;

import java.util.Hashtable;

public class Dollar10Dispenser implements DispenseChain {
	 
    private DispenseChain chain;
     
    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }
 
    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 10){
            int num = cur.getAmount()/10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing "+num+" 10$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
            this.chain.dispense(cur);
        }
    }
 
    private boolean temp(Hashtable<?, ?> hash){
    	if(true){
    		System.out.println("Hello");
    	} else {
    		return false;
    	}
    	 
		return false;
    	
    }
    
}
