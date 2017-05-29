package com.practice.java.threads.producerconsumer;

import java.util.Stack;

public class ProducerConsumerThread {

	static final int MAX = 10;
	static final int EMPTY = 0;
	static int COUNTER = 0;

	public static void main(String[] args) {
		Stack<Integer> itemStack = new Stack<Integer>();
		ProducerConsumerThread.Producer producer1  = new ProducerConsumerThread().new Producer(itemStack);
		producer1.start();
		ProducerConsumerThread.Consumer consumer1 = new ProducerConsumerThread().new Consumer(itemStack);
		consumer1.start();
	}

	class Producer extends Thread {
		private Stack<Integer> itemStack;
		public Producer(Stack<Integer> itemStack){
			this.itemStack=itemStack;
		}
		
		@Override
		public void run() {
			while (true) { //this is required for continues consumption. if you remove this then it will only execute once.
				synchronized (this.itemStack) {
//					System.out.println("itemStack in producer"+itemStack.getClass().hashCode());
					while (this.itemStack.size() == MAX) {
						try {
							System.out.println("Stack is full & Producer is waiting.");
							this.itemStack.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (this.itemStack.size() < MAX) {
						COUNTER++;
						this.itemStack.push(COUNTER);
						System.out.println("producing item ->" + COUNTER + " & size of stack is now :: " + this.itemStack.size());
						this.itemStack.notifyAll();
					}
				}
			}
		}
	}

	private class Consumer extends Thread {
		private Stack<Integer> itemStack;
		public Consumer(Stack<Integer> itemStack){
			this.itemStack=itemStack;
		}

		@Override
		public void run() {
			while (true) { // this is required for continues consumption. if you
							// remove this then it will only execute once.
			// System.out.println("itemStack in consumer"+itemStack.getClass().hashCode());
				synchronized (this.itemStack) {
					System.out.println(this.itemStack.size());
					while (this.itemStack.size() == EMPTY) {
						System.out.println("Stack is empty & Consumer is waiting.");
						COUNTER = 0;
						try {
							this.itemStack.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (this.itemStack.size() > EMPTY) {
						COUNTER--;
						System.out.println("Consuming item ->" + this.itemStack.pop()
								+ " & size of stack is now :: " + this.itemStack.size());
						this.itemStack.notifyAll();
					}
				}
			}
		}
	}
}


