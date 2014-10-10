package com.practice.java.basics;

import java.util.HashSet;
import java.util.Set;

	class EqualsAndHashCode {
		private final String first, last;

		public EqualsAndHashCode(String first, String last) {
			this.first = first;
			this.last = last;
		}

		public boolean equals(Object o) {
			if (!(o instanceof EqualsAndHashCode))
				return false;
			EqualsAndHashCode n = (EqualsAndHashCode) o;
			return n.first.equals(first) && n.last.equals(last);
		}

	public static void main(String[] args) {
		Set<EqualsAndHashCode> s = new HashSet<EqualsAndHashCode>();
		s.add(new EqualsAndHashCode("Mickey", "Mouse"));
		System.out.println(s.contains(new EqualsAndHashCode("Mickey", "Mouse")));
	}

}
