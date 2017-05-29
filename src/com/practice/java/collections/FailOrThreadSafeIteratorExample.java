package com.practice.java.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
 
public class FailOrThreadSafeIteratorExample {
 
    public static void main(String[] args) {
 
        List<String> myList = new CopyOnWriteArrayList<String>();
 
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
 
        Iterator<String> it = myList.iterator();
        
        while(it.hasNext()){
            String value = it.next();
            System.out.println("List Value:"+value);
            if(value.equals("3")){
                System.out.println("Element 4 is removed during the iteration & elements 6 & 7 inserted.");
               myList.remove("4");
                myList.add("6");
                myList.add("7");
            }
        }
 
        System.out.println("List Size:"+myList.size());
 
        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");
 
        Iterator<String> it1 = myMap.keySet().iterator();
        
        while(it1.hasNext()){
            String key = it1.next();
            System.out.println("Map Value:"+myMap.get(key));
            if(key.equals("1")){
                myMap.remove("3");
                System.out.println("Element 3 is removed during the iteration & elements 4 & 5 inserted.");
                myMap.put("4", "4");
                myMap.put("5", "5");
            }
        }
 
        System.out.println("Map Size:"+myMap.size());
    	System.out.print("This class uses fail safe iterarors which are provided in jdk7 for: ");
    	System.out.println("CopyOnWriteArrayList & ConcurrentHashMap");
    	System.out.println("Rest of the iterators are fail-fast which means it'll throw");
    	System.out.println("Concurrent modification exception in case of updates during iteration.");
    }
 
}
