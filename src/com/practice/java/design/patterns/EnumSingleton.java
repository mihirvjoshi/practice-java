package com.practice.java.design.patterns;

/**
 * Enum singletons are thread safe by default and serialization is also ensured by jdk.
 * Also there is no need to synchronize or 
 * @author N557050
 *
 */
public enum EnumSingleton {

    INSTANCE; //instance is a keyword for enums to create object.
    
    private static String connection = "This is the only instance";
    
    public static String getInstance(){
    	return INSTANCE.connection;
    }
  
}
