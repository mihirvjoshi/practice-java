package com.practice.java.threads;

public class MuliFileThread implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread(new MuliFileThread(), "one");
		Thread t2 = new Thread(new MuliFileThread(),  "two");
		Thread t3 = new Thread(new MuliFileThread(), "three");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {	
		System.out.println("Running thread" + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
