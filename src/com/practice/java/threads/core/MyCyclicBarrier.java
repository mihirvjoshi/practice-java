package com.practice.java.threads.core;

import java.util.concurrent.BrokenBarrierException;

public class MyCyclicBarrier {
	private volatile int noOfTasks;
	private Runnable barrierTask;
	
	public MyCyclicBarrier(int noOfTasks){
		this.noOfTasks=noOfTasks;
	}
	
	public MyCyclicBarrier(int noOfTasks, Runnable barrierTask){
		this.noOfTasks=noOfTasks;
		this.barrierTask=barrierTask;
	}

	public synchronized void await() throws InterruptedException, BrokenBarrierException{
		this.noOfTasks--;
		if(this.noOfTasks>0){
			System.out.println(Thread.currentThread().getName()+" is waiting");
			this.wait();
		} else {
			this.barrierTask.run();
			this.notifyAll();
		}
	}
}
