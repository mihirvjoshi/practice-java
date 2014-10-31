package com.practice.java.threads.producerconsumer;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerThreadWithLock {

	static int MAX = 10;
	static int EMPTY = 0;
	static int COUNTER = 0;

	// below 4 variables are class level variables
	// which will be used across the threads and so must be static
	private static Lock lock = new ReentrantLock();
	private static Condition hasSpace = lock.newCondition();
	private static Condition hasItems = lock.newCondition();
	private static Stack<String> itemStack = new Stack<String>();

	public static void main(String[] args) {

		ProducerConsumerThreadWithLock producerConsumer1 = new ProducerConsumerThreadWithLock();

		// WARNING - to create consumer & producer you must have same
		// producerConsumer instance as below
		// you should have non static lock & condition variables or your thread
		// will deadlock.
		// The reason is that if you create new ProducerConsumerThreadWithLock()
		// each time to create producer & consumer then
		// lock, hasSpace & hasItems will be created separately for consumer &
		// producer and you will not be able to exchange thread messages
		// like await, signal etc.
		// or another (& most preferred) approach is declare lock, hasSpace &
		// hasItems variables as static so you don't have to worry about using
		// same producerConsumer1 instance for all new threads.
		ProducerConsumerThreadWithLock.Producer producer1 = producerConsumer1.new Producer();
		producer1.start();
		ProducerConsumerThreadWithLock.Consumer consumer1 = producerConsumer1.new Consumer();
		consumer1.start();

		ProducerConsumerThreadWithLock producerConsumer2 = new ProducerConsumerThreadWithLock();

		ProducerConsumerThreadWithLock.Producer producer2 = producerConsumer1.new Producer();
		producer2.start();
		ProducerConsumerThreadWithLock.Consumer consumer2 = producerConsumer2.new Consumer();
		consumer2.start();
	}

	private class Producer extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					while (itemStack.size() >= MAX) {
						System.out.println("Stack is full & Producer is waiting.");
						try {
							// wait for the list to have space
							hasSpace.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					COUNTER++;
					itemStack.push(String.valueOf(COUNTER));
					System.out.println("producing item number -> "
							+ itemStack.size());
					hasItems.signalAll();

				} finally {
					lock.unlock();
				}
			}
		}
	}

	private class Consumer extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					while (itemStack.size() == EMPTY) {
						System.out
								.println("Stack is empty & Consumer is waiting.");
						try {
							COUNTER = 0;
							// wait for the list to have space
							hasItems.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					itemStack.pop();
					System.out.println("consuming item number -> "
							+ itemStack.size());
					hasSpace.signalAll();
				} finally {
					lock.unlock();
				}
			}
		}
	}

}
