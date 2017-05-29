package com.practice.java.threads.synchronization;

public class MyMainThread {

	public static void main(String[] args) {		
		MyLockObject lock1 = new MyLockObject();
		MyLockObject lock2 = new MyLockObject();
		MyThread1 t1 = new MyThread1(lock1, "thread 1");
		MyThread2 t2 = new MyThread2(lock2, "thread 2");
		t1.start();
		t2.start();	
//		t1.start();
	}
}
