package com.practice.java.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class TempProdConsTest {
	static Queue<Object> items = new LinkedList<Object>();
	static final int MAX=10;

	class Producer implements Runnable {	
		@Override
		public void run() {
			synchronized (items) {
				int i=0;
				while(true) {
					while(items.size() < MAX) {
						  items.add(++i);
						  System.out.println("Entered producer" + items.size());
						  items.notifyAll();
						}
						try {
							items.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
		} 
	}
	
	class Consumer implements Runnable {

		@Override
		public void run() {		
			synchronized (items) {
				System.out.println("Consuming now==================" + items.size());
				
				while(true) { //this is required for continues consumption. if you remove this then it will only execute once.
					while(items.size() > 0) {
						items.remove();
						System.out.println(items.size());
						items.notifyAll();
					} 				
					try {
						items.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Thread producer1 = new Thread(new TempProdConsTest(). new Producer());
		Thread producer2 = new Thread(new TempProdConsTest(). new Producer());
		Thread producer3 = new Thread(new TempProdConsTest(). new Producer());
		
		producer1.start();
		producer2.start();
		producer3.start();
		
		Thread consumer1 = new Thread(new TempProdConsTest(). new Consumer());
		Thread consumer2 = new Thread(new TempProdConsTest(). new Consumer());
		Thread consumer3 = new Thread(new TempProdConsTest(). new Consumer());
		
		consumer1.start();
		consumer2.start();
		consumer3.start();
	}
}
