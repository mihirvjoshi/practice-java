package com.practice.java.basics;

public class ThreadClass  extends Thread{
	
	public static double methodOne(int test){
		double temp = test + Math.random();
		System.out.println("temp::" + temp);
		return temp;
	}
	
	public void run(){
		try {
	          for(int i=0;i<=50;i++)
			  {
	            System.out.println("Run method:: "+ i + "::" + methodOne(i));
	            sleep(10000);yield();
		      }
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void main(String args[]){
		new ThreadClass().start();
		
	}
}
