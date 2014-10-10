package com.practice.java.performance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceLogger implements InvocationHandler {

	protected Object delegate; // actual object that performs a function

	public PerformanceLogger(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		long startTime = System.currentTimeMillis();

		try {
			Object result = method.invoke(delegate, args); // invoke the
															// delegate
			return result;
		}

		finally {
			long endTime = System.currentTimeMillis();
			System.out.println("method took: " + (endTime - startTime) + "ms");
		}
	}
}
