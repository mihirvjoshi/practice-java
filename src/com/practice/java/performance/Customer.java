package com.practice.java.performance;

public interface Customer {
	
	  /**
	   * Method under watch for performance measures.
	   * @param customerId
	   */
	 public abstract void getDetails(String customerId) ;
	 
	}