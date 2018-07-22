package com.practice.java.threads.core.test;

import com.practice.java.threads.core.MyReadWriteLock;

public class ReaderThread implements Runnable {
	MyReadWriteLock lock;

	ReaderThread(MyReadWriteLock lock){
		this.lock=lock;
	}
	
	@Override
	public void run() {
		try {
			lock.readlock();
			print();
			Thread.sleep(100);
			lock.readunlock();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void print() throws InterruptedException{
		lock.readlock();
		for (int i = 0; i < 10; i++) {
			System.out.println("Reading thread is => " + Thread.currentThread().getName() + "=>" + i);
		}
		lock.readunlock();			
	}
}
