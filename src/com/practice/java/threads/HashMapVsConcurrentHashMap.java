package com.practice.java.threads;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsConcurrentHashMap<K, V> {
    
    Map<K, V> simpleMap = new HashMap<K, V>(1000000);
    Map<K, V> concurrentMap = new ConcurrentHashMap<K, V>(1000000);    
    Map<K, V> hello = new HashMap<K, V>();
    
     /**
     * @param args
     */
    public static void main(String[] args) {
	
	HashMapVsConcurrentHashMap<Integer,String> mapClass = new HashMapVsConcurrentHashMap<Integer,String>();
	
	Time time = new Time(System.currentTimeMillis());
	
	for(int i=0; i<1000000;i++){
	    mapClass.simpleMap.put(new Integer(i),"value");
	}

	System.out.println("Starting Minutes:"+time);
	
	for(int i=0; i<1000000;i++){
//	    System.out.println(mapClass.simpleMap.get(i));
	    mapClass.simpleMap.get(i);
	}
	
	Time newTime = new Time(System.currentTimeMillis());
	
	System.out.println("Ending Minutes:" + newTime);	
	System.out.println("=================================================================");
	
	for(int i=0; i<1000000;i++){
	    mapClass.concurrentMap.put(new Integer(i),"value");
	}

	Time time1 = new Time(System.currentTimeMillis());

	System.out.println("Starting Minutes:"+time1);
	
	for(int i=0; i<1000000;i++){
//	    System.out.println(mapClass.simpleMap.get(i));
	    mapClass.concurrentMap.get(i);
	}
	
	Time newTime1 = new Time(System.currentTimeMillis());
	
	System.out.println("Ending Minutes:" + newTime1);
	
    }

}
