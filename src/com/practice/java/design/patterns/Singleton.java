package com.practice.java.design.patterns;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private static Singleton singleton = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}