package com.practice.java.threads.locks;

import com.practice.java.threads.core.MyReentrantLock;

public class MyAnotherSharedResource {
	MyReentrantLock resouceLock = new MyReentrantLock();
	public void innerMethod(){
		try {
			resouceLock.lock();
			System.out.println("Inner method but different resource");
			resouceLock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
