package com.practice.java.design.patterns;

public class TraditionalSingleton {

	private static volatile TraditionalSingleton instance = null;

	private TraditionalSingleton() {
		System.out.println("I'm only single instance :: " + this.toString());
	}

	public static TraditionalSingleton getInstance() {

		// below condition is a serious issue bcoz in multi threaded scenarios
		// while you check null condition more than one thread can see null
		// value
		// and try to create new instance
		synchronized (TraditionalSingleton.class) {
			if (instance == null)
				instance = new TraditionalSingleton(); // to avoid this
														// initialize instance
														// at the beginning
														// instead null static
														// value
		}
		return instance;
	}

}
