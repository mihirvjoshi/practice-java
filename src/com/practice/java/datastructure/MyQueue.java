package com.practice.java.datastructure;



public class MyQueue implements IQueue{
	Node first;
	Node head;
	protected int SIZE = 0;

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

	@Override
	public Object pop() {
		
		Node newFirst = null;	
		Object popedObject = null;
		
		if(this.first != null) {
			popedObject = this.first.item;
			newFirst = this.first.next;		
			this.first = newFirst;
			SIZE--;
		} else return null;
		
		return popedObject;
	}
	
	@Override
	public Object peek() {
		return null;
	}
	
	public int size() {
		return this.SIZE;
	}
}
