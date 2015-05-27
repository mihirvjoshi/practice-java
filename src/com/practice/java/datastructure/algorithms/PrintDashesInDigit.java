package com.practice.java.datastructure.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class PrintDashesInDigit {

	public enum DigitEnum {
		ZERO(0, 6), ONE(1, 2), TWO(2, 5), THREE(3, 5), FOUR(4, 4), FIVE(5, 5), SIX(
				6, 6), SEVEN(7, 4), EIGHT(8, 7), NINE(9, 6);

		private int digit;
		private int dashes;

		private DigitEnum(int digit, int dashes) {
			this.digit = digit;
			this.dashes = dashes;
		}

		public int getDigit() {
			return digit;
		}

		public void setDigit(int digit) {
			this.digit = digit;
		}

		public int getDashes() {
			return dashes;
		}

		public void setDashes(int dashes) {
			this.dashes = dashes;
		}

	    private static Map<Integer, DigitEnum> map = new HashMap<Integer, DigitEnum>();
	    static {
	        for (DigitEnum digitEnum : DigitEnum.values()) {
	            map.put(digitEnum.digit, digitEnum);
	        }
	    }

	    public static DigitEnum valueOf(int digit) {
	        return map.get(digit);
	    }

	}

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		char[] no = line.toCharArray();
		int sum = 0; 
		
		try{
			for (int i = 0; i < no.length; i++) {
				String s = String.valueOf(no[i]);
				int digit = Integer.parseInt(s);
				sum = sum + DigitEnum.valueOf(digit).dashes;
			}
		}catch(Exception e){
			System.out.println("Invalid Input provided !!");
			System.exit(1);
		}

		System.out.println(sum);

	}
}
