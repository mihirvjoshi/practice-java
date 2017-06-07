package com.practice.java.threads.locks;

public class MyThread1 implements Runnable {
	String name;
	MySharedResource sharedResouce;
	MyThread1(String name, MySharedResource sharedResouce){
		this.name=name;
		this.sharedResouce=sharedResouce;
	}

	@Override
	public void run() {
		sharedResouce.sharedMethod();
	}
}
