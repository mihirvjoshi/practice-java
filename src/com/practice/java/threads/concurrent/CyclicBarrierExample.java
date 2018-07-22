package com.practice.java.threads.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.practice.java.threads.core.MyCyclicBarrier;

/**
 * Java program to demonstrate how to use CyclicBarrier in Java. CyclicBarrier is a
 * new Concurrency Utility added in Java 5 Concurrent package. It gerentees the sequential order of the
 * threads.
 *
 * @author Mihir Joshi
 */
public class CyclicBarrierExample {
    private static class BarrierTask implements Runnable {    	
		@Override
		public void run(){
		    //This task will be executed once all thread reaches barrier
		    System.out.println(Thread.currentThread().getName() + " => All parties are arrived at barrier, lets play");
		}
	}

	//Runnable task for each thread
    private static class Task implements Runnable {
        private MyCyclicBarrier barrier;
    	int counter = 0;

        public Task(MyCyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
    			System.out.println(++counter);
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier & finishing.");
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        //creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
    	//BarrierTask is the one which needs to finish first here and so will be the barrier thread
    	//for rest of 3 threads
    	final MyCyclicBarrier cb = new MyCyclicBarrier(3, new BarrierTask());
        //starting each of thread
        Thread t1 = new Thread(new CyclicBarrierExample.Task(cb), "Thread 1");
        Thread t2 = new Thread(new CyclicBarrierExample.Task(cb), "Thread 2");
        Thread t3 = new Thread(new CyclicBarrierExample.Task(cb), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}


