package com.practice.java.datastructure.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumNumberOfInputs {

    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);        

        // loop N times to sum the numbers entered in the following lines.
		for (int i = 0; i < N; i++) {
	        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	        String line1 = br1.readLine();
	        System.out.println(line1);
	        int a = Integer.parseInt(line1.split(" ")[0].trim());        
	        int b = Integer.parseInt(line1.split(" ")[1].trim());
	        
/*	        for(int number = 2; number<=limit; number++){
	            //print prime numbers only
	            if(isPrime(number)){
	                System.out.println(number);
	            }
	        }	        
*/	        System.out.println(a+b);
	    }        
    }
}
