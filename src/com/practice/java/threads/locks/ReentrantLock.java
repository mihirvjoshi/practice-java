package com.practice.java.threads.locks;

public class ReentrantLock {
	boolean isLocked=false;
	Thread lockingThread;
	int locked;
	
	public synchronized void lock() throws InterruptedException {
		while(isLocked&&!(lockingThread==Thread.currentThread())){
			this.wait();
		}
		isLocked=true;
		locked++;
		lockingThread=Thread.currentThread();
	}
	
	public synchronized void unlock() throws InterruptedException {
		if(lockingThread==Thread.currentThread()){
			locked--;
		}
		if(locked==0){
			isLocked=false;
			this.notifyAll();
		}
	}
}
