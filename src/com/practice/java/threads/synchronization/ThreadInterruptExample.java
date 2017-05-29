package com.practice.java.threads.synchronization;

public class ThreadInterruptExample extends Thread {
	public static int counter=1;
	public void run(){
		try {
			while(!Thread.currentThread().isInterrupted()){
				counter++;
				System.out.println("Thread not interrupted =>"+Thread.currentThread().isInterrupted());
				Thread.sleep(1000);
				if(counter>3){
					Thread.currentThread().interrupt();
					System.out.println("Thread should be interrupted =>"+Thread.currentThread().isInterrupted());
					Thread.currentThread().interrupt();
					System.out.println("Thread is interrupted again =>"+Thread.currentThread().isInterrupted());
				}
				System.out.println("Still trying to work after interrupt");
			}
		} catch (InterruptedException e) {
			System.out.println("Thread.interrupted 2=>"+Thread.currentThread().isInterrupted());
			 Thread.currentThread().interrupt();
		}
	}
	
/*	 public void stop() {
        if(scan != null){
            scan.interrupt();
        }
	 }
*/
	public static void main(String args[]){
		Thread t1 = new ThreadInterruptExample();
		t1.start();
		Thread.currentThread().interrupt();
	}
}
