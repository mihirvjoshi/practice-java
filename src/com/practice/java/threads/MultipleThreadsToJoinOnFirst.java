package com.practice.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleThreadsToJoinOnFirst extends Thread {

	MultipleThreadsToJoinOnFirst(String name) {
		super(name);
	}

	public void run() {

		try {
			System.out.println("Current Thread :: " + this.getName()
					+ " is locked");

			if (this.getName().equals("one")) {
				System.out
						.println("Thread One is doing something here for 5 seconds:: "
								+ this.getName());
				Thread.sleep(5000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MultipleThreadsToJoinOnFirst t1 = new MultipleThreadsToJoinOnFirst(
				"one");
		MultipleThreadsToJoinOnFirst t2 = new MultipleThreadsToJoinOnFirst(
				"two");
		MultipleThreadsToJoinOnFirst t3 = new MultipleThreadsToJoinOnFirst(
				"three");
		MultipleThreadsToJoinOnFirst t4 = new MultipleThreadsToJoinOnFirst(
				"four");
		MultipleThreadsToJoinOnFirst t5 = new MultipleThreadsToJoinOnFirst(
				"five");

		ExecutorService service = Executors.newFixedThreadPool(5);
		service.submit(t1);
		service.submit(t2);
		service.submit(t3);
		service.submit(t4);
		service.submit(t5);

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdown();
	}

}
