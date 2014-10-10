package com.practice.java.threads;



public class ThreadExceptionHandling implements Runnable{

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadExceptionHandling());

		
		// Add the handler to the thread object
		t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("ERROR! An exception occurred in " + t.getName() + ". Cause: " + e.getCause());
//			e.printStackTrace();
		}
		});		
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Creating thread");
		throw new RuntimeException();
	}


}
