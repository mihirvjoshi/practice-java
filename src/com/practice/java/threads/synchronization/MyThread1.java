package com.practice.java.threads.synchronization;

public class MyThread1 extends Thread {
	MyLockObject lock = new MyLockObject();
	
	MyThread1(MyLockObject lock, String name){
		this.lock=lock;
		this.setName(name);
	}
	
	public void run() {	
		lock.lockMethod1();
		lock.lockMethod2();
	}
	
}
