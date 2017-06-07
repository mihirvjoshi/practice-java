package com.practice.java.threads.locks;

public class MyThread2 implements Runnable {
	String name;
	MySharedResource sharedResouce;
	MyThread2(String name, MySharedResource sharedResouce){
		this.name=name;
		this.sharedResouce=sharedResouce;
	}

	@Override
	public void run() {
		sharedResouce.sharedMethod();
	}
}
