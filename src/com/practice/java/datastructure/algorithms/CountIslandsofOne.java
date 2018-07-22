package com.practice.java.datastructure.algorithms;

public class CountIslandsofOne {
	static int a1[][] = new int[6][6];
	static int visited[][] = new int[6][6];
	static int counter = 0;

	public static void main(String[] args) {

		initializeArray(a1);				
		printArray(a1);
		
		for(int i=0; i < a1[0].length; i++) {
			for(int j=0; j < a1[1].length; j++) {				
				if(a1[i][j]==1 && visited[i][j]!=1) {
					System.out.println("===========================================");
					counter++;
					markVisited(i, j);
				}
			}			
		}		
		System.out.println("Counter is " + counter);
	}

	private static void markVisited(int i, int j) {

		int minI = 0, maxI =  a1[0].length-1;
		int minJ = 0, maxJ = a1[1].length-1;
		
		if(a1[i][j]==0) return;
		if(i!=minI) minI = i - 1;
		if(j!=minJ) minJ = j - 1;
		if(i!=maxI) maxI = i + 1;
		if(j!=maxJ) maxJ = j + 1;
		
		for(int m=minI; m <= maxI; m++) {
			for(int n=minJ; n <= maxJ; n++) {
				if(a1[m][n] == 1 & !(m==i && n==j) && visited[m][n]!=1) {
					visited[m][n]=1;
					markVisited(m, n);
				}
			}
		}	
	}
	
	private static void printArray(int[][] a1) {
		for(int i=0; i < a1[0].length; i++) {
			for(int j=0; j < a1[1].length; j++) {
				System.out.print(a1[i][j]);
				System.out.print(" ");
			}			
			System.out.println();			
		}
	}

	private static void initializeArray(int[][] a1) {
		a1[1][1] = 1;
		a1[1][2] = 1;
		
		a1[2][4] = 1;
		
		a1[3][0] = 1;
		a1[3][3] = 1;
		a1[3][4] = 1;
		a1[3][5] = 1;
		
		a1[4][2] = 1;
		a1[4][3] = 1;
		a1[4][4] = 1;
		a1[4][5] = 1;
	}
}
