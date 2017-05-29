package com.practice.java.threads.oddeven;


public class MyOddEvenThreads{
	int i=1;
	private class MyOddThread implements Runnable{
		MyOddEvenThreads mainThread;
		MyOddThread(MyOddEvenThreads mainThread){
			this.mainThread=mainThread;
		}
		public void run(){
			synchronized(mainThread){
				while(mainThread.i<=99){
					while(mainThread.i%2==0){//if number is even then just wait.
						try {
							mainThread.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("odd=>"+mainThread.i);
					mainThread.i++;
					mainThread.notifyAll();
				}
			}
		}
	}
	
	private class MyEvenThread implements Runnable{
		MyOddEvenThreads mainThread;
		MyEvenThread(MyOddEvenThreads mainThread){
			this.mainThread=mainThread;
		}
		public void run(){
			synchronized(mainThread){
				while(mainThread.i<=100){
					while(mainThread.i%2!=0){//if number is odd then just wait.
						try {
							mainThread.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("even=>"+mainThread.i);
					mainThread.i++;
					mainThread.notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyOddEvenThreads lock=new MyOddEvenThreads();
		MyOddEvenThreads.MyOddThread odd = new MyOddEvenThreads().new MyOddThread(lock);
		new Thread(odd).start();
		MyOddEvenThreads.MyEvenThread even = new MyOddEvenThreads().new MyEvenThread(lock);
		new Thread(even).start();
	}
}
