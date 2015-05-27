package com.practice.java.threads.synchronization;

public class MyThread extends Thread {

	static MyLockObject lock = new MyLockObject();
	volatile boolean  isInLoop = true;
	
	public void run() {		
		while(isInLoop) {
			lock.lockMethod1();
			lock.lockMethod2();
			isInLoop = false;
		}
	}
	
	
	public static void main(String[] args) {		
		MyThread t1 = new MyThread();
		t1.start();
		
		MyThread t2 = new MyThread();
		t2.start();		
	}
}
