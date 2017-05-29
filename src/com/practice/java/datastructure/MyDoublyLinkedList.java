package com.practice.java.datastructure;

public class MyDoublyLinkedList {
	private Node head;
	private Node tail;
	
	public MyDoublyLinkedList(Node head) {
		this.head=head;
	}
	
	public MyDoublyLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public void add(int data){
		if(head==null){
			head=new Node(data);
			tail=head;
		}else{
			Node current = head;
			while(current.next!=null){
				current=current.next;				
			}
			current.next=new Node(data, null, current);
		}
	}
	
	public void print(Node head){
		Node current=head;
		while(current.next!=null){
			System.out.println(current.data);
			current=current.next;
		}
		System.out.println(current.data);
		System.out.println("=============================================");
		while(current.prev!=null){
			System.out.println(current.data);
			current=current.prev;
		}
		System.out.println(current.data);
	}
	
	public static class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data=data;
			this.next=null;
			this.prev=null;
		}
		Node(int data, Node next, Node prev){
			this.data=data;
			this.next=next;
			this.prev=prev;
		}
	}
	
	public static void main(String args[]) {

		MyDoublyLinkedList myList = new MyDoublyLinkedList();
		myList.add(10);
		myList.add(11);
		myList.add(12);
		myList.print(myList.head);
	}
}
