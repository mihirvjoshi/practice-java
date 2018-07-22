package com.practice.java.threads.core;

public class MyReentrantLock {
	boolean isLocked=false;
	Thread lockingThread;
	int locked;
	
	public synchronized void lock() throws InterruptedException {
		//don't block the thread until it's different thread then existing thread holding the lock.
		while(isLocked&&!(lockingThread==Thread.currentThread())){
			this.wait();
		}
		isLocked=true;
		//count is to keep track of all the occurences of the thread locks as 
		//otherwise single unlock by any (inner) method will release all the locks unnecessarily.
		locked++;
		//this is to keep the lock reentrant in nature and so any single thread can acquire it anytimes.
		lockingThread=Thread.currentThread();
	}
	
	public synchronized void unlock() throws InterruptedException {
		//this is to make sure in reentrant lock single unlock by any inner method doen't release all the locks.
		if(lockingThread==Thread.currentThread()){
			locked--;
		}
		if(locked==0){
			isLocked=false;
			this.notifyAll();
		}
	}
}
