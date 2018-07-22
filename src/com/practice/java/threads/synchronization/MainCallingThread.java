package com.practice.java.threads.synchronization;

public class MainCallingThread {

	public static void main(String[] args) {	
		MyLockObject lock=new MyLockObject();
		MyLockObject anotherLock=new MyLockObject();
		MyThread1 t1 = new MyThread1(lock);
		MyThread2 t2 = new MyThread2(anotherLock);
		t1.start();
		t2.start();	
	}
}
