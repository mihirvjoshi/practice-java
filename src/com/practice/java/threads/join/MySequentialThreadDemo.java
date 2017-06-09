package com.practice.java.threads.join;

public class MySequentialThreadDemo {
	
	public static void main(String args[]){
		MySequentialThreadDemo mainThread = new MySequentialThreadDemo();
		
		MyFirstThread r1 = mainThread.new MyFirstThread();
		MyFirstThread r2 = mainThread.new MyFirstThread();
		MyFirstThread r3 = mainThread.new MyFirstThread();
		
		Thread t1 = new Thread(r1, "Thread 1"); 	
		Thread t2 = new Thread(r2, "Thread 2");
		Thread t3 = new Thread(r3, "Thread 3");

		r2.setThreadToJoin(t1);
		r3.setThreadToJoin(t2);
		
		t1.start();
		t3.start();
		t2.start();
	}
	
	class MyFirstThread implements Runnable {
		Thread threadToJoin;
		
		MyFirstThread(Thread threadToJoin){
			this.threadToJoin=threadToJoin;
		}
		
		MyFirstThread(){
			this.threadToJoin=null;
		}
		
		public Thread getThreadToJoin() {
			return threadToJoin;
		}

		public void setThreadToJoin(Thread threadToJoin) {
			this.threadToJoin = threadToJoin;
		}

		@Override
		public void run() {
		    System.out.println(Thread.currentThread().getName() + " Started");
			try {
				if(threadToJoin!=null){
					this.threadToJoin.join();
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println(Thread.currentThread().getName() + " Finished");
		}
	}
}
