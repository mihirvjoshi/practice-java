package com.practice.java.datastructure;

public class MyLinkedList {
	Node first;
	
	public void add(Object o) {			
		if(first == null) {
			first = new Node(o);
		} else {
			Node newNode = new Node(o);
			Node currentNode =  first;
			
			// here it's important to check current.next for not null value because
			// at the last node current will become null and so there will not be
			// any reference left to assign new node to.
			while(currentNode.next != null) {
				currentNode = currentNode.next; 
			}
			currentNode.next = newNode;
		}
	}
	
	private class Node {
		Object data;
		Node next;
		
		Node(Object data) {
			this.data = data;
			this.next = null;
		}		
	}
	
	public void reverse() {
		Node previous = null, newFirst = null, temp = null;
		Node current = first;		
//		newFirst = current;
//		current = current.next;
//		newFirst.next = null;

		while(current != null) {
//			previous = newFirst;
//			temp = current;
//			current = current.next;
//			temp.next = previous;
//			newFirst = temp;			

		     previous = current;
		     
		     // #1. this step is important in the sequence here because 
		     // current(memory address) is still being referred by previous in last step.
		     // so any operation you do on current or previous will update both references
		     current = current.next; 
		     temp = newFirst;
		     // here if you din't hv step #1 then newFirst will hold reference of current (through previous)
		     // and so once you do newfirst.next = temp (which is null, temp=newFirst=null) then current.next 
		     // also becomes null and so the chain ends on very first element.
		     newFirst = previous; 
		     newFirst.next = temp;
		}
		
		first = newFirst;
	}
	
	/**
	 * Reverse every 3 node in linked list. 
	 * For example 1 2 3 4 5 6 7 8 9 => 3 2 1 6 5 4 9 8 7
	 * @return
	 */
	public void reverse3Nodes(){
		
//		int count = 0;

		Node current = first;
		Node temp = null;
		Node previous = null;
		Node newFirst = null;
		
		while(current != null) {
//		     ++count;
		
		     previous = current;
		     current = current.next;
		     temp = newFirst;
		     newFirst = previous;
		     newFirst.next = temp;
		     
//		     if(count == 1) {
//		    	one = current;
//		     }
//		     
//			if(count==3) {
//				count = 0;
//				third = current; //third = 3;
//				temp = one; 	 //temp = 1;
//				one.next=third.next; //one.next=4;
//				third.next=temp.next; //third.next=1;
//			}
		     
		}
		
		first = newFirst;
	}
	
	public String toString(){
		String listAsString = "";
		Node current = first;
		while(current != null) {
			listAsString = listAsString + current.data + ",";
			current =  current.next;			
		}
		
		return listAsString;		
	}
	
	public static void main(String args[]) {
		
		MyLinkedList myList = new MyLinkedList();
		myList.add(10);
		myList.add(11);
		myList.add(12);
		myList.reverse();
		System.out.println(myList.toString());
		System.out.println("====================");
		myList.reverse3Nodes();
		System.out.println(myList.toString());
		System.out.println("====================");
	}
}
