package com.practice.java.threads.core.test;

import com.practice.java.threads.core.MyReadWriteLock;

public class WriterThread implements Runnable {
	MyReadWriteLock lock;

	WriterThread(MyReadWriteLock lock){
		this.lock=lock;
	}
	
	@Override
	public void run() {
		try {
			lock.writelock();
			print();
			Thread.sleep(100);
			lock.writeunlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void print() throws InterruptedException{
//		lock.readlock();
		for (int i = 0; i < 10; i++) {
			System.out.println("Writing thread is => " + Thread.currentThread().getName() + "=>" + i);
		}
//		lock.readunlock();			
	}
}
