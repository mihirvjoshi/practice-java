package com.practice.java.enums;

public class WeekDaysEnumerations {

	// good old days when static was used to define predefined data.
	public static final int Monday = 1; // wait a second, I cant print the name
										// of the week day like Monday
	public static final int Tuesday = 2; // oops, yah it will just print values
											// 1, 2, 3, 4 etc...
	public static final int Wednesday = 3; // Damn !!!!!
	public static final int Thursday = 4;
	public static final int Friday = 5;

	// jdk 1.5 revolutionized the behavior with enum.
	public enum WEEKDAYS {
		// wow great !!! now i can print the weekdays using enum.name
		Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5);

		private int value;

		private WEEKDAYS(int value) {
			this.value = value;
		}

	};

	public static void main(String[] args) {

		WEEKDAYS day = WEEKDAYS.Monday;

	}

}
