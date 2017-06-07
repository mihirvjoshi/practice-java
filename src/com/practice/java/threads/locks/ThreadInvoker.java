package com.practice.java.threads.locks;

public class ThreadInvoker {

	public static void main(String[] args) {
		MySharedResource sharedResource = new MySharedResource();
		Thread t1=new Thread(new MyThread1("Thread 1", sharedResource));
		Thread t2=new Thread(new MyThread2("Thread 2", sharedResource));		
		t1.start();
		t2.start();
	}
}
