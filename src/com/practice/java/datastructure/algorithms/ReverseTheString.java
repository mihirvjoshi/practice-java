package com.practice.java.datastructure.algorithms;

import java.util.Scanner;

public class ReverseTheString {
	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
		int[] result = new int[2];
		int aScore = 0, bScore = 0;

		if (a0 > b0)
			aScore = aScore + 1;
		if (a1 > b1)
			aScore = aScore + 1;
		if (a2 > b2)
			aScore = aScore + 1;
		
		if (a0 < b0)
			bScore = bScore + 1;
		if (a1 < b1)
			bScore = bScore + 1;
		if (a2 < b2)
			bScore = bScore + 1;
		result[0] = aScore;
		result[1] = bScore;
		return result;
	}

	public String reverse(String str){
		char[] charArr = str.toCharArray();
		int head=0;
		int tail=str.length()-1;
		
		while(head<=tail){
			char temp=charArr[head];
			charArr[head]=charArr[tail];
			charArr[tail]=temp;
			head++;tail--;
		}
		return String.valueOf(charArr);
	}
	
	public static void main(String[] args) {
//		System.out.println(new ReverseTheString().reverse("Mihir"));
		Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
	}
}
