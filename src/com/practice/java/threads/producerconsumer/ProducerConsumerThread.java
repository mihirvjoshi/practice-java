package com.practice.java.threads.producerconsumer;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerThread {

	private static ExecutorService executor = null;

	static int MAX = 10;
	static int EMPTY = 0;
	static int COUNTER = 0;
	Stack<String> itemStack = new Stack<String>();

	public static void main(String[] args) {

		executor = Executors.newFixedThreadPool(3);
		ProducerConsumerThread.Producer producer1 = new ProducerConsumerThread().new Producer();
		producer1.start();
		ProducerConsumerThread.Consumer consumer1 = new ProducerConsumerThread().new Consumer();
		consumer1.start();
		executor.shutdown();
	}

	class Producer extends Thread {

		@Override
		public void run() {
			while (true) {
				synchronized (itemStack) {
					if (itemStack.size() <= MAX) {
						COUNTER++;
						itemStack.push(String.valueOf(COUNTER));
						System.out.println("producing item ->" + COUNTER
								+ " & size of stack is now :: "
								+ itemStack.size());
						itemStack.notifyAll();
					}

					while (itemStack.size() == MAX) {
						try {
							System.out
									.println("Stack is full & Producer is waiting.");
							itemStack.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private class Consumer extends Thread {

		@Override
		public void run() {
			while (true) {
				synchronized (itemStack) {
					if (itemStack.size() != EMPTY) {
						System.out.println("Consuming item ->"
								+ itemStack.pop()
								+ " & size of stack is now :: "
								+ itemStack.size());
						itemStack.notifyAll();
					}

					while (itemStack.size() == EMPTY) {
						System.out
								.println("Stack is empty & Consumer is waiting.");
						try {
							itemStack.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
