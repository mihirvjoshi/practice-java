package com.practice.java.threads.synchronization;

public class MyJoinDemo {
	
	private class MyServiceThread implements Runnable {
		String name;
		
		MyServiceThread(String name){
			this.name=name;
		}
		
		@Override
		public void run() {
			System.out.println("I'm  " + this.name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyJoinDemo().new MyServiceThread("Thread 1"));
		Thread t2 = new Thread(new MyJoinDemo().new MyServiceThread("Thread 2"));
		Thread t3 = new Thread(new MyJoinDemo().new MyServiceThread("Thread 3"));
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	}
}
