package com.practice.java.datastructure;


public class MyQueue {
	Node first;
	Node head;
	
	public void add(Object obj){
		Node current = head;
		if(first == null) {
			first = new Node(obj);
			head = first;
		} else {
			while(current != null){
				current = current.next;
			}			
			head.next = new Node(obj);
		}
	}
	
	public Object get(int index){
		
		while(head != null) {		
			head=head.next;			
		}
		
		return index;
	}
	
	class Node {
		Object item;
		Node next;
		
		public Node(Object o){
			item = o;
			next = null;
		}
	}

	public static void main(String[] args) {
		MyQueue m = new MyQueue();
		m.add(10);
	}

}
