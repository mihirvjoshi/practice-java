package com.practice.java.enums;

public class WeekDaysCalculator {
    
    private static void printWeekDays(WeekDaysEnumerations.WEEKDAYS day){
	
	//convert string Monday to ENUM type.
	System.out.println("value of"+ day.valueOf("Monday"));
	
	//so easy to iterate on the enums like primitive types unlike static variables.
	switch(day){
		case Friday: System.out.println("Hurray !! Friday it is"); break;
		default: System.out.println("Bloody Hell !! it's working day"); break;
	}
    }


    public static void main(String[] args) {

	printWeekDays(WeekDaysEnumerations.WEEKDAYS.Monday);
	printWeekDays(WeekDaysEnumerations.WEEKDAYS.Friday);
//	printWeekDays(WeekDaysEnumerations.WEEKDAYS.);
    }

}
