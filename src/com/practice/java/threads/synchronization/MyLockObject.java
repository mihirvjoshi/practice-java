package com.practice.java.threads.synchronization;

public class MyLockObject {

	public static synchronized void lockMethod1(){
		System.out.println(Thread.currentThread().getName() + " Locked static method 1");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Released static method 1.");
	}

	public synchronized void lockMethod2(){
		System.out.println(Thread.currentThread().getName() + " Locked method 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Released method 2.");
	}

	public synchronized void lockMethod3(){
		System.out.println(Thread.currentThread().getName() + " Locked method 3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Released method 3.");
	}	
}
