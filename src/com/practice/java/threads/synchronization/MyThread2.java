package com.practice.java.threads.synchronization;

public class MyThread2 extends Thread {
	MyLockObject lock ;

	MyThread2(MyLockObject lock){
		this.lock=lock;		
	}
	
	public void run() {
		this.lock.lockMethod3();
		this.lock.lockMethod2();
		MyLockObject.lockMethod1();
	}
}
