package com.practice.java.threads;

public class LockObject {
	volatile int sharedVariable = 0; // read values directly from the main memory
	int localVariable = 0; //read values from the local or thread memory in thread stack
	
	/**
	 * Here we have selected the static locks bcoz we want the threads to wait for the lock while other thread
	 * is executing either of two blocks in parallel.  If we have instance variables of lock object here then
	 * each thread will create seperate lock object for their execution and will not be able to achieve
	 * the desired or expected results.
	 */
	private final static Object lock1 = new Object();
	private final static Object lock2 = new Object();
	
	LockObject(int shared, int local){
		sharedVariable = shared;
		localVariable = local;
	}
	
	public LockObject() {
		// TODO Auto-generated constructor stub
	}

	public void  lockMethod(String threadName){
		
		/**
		 * it's important to have two different (static) locks for both blocks here because if you lock both synchronized
		 * blocks with single lock object then both synchronized block will run sequentially instead of parallel 
		 * by multiple threads since underlying locked objects are different.
		 * 
		 * here since both are static locks, each thread will have to first acquire the shared locks (lock 1 & lock2)
		 * and then only they can execute the blocked code. Two diff threads can run in both blocks individually here
		 * without locking down each other. Thread 1 can execute first block & either of thread 2 to 100 can run in second block. 
		 */
		synchronized(lock1){
			System.out.println("========================================================================");
			System.out.println(threadName + " :: " + lock1 +" Read local variable => " + this.localVariable);
			System.out.println(threadName + " :: " + lock1 +  " Read shared variable => " + sharedVariable);
			System.out.println("========================================================================");
		}
		
//		for(int i=0; i<1000;i++){
////			System.out.println("...");
//		}
		
		synchronized(lock2){
			System.out.println("========================================================================");
			System.out.println(threadName + " :: " + lock1 + " Updated local variable => " + ++this.localVariable);
			System.out.println(threadName + " :: " + lock1 + " Updated shared variable => " + ++sharedVariable);
			System.out.println("========================================================================");
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
