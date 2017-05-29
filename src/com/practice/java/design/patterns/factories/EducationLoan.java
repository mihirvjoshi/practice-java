package com.practice.java.design.patterns.factories;

public class EducationLoan extends Loan {

	@Override
	public void getInterestRate(double r) {
		rate = r;
	}

}
