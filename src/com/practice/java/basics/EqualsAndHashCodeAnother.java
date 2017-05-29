package com.practice.java.basics;

import java.util.HashSet;
import java.util.Set;

	class EqualsAndHashCodeAnother {
		private final String first, last;
		int id;

		public EqualsAndHashCodeAnother(String first, String last, int id) {
			this.first = first;
			this.last = last;
		}

		public boolean equals(Object o) {
			if (!(o instanceof EqualsAndHashCodeAnother))
				return false;
			EqualsAndHashCodeAnother n = (EqualsAndHashCodeAnother) o;
			return n.id==this.id && n.id==this.id;
		}

		public int hashCode(){
			return this.id + this.id + 31;			
		}
		
	public static void main(String[] args) {
		EqualsAndHashCodeAnother objectWithoutEqualsAndHashcode = new EqualsAndHashCodeAnother("Mickey", "Mouse", 10);
		Set<EqualsAndHashCodeAnother> s = new HashSet<EqualsAndHashCodeAnother>();
		s.add(objectWithoutEqualsAndHashcode);
		
		//this will return true only if equals & hashcode are overridden. 
		//if either of it is overridden then it will return false
		System.out.println(s.contains(new EqualsAndHashCodeAnother("Mickey", "Mouse", 10))); 
		
		// this will return true even without overriding equals method as it is the same reference and not new object.
		System.out.println(s.contains(objectWithoutEqualsAndHashcode)); 
	}

}
