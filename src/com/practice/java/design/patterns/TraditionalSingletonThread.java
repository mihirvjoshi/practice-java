package com.practice.java.design.patterns;

public class TraditionalSingletonThread extends Thread {

    @Override
    public void run() {
	TraditionalSingleton firstInstance = TraditionalSingleton.getInstance();
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
    }

    public static void main(String[] args) {
	
	for (int i = 0; i < 100; i++) {
	    new TraditionalSingletonThread().start();
	    System.out.println(i);
	}
	
    }

}
