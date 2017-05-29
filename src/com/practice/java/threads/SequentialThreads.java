package com.practice.java.threads;

/**
 * The main objective of this class is to create N threads and make sure these threads run in the
 * given sequence and not in random order.
 * @author Mihir
 *
 */
public class SequentialThreads {
	private int sequence;
	
	SequentialThreads(int sequence){
		this.sequence=sequence;
	}
	
	public SequentialThreads() {
		// TODO Auto-generated constructor stub
	}

	public void setSequence(int sequence){
		this.sequence=sequence;		
	}

	public int getSequence(){
		return this.sequence;		
	}
	
	class FirstThread extends Thread {
		SequentialThreads sequentialThread;
		private int nextSequence;
	
		FirstThread(int next, String name, SequentialThreads sequentialThread) {
			this.sequentialThread = sequentialThread;
			this.setNextSequence(next);
			System.out.println("next"+this.getNextSequence());
			this.setName(name);
		}

		public void setNextSequence(int nextSequence){
			this.nextSequence=nextSequence;		
		}
		
		public int getNextSequence(){
			return this.nextSequence;		
		}
		
		public void run() {
			synchronized (this.sequentialThread) {
				while(true){
					while (this.sequentialThread.getSequence() != 1) {
						try {
							this.sequentialThread.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					System.out.println(this.getName() + " thread running");
					this.sequentialThread.setSequence(this.getNextSequence());
					this.sequentialThread.notifyAll();
					System.out.println("sequence is ::"
							+ this.getNextSequence() + "::"
							+ this.sequentialThread.hashCode());
				}
			}
		}
	}
	
	class SecondThread extends Thread {
		private int nextSequence;
		SequentialThreads sequentialThread;

		SecondThread(int next, String name, SequentialThreads sequentialThread) {
			this.sequentialThread = sequentialThread;
			this.setNextSequence(next);
			this.setName(name);
		}

		public void setNextSequence(int nextSequence){
			this.nextSequence=nextSequence;		
		}
		
		public int getNextSequence(){
			return this.nextSequence;		
		}
		
		public void run() {
			synchronized (this.sequentialThread) {
				while(true){
					while (this.sequentialThread.getSequence() != 2) {
						try {
							this.sequentialThread.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(this.getName() + " thread running.");
					this.sequentialThread.setSequence(this.getNextSequence());
					System.out.println("sequence is =>"
							+ this.getNextSequence() + "=>"
							+ this.sequentialThread.hashCode());
					this.sequentialThread.notifyAll();
				}
			}
		}
	}
	
	class ThirdThread extends Thread {
		private int nextSequence;
		SequentialThreads sequentialThread;

		ThirdThread(int next, String name, SequentialThreads sequentialThread) {
			this.sequentialThread = sequentialThread;
			this.setNextSequence(next);
			this.setName(name);
		}

		public void setNextSequence(int nextSequence){
			this.nextSequence=nextSequence;		
		}
		
		public int getNextSequence(){
			return this.nextSequence;		
		}
		
		public void run() {
			synchronized (this.sequentialThread) {
				while(true){
					while (this.sequentialThread.getSequence() != 3) {
						try {
							this.sequentialThread.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(this.getName() + " thread running.");
					this.sequentialThread.setSequence(this.getNextSequence());
					System.out.println("sequence is =>"
							+ this.getNextSequence() + "=>"
							+ this.sequentialThread.hashCode());
					this.sequentialThread.notifyAll();
				}
			}
		}
	}
	

	public static void main(String[] args) {
		SequentialThreads threads = new SequentialThreads(1);
		new SequentialThreads().new FirstThread(2, "first", threads).start();
		new SequentialThreads().new SecondThread(3, "second", threads).start();
		new SequentialThreads().new ThirdThread(1, "third", threads).start();
	}
}
