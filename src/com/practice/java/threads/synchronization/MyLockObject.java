package com.practice.java.threads.synchronization;

public class MyLockObject {
	public static synchronized void lockMethod1(){
		System.out.println(Thread.currentThread().getName() +"=>Locked method 1" );
		for(int i=0;i<1000000000;i++) {
			
		}
		System.out.println(Thread.currentThread().getName() +"=>Released method 1");
	}

	public synchronized void lockMethod2(){
		System.out.println(Thread.currentThread().getName() +"=>Locked method 2");
		for(int i=10;i<1000000000;i++){
			
		}
		System.out.println(Thread.currentThread().getName() +"=>Released method 2");
	}
	
	public static synchronized void recursiveLock(int counter){
		if(counter==0) return;
		else{
			
		}
			
	}
}
