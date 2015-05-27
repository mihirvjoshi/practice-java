package com.practice.java.datastructure.algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MatricsMultiplication {
	static int [][] matrix1 = new int[2][2];
	static int [][] matrix2 = new int[2][3];
	static int [][] matrix_final = new int[matrix1.length][matrix2[0].length];
	
	/**
	 * @param <E>
	 * @param args
	 */
	public static  void main(String[] args) throws IOException {
		Scanner console;                // Java console Scanner
		String selection;  
		java.util.List list = new ArrayList();
        console = new Scanner(System.in);
		int cols=0; int rows=0;
		System.out.println("Enter  matrix1");
		while(rows<2){ 
			cols=0; //reset rows counter everytime.
			while(cols<2){
				System.out.println("matrix1:[" + rows+cols + "]");
				selection = console.next();System.out.print("\t");
				matrix1[rows][cols] = Integer.parseInt(selection);
				++cols;
			}
			System.out.print("\n");
			++rows;
		}
		rows=0;cols=0;
		while(rows<2){ 
			cols=0; //reset rows counter everytime.
			while(cols<3){
				System.out.println("matrix2:[" + rows+cols + "]");
				selection = console.next();System.out.print("\t");
				matrix2[rows][cols] = Integer.parseInt(selection);
				++cols;
			}
			System.out.print("\n");
			++rows;
		}
		
//		System.out.println("matrix1.length::"+matrix1.length);
//		System.out.println("matrix2.length::"+matrix2.length);
//		System.out.println("matrix1[0].length::"+matrix1[0].length);
//		System.out.println("matrix2[0].length::"+matrix2[0].length);
//		System.out.println("matrix1[1].length::"+matrix1[1].length);
//		System.out.println("matrix2[1].length::"+matrix2[1].length);

		int temp=0;
		for(int a=0 ;a < matrix1.length ; a++){//0,1
			System.out.println("matrix_final::");
			for(int b=0 ;b < matrix2[a].length ; b++){ // 0,1,2
				for(int c=0 ;c < matrix1[a].length ; c++){// 0,1
 					temp += matrix2[c][b] * matrix1[a][c];	
// 					System.out.println("matrix1["+a+"]["+c+"]::" + matrix1[a][c]);
// 					System.out.println("matrix2["+c+"]["+b+"]::" + matrix2[c][b]);
				}
//				System.out.println("temp::" + temp);
				matrix_final[a][b]=temp;
				System.out.println("::" + matrix_final[a][b]);
				temp=0;
			}			
//			System.out.println("\n");
		}
	}
}
