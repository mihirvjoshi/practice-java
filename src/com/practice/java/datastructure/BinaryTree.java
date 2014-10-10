package com.practice.java.datastructure;

public class BinaryTree {

	public static BinaryTree parent;
	
	private static BinaryTree left;
	
	private static BinaryTree right;
	
	private int node;
	
	private BinaryTree(){	}

	public static BinaryTree getInstance(){
		if(parent == null){
			parent = new BinaryTree();
		}
		return parent;
	}
	
	private static void insertNode(long node){
		node = node;
	}
	
}
