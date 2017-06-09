package com.practice.java.basics;

/**
 * State of this object cannot be changed once initialized.
 * because it has no setter and only constructor takes argument.
 * @author N557050
 *
 */
public final class ImmutableClass {    
    private String dontTryToChangeMe = null;    
	public ImmutableClass(String initializingTheClass) {
		dontTryToChangeMe = initializingTheClass;
	}    
	
    //public void setDontTryToChangeMe(); this is illegal to have setter in immutable classes.    
	public final String getButDontTryToChangeMe() {
		return this.dontTryToChangeMe;
	}
}
