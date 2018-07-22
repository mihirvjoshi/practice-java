package com.practice.java.threads.locks;

import com.practice.java.threads.core.MyReentrantLock;

public class MySharedResource {
	MyReentrantLock resouceLock = new MyReentrantLock();
	
	public void sharedMethod(){
		try {
			resouceLock.lock();
			new MyAnotherSharedResource().innerMethod();
			innerMethod();
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+" is running in locked mode.");
			}
			resouceLock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void innerMethod(){
		try {
			resouceLock.lock();
			System.out.println("Inner method with same resource.");
			resouceLock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
