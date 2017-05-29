package com.practice.java.datastructure.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


class TestClass {
	
    public static boolean isPrime(int number){
        for(int i=2; i<number; i++){
           if(number%i == 0){
               return false; //number is divisible so its not prime
           }
        }
        return true; //number is prime now
    }

	
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();;
        String numString = ""; int highestFrequency = 0; int highestNumber = -1;
        
        for (int i = 0; i < N; i++) {
        	highestFrequency = 0;
        	highestNumber = -1;
        	initializeMap(frequencyMap) ;
            br = new BufferedReader(new InputStreamReader(System.in));
            line = br.readLine();
        	int l = Integer.parseInt(line.split(" ")[0].trim());        
	        int r = Integer.parseInt(line.split(" ")[1].trim());

	        if (l <= 1) l = 2;

	        for(int number = l; number<=r; number++){
	            //print prime numbers only
	            if(isPrime(number)){
	            	numString = String.valueOf(number);
	            	if(numString.length() > 1) {	            		
	            		int digit1 = Integer.valueOf(numString.substring(0,1));
	            	//	System.out.println("digit 1 is " + digit1);
	            		pushToMap(frequencyMap, digit1);
	            		int digit2 = Integer.valueOf(numString.substring(1,2));
		            	//System.out.println("digit 2 is " + digit2);
	            		pushToMap(frequencyMap, digit2);
	            	} else {
	            		pushToMap(frequencyMap, number);
	            	}
	       //         System.out.print(number + " ");
	            }
	        }
            
			for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
				//System.out.println(entry.getKey() + "=" + entry.getValue());
				if(entry.getValue() > highestFrequency) {
					highestFrequency = entry.getValue();
					highestNumber = entry.getKey();
				}				
			}

			System.out.println(highestNumber);
		}
      //  System.out.println("Hello World!");
    }


	private static void pushToMap(Map<Integer, Integer> frequencyMap, int number) {
		int count = frequencyMap.get(number);
		System.out.println("contains " + number + " for " + count);
		frequencyMap.put(number, count++);
	}
	
	private static void initializeMap(Map<Integer, Integer> frequencyMap){
		for (int i = 1; i <= 10; i++) {
			frequencyMap.put(i, 0);
		}
	}
}
