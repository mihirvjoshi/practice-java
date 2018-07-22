package com.practice.java.inheritance;

class Base {
	protected int i;

	Base() {
		add(1);
		System.out.println("Base initialized");
	}

	int add(int v) {
		i += v;
		System.out.println("Base value is " + i);
		return i;
	}


	public static void main(String[] args) {
		System.out.println(" " + bogo(new Extension()));
	}

	static int bogo(Base b) {
		return b.add(8);
	}


}

class Extension extends Base {
	Extension() {
		add(1);
		System.out.println("Child initialized");
	}

	int add(int v) {
		i += v * 2;
		System.out.println("Child value is " + i);
		return i;
	}

}
