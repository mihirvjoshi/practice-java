package com.practice.java.design.patterns;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * 
 * Ways to break Singleton
 */
public class BreakSingleton {

private static ObjectInputStream inputStream;

	public static void main(String[] args) throws Exception {
		Singleton orginalSingletonObject = Singleton.getInstance();

		/***
		 * Singleton is broken by using Reflection
		 */
		breakSingletonByReflection(orginalSingletonObject);

		/***
		 * By Serialization/De-Serialization break Singleton We need
		 * Serialization interface in a class nedds to be serialized like
		 * Singleton.java
		 */
		breakSingletonByserialization(orginalSingletonObject);

		/***
		 * By Cloning break Singleton We need to implement Cloneable interface
		 */
		breakSingletonByCloning(orginalSingletonObject);

		/***
		 * Break Singleton By thread This scenario is related to multi-threading
		 * environment
		 * 
		 */

		breakSingletonByThreading(orginalSingletonObject);
	}

	private static void breakSingletonByThreading(
			Singleton orginalSingletonObject) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		/**
		 * Run this code snippet after commenting the other code for better
		 * understanding Run it repeatly to create a condition when 2 threads
		 * enter the method getInstance() of Singleton class at a same time When
		 * 2 threads enter the getInstance method at same time they will get the
		 * singleton object as null (private static Singleton singleton in
		 * Singleton.java) Then they will create two different objects ( have
		 * different hashcode) in this case singleton pattern will break.
		 */
		executorService.submit(BreakSingleton::useSingleton); // JAVA 8 syntax it
																// will get the
																// singleton
																// instance
		executorService.submit(BreakSingleton::useSingleton);
		executorService.shutdown();
	}

	public static void useSingleton() {
		Singleton singleton = Singleton.getInstance();
		printSingletonData("By Threading", singleton);
	}


	private static void breakSingletonByCloning(Singleton orginalSingletonObject) throws CloneNotSupportedException {
		Singleton clonedSingletonObject = (Singleton) orginalSingletonObject.clone();
		printSingletonData("By Cloning", orginalSingletonObject, clonedSingletonObject);
	}

	private static void breakSingletonByReflection(Singleton orginalsingleton)
        throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException,InvocationTargetException {

		Class<?> singletonClass = Class.forName("com.practice.java.design.patterns.Singleton");
		@SuppressWarnings("unchecked")
		Constructor<Singleton> constructor = (Constructor<Singleton>) singletonClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton s = constructor.newInstance();
		printSingletonData("By Reflection", orginalsingleton, s);
	}

	private static void breakSingletonByserialization(Singleton orginalsingleton)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		/**
		 * Serialization
		 */
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("E:\\Singleton.ser"));
		outputStream.writeObject(orginalsingleton);
		outputStream.close();

		/**
		 * DeSerialization
		 */
		inputStream = new ObjectInputStream(new FileInputStream( "E:\\Singleton.ser"));
		Singleton deserializeObject = (Singleton) inputStream.readObject();
		deserializeObject.hashCode();
		printSingletonData("By Serialization", orginalsingleton, deserializeObject);

	}

	public static void printSingletonData(String operationName, Singleton orginalsingleton, Singleton reflectionSigletonObject) {
		System.out.println("------------------------------------------");
		System.out.println("New Operation");
		System.out.println(operationName);
		System.out.println("orginal Hashcode=" + orginalsingleton.hashCode());
		System.out.println("New Object hashcode=" + reflectionSigletonObject.hashCode());
		Boolean value = orginalsingleton.hashCode() != reflectionSigletonObject .hashCode();
		System.out.println("These Object have different hascode. They are two different object Right = " + value);
		System.out .println("As these are different Object this means Singleton Pattern is broken");
	}


	private static void printSingletonData(String operationName, Singleton singleton) {
		System.out.println("------------------------------------------");
		System.out.println("New Operation");
		System.out.println(operationName);
		System.out.println("Object hashcode=" + singleton.hashCode());
	}
}