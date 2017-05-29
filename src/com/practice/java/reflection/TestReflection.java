package com.practice.java.reflection;

import com.sun.org.apache.bcel.internal.generic.GOTO;


public class TestReflection {

	public static void main(String args[]){
		/**SuperClass parent = new SuperClass();
		parent = (SuperClass) new SubClass1();
		parent = (SuperClass) new SubClass2();
		
		parent.callMethod();**/
		
		int a=1;
		int b=2;
		
		if (a == 1) {
			System.out.println("go to hell");
			GOTO hell;
			hell: System.out.println("hell is here");
		}
		
		try{
			System.out.println(2/0);
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally{
			System.out.println("here");
			try{
				System.out.println(2/0);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
