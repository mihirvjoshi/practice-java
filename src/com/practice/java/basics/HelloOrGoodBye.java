package com.practice.java.basics;

public class HelloOrGoodBye {

	private void helloOrGoodBye() {
		try {
			System.out.println("Hello world");
			System.exit(0);
		} finally {
			System.out.println("Goodbye world");
		}
	}

	/**
	 * When system.exit is called the VM performs two clean up tasks before
	 * shutting down. 1. Executes all shutdown hooks registered with the
	 * Runtime.addshutdownhook 2. This clean task concerns the finalizers. If
	 * either System.runFinalizersOnExit or its evil twin
	 * Runtime.runFinalizersOnExit has been called, the VM runs the finalizers
	 * on all objects that have not yet been finalized. Never call
	 * System.runFinalizersOnExit or Runtime.runFinalizersOnExit for any reason:
	 * They are among the most dangerous methods in the Java libraries
	 */
	private void helloAndGoodBye() {
		System.out.println("Hello world");

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Goodbye world");
			}
		});
		System.exit(0);

	}

	public static void main(String[] args) {
		// new HelloOrGoodBye().helloOrGoodBye();
		new HelloOrGoodBye().helloAndGoodBye();
	}
}