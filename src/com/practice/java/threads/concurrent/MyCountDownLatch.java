package com.practice.java.threads.concurrent;

public class MyCountDownLatch {
	private int count;
	
	MyCountDownLatch(int count){
		this.count=count;
	}
	
	public synchronized void countDown(){
		if(this.count!=0){
			this.count--;
		}
		this.notify();
	}
	
	public synchronized void await() throws InterruptedException{
		while(this.count>0){
			this.wait();
		}
	}
}