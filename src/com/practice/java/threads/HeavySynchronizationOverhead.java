package com.practice.java.threads;

public class HeavySynchronizationOverhead {

	//we declared the size as volatile and so it'll always read latest read/write value from main meory instead of cache.
	private volatile int size; 
	
	public int get(){return size;}
	
	public synchronized int incrementAndGet(){
		System.out.println("Calling synchronized incrementAndGet");
		System.out.println("Our size variable is actually volatile and so it'll always read latest read/write value from main meory instead of thread stack.");
		System.out.println("Now let's say we have to do some other operations along with incrementing size here.");
		System.out.println("And so synchronization becomes evident to ensure atomicity of entire operations.");
		System.out.println("However, in this case eventhough operation is explicitly synchronized and size is atomic;");
		System.out.println("We have to bear with volatile variable overhead to read from main memory instead of thread stack.");
		System.out.println("Because compiler doesn't know about synchronization.");
		System.out.println("That's the main reason Atomic Variables are introduced in JDK 5.");
		return size++; //this operations needs lock via synchronized as increment is not atomic operation and gets performed in two steps.
	}
	
	public static void main(String[] args) {
		new HeavySynchronizationOverhead().incrementAndGet();
		// TODO Auto-generated method stub

	}

}
