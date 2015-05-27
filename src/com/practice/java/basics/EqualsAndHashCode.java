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
			return n.first.equals(this.first) && n.last.equals(this.last);
		}

		public int hashCode(){
			return this.first.hashCode() + this.last.hashCode() + 31;			
		}
		
	public static void main(String[] args) {
		EqualsAndHashCode objectWithoutEqualsAndHashcode = new EqualsAndHashCode("Mickey", "Mouse");
		Set<EqualsAndHashCode> s = new HashSet<EqualsAndHashCode>();
		s.add(objectWithoutEqualsAndHashcode);
		
		//this will return true only if equals & hashcode are overridden. if either of it is overridden then it will return false
		System.out.println(s.contains(new EqualsAndHashCode("Mickey", "Mouse"))); 
		
		// this will return true even without overriding equals method.
		System.out.println(s.contains(objectWithoutEqualsAndHashcode)); 
	}

}
