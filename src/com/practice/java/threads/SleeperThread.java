package com.practice.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SleeperThread extends Thread {

	public void run() {
		System.out.println(this.getName() + " Started");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " Wait Over");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		try {
			ExecutorService es = Executors.newCachedThreadPool();
			
			es.execute(new SleeperThread());
			
			es.execute(new SleeperThread());
//			Thread.sleep(10000);
			
			es.execute(new SleeperThread());
//			Thread.sleep(10000);
			
			es.execute(new SleeperThread());
//			Thread.sleep(10000);
			
			es.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
