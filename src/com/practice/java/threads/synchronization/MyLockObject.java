package com.practice.java.threads.synchronization;

public class MyLockObject {

	public  synchronized void lockMethod1(){
		System.out.println("Locked method 1");
	}

	public  synchronized void lockMethod2(){
		System.out.println("Locked method 2");
	}


}
