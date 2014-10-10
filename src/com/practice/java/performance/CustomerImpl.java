package com.practice.java.performance;

public class CustomerImpl implements Customer {

	/**
	 * This is a dummy method to illustrate the performance measure on particular method.
	 * We are measuring the start & end time by putting sysout in finally block.
	 * It looks very straight forward but imagine if you have 30 to 40 methods in the class
	 * and have to update all of them to put the timer !!!
	 * 
	 * This dilemma will be addressed by using the Spring AOP or for the matter of convenience  by using 
	 * java proxy objects here. e.g.PerformanceLogger
	 */
	public void getDetails(String customerId) {
		long startTime = System.currentTimeMillis();
		try {
			// Actual method body to do some processing...
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println("method took: " + (endTime - startTime) + "ms");
		}
	}

}