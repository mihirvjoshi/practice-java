package com.practice.java.performance;

import java.lang.reflect.Proxy;

public class PerformanceTest {

	public static void main(String[] args) {
		Customer cust = new CustomerImpl();
		PerformanceLogger pl = new PerformanceLogger(cust);
		cust = (Customer) Proxy.newProxyInstance(
				CustomerImpl.class.getClassLoader(),
				new Class[] { Customer.class }, pl);
		cust.getDetails("8");

	}

}
