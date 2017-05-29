package com.practice.java.threads.synchronization;

public class MyThread2 extends Thread {
	MyLockObject lock = new MyLockObject();
	
	MyThread2(MyLockObject lock, String name){
		this.lock=lock;
		this.setName(name);
	}
	
	public void run() {	
		lock.lockMethod2();
		lock.lockMethod1();
	}	
}
