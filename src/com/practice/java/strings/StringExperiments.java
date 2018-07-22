package com.practice.java.strings;

public class StringExperiments {

	// if (object already exists on the string pool) then refer the same object.
	// else create new one.
	static String iAmReference = "i am reference"; // new object created and put
													// on the string pool.

	// if (object already exists on the string pool) then refer the same object.
	// else create new one.
	static String iAmSameReference = "i am reference"; // reference created and
														// pointed to
														// iAmReference1

	// two new objects created below and put on the heap memory.
	static String iAmNewObject1 = new String("i am reference");
	static String iAmNewObject2 = new String("i am reference");

	public static void main(String[] args) {

		// compare the references.
		if (iAmReference == iAmSameReference) {
			System.out.println("References are always same");
		}

		// compare reference with object.
		if (!(iAmReference == iAmNewObject1)) {
			System.out.println("Objects and reference are never same");
		}

		// compare objects created in heap memory.
		if (!(iAmNewObject1 == iAmNewObject2)) {
			System.out
					.println("Two ojects are never same in java. remember hash code ??");
		}

		System.out
				.println("===========Putting iAmNewObject1 on the string pool===============");

		// Now put iAmNewObject1 created in heap memory to String pool.
		iAmNewObject1 = iAmNewObject1.intern();

		// compare reference with object.
		if (iAmReference == iAmNewObject1) {
			System.out
					.println("Now iAmNewObject1 is put on String pool from heap memory.");
		}

		System.out
				.println("===========Putting iAmNewObject2 on the string pool===============");

		// Now put iAmNewObject1 created in heap memory to String pool.
		iAmNewObject2 = iAmNewObject2.intern();

		System.out.println("compar two objects again now.");

		// compare two objects again now.
		if (iAmNewObject1 == iAmNewObject2) {
			System.out
					.println("Now iAmNewObject2 is also put on String pool from heap memory.");
		}

	}

}
