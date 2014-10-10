package com.practice.java.threads;

public class ThreadWithConcurrencyIssues extends Thread {

	
	ThreadWithConcurrencyIssues() {
//		System.out.println("I'm called");
	}

	@Override
	public void run() {
		new LockObject().lockMethod(this.getName());
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++)
			new ThreadWithConcurrencyIssues().start();
	}

}
