package com.practice.java.threads.locks;

public class MyAnotherSharedResource {
	ReentrantLock resouceLock = new ReentrantLock();
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
