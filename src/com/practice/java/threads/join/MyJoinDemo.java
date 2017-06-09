package com.practice.java.threads.join;

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
				e.printStackTrace();
			}
			System.out.println("Finished  " + this.name);
		}		
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyJoinDemo().new MyServiceThread("Thread 1"));
		Thread t2 = new Thread(new MyJoinDemo().new MyServiceThread("Thread 2"));
		Thread t3 = new Thread(new MyJoinDemo().new MyServiceThread("Thread 3"));
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
		t2.start();
		t3.start();
	}
}
