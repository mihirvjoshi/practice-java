package com.practice.java.threads.synchronization;

public class MyThread1 extends Thread {
	MyLockObject lock ;

	MyThread1(MyLockObject lock){
		this.lock=lock;		
	}
	
	public void run() {
		MyLockObject.lockMethod1();
		this.lock.lockMethod2();
		this.lock.lockMethod3();
	}
}
