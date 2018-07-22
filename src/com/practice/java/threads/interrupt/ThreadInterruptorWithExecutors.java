package com.practice.java.threads.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Make a task that prints 0 through 9 on console.
 * After printing a number the task should wait 1 sec before printing the next number.
 * The task runs on a separate thread, other than main application thread.
 * After starting the task the main application should wait for 3 sec and then shutdown.
 * On shutdown the application should request the running task to finish.
 * Before shutting down completely the application should, at the max, wait for 1 sec for the task to finish.
 * The task should respond to the finish request by stopping immediately.
 * @author Mihir
 *
 */
public class ThreadInterruptorWithExecutors {

	public static void main(String[] args) throws InterruptedException {
	    ExecutorService executor = Executors.newSingleThreadExecutor();
	    executor.submit(taskThatFinishesEarlyOnInterruption());  // requirement 3
	    Thread.sleep(3_000);                                     // requirement 4
	    executor.shutdownNow();                                  // requirement 5
	    executor.awaitTermination(1, TimeUnit.SECONDS);          // requirement 6
	}

	private static Runnable taskThatFinishesEarlyOnInterruption() {
	    return () -> {
	        for (int i = 0; i < 10; i++) {
	            System.out.print(i);      // requirement 1
	            try {
	                Thread.sleep(1_000);  // requirement 2
	            } catch (InterruptedException e) {
	                break;                // requirement 7
	            }
	        }
	    };
	}	
}
