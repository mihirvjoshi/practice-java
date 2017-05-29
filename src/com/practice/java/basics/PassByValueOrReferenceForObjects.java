package com.practice.java.basics;

public class PassByValueOrReferenceForObjects {

	public void tricky(Point arg1, Point arg2) {
	  Point temp = arg1;
	  arg1 = arg2;
	  arg2 = temp;
	  System.out.println("========= values in the method after the swapping (obj1, obj2) =========");
	  System.out.println("X: " + arg1.x + " Y: " +arg1.y); 
	  System.out.println("X: " + arg2.x + " Y: " +arg2.y);
	  System.out.println(" ");
	}
	
	public static void main(String [] args) {
	  PassByValueOrReferenceForObjects.Point pnt1 = new PassByValueOrReferenceForObjects().new Point(0,0);
	  PassByValueOrReferenceForObjects.Point pnt2 = new PassByValueOrReferenceForObjects().new Point(0,0);
	  pnt1.x = 100;
	  pnt1.y = 100;
	  System.out.println("========= original values in the main =========");
	  System.out.println("X: " + pnt1.x + " Y: " +pnt1.y); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
	  System.out.println(" ");
	  new PassByValueOrReferenceForObjects().tricky(pnt1,pnt2);
	  System.out.println("========= modified values in the main =========");
	  System.out.println("X: " + pnt1.x + " Y:" + pnt1.y); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);  
	  System.out.println("conclusion: tricky method swaps the copy of the reference variables but since actual references are modified in the swapping processs");
	  System.out.println("conclusion: so it will not be reflected in the same sequence in main method.");
	}
	
	class Point {
		int x;
		int y;
		
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
