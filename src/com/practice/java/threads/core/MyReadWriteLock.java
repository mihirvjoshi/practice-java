package com.practice.java.threads.core;

import java.util.HashMap;
import java.util.Map;

public class MyReadWriteLock {
	int readCount;
	int writeCount;
	int writeRequests; //threads in waiting list.
	Map<Thread, Integer> readers = new HashMap<Thread, Integer>();
	
	public synchronized void readlock() throws InterruptedException{
		Thread currentThread = Thread.currentThread();
		while(!isSameReader(currentThread) && (writeCount>0 || writeRequests>0)){
			wait();
		} 
		readers.put(currentThread, getReadCountFor(currentThread)+1);
		readCount++;
	}
	
	private boolean isSameReader(Thread currentThread){
		if(currentThread!=null && readers.get(currentThread)!=null){
			return true;
		}
		return false;
	}
	
	private Integer getReadCountFor(Thread currentThread){
		Integer accessCount=null;
		if(currentThread!=null && readers.get(currentThread)!=null){
			accessCount=readers.get(currentThread);
		} else{
			accessCount=0;
		}
		return accessCount;
	}
	
	public synchronized void readunlock(){
		readCount--;
		Thread currentThread = Thread.currentThread();
		if(getReadCountFor(currentThread)==1) readers.remove(currentThread);
		else {
			Integer accessCount = getReadCountFor(currentThread);
			readers.put(currentThread, accessCount-1);
		}
		notifyAll();
	}

	public synchronized void writelock() throws InterruptedException{
		writeRequests++; //access requested and put in the queue.
		while(writeCount>0 || readCount>0){
			wait();
		}
		writeRequests--;
		writeCount++;
	}
	
	public synchronized void writeunlock(){
		writeCount--;
		notifyAll();
	}
}
