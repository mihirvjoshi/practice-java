package com.practice.java.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {

	private Node root;	
	
	private MyBinarySearchTree(Node root){ this.root=root;}
	
	private MyBinarySearchTree(int data) { 
		this.root = new Node(data);
	}
	
	public void insertNode(int leaf) {
		Node current = this.root;
		Node newNode = new Node(leaf);
		
		if(this.root == null) {
			this.root = newNode;
			return;
		}
		
		while(current != null){
			if(leaf > current.data){
				if(current.right != null){
					current = current.right;
				} else {
					current.right = newNode;
					break;
				}
			} else if(leaf < current.data){
				if(current.left != null){
					current = current.left;
				} else {
					current.left = newNode;
					break;
				}
			}  
		}
	}
	
	public void deleteNode(int node) {
	
		Node current = this.root;
		Node deleteNode = new Node(node);
		Node previous = null;
		
		while(current != null) {
			previous = current;
			if(current.data == deleteNode.data) {				
				Node maxRightNode = findExtremeRight(current.right);
				Node lastNullLeftOfMax = findExtremeLeft(maxRightNode.left); //last left node of highest right node 
				Node rightOfCurrent = current.right;
				lastNullLeftOfMax.left = rightOfCurrent; //re-arrange current's(node to be deleted) right node to the left side of highest node
				Node lastNullLeftOfCurrent = findExtremeLeft(rightOfCurrent);
				lastNullLeftOfCurrent.left = current.left;
			} else if(deleteNode.data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
	}
	
	private Node findExtremeRight(Node right){
		while(right.right != null) {
			right = right.right;
		}		
		return right;
	}
	
	private Node findExtremeLeft(Node left){
		while(left.left != null) {
			left = left.left;
		}		
		return left;
	}
	
	public void preorderTraverse(Node root){
		Node current = root;		
		if(current != null) {
			System.out.print(current.data + ",");
			preorderTraverse(current.left);
			preorderTraverse(current.right);
		}
	}

	public void inorderTraverse(Node root){
		Node current = root;		
		if(current != null) {
			inorderTraverse(current.left);
			System.out.print(current.data + ",");
			inorderTraverse(current.right);
		}
	}
	
	public void inorderTraverseTwoTrees(Node root1, Node root2){
		Node current1 = root1;
		Node current2 = root2;
		
		if(current1 != null) {
			inorderTraverseTwoTrees(current1.left, current2.left);
			System.out.print(current1.data + "," + current2.data + ",");
			inorderTraverseTwoTrees(current1.right, current2.right);
		}
	}

	public void breadFirstTraverse(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		Node current = root;
		queue.add(current);
		while(queue.size() > 0) {			
			current = queue.remove();
			if(current != null){
				System.out.println(current.data);
				queue.add(current.left);
				queue.add(current.right);
			}
		}			
	}
	
	public boolean isBinarySearchTree(Node root) {
		boolean isLeftOk = false;
		boolean isRightOk = false;
		
		if(root == null) return true; //null node should return true since that doesn't need to be checked for < or > values.
		
		isLeftOk = isBinarySearchTree(root.left);
		isRightOk = isBinarySearchTree(root.right);
		
		if(isLeftOk && isRightOk) return true;
		return false;
	}
	
	public Node convertToMirrorTree(Node data) {
		Node mirrorTree = data;
		System.out.println(data.data);
		
		if(data != null) {
			Node temp = new Node(data.data);
			temp.left = convertToMirrorTree(data.right);
			temp.right = convertToMirrorTree(data.left);
			mirrorTree =  temp;
		}
		
		return mirrorTree;		
	}
	
	
	public MyBinarySearchTree convertsortedArrayToBST(int[] array, int start, int end){
		
		MyBinarySearchTree bst = new MyBinarySearchTree(array[0]);
		
		
		
		return null;		
	}
	
	class Node {
		int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String args[]){
//		MyBinarySearchTree tree = new MyBinarySearchTree(6);
//		tree.insertNode(4);
//		tree.insertNode(10);
//		tree.insertNode(5);
//		tree.insertNode(3);
//		tree.insertNode(2);
//		tree.insertNode(7);
		
		
//		System.out.println(tree.isBinarySearchTree(tree.root));
//		tree.preorderTraverse(tree.root);
//		System.out.println();
//		tree.inorderTraverse(tree.root);
//		System.out.println();
		
//		Node mirrorNode = tree.mirror(tree.root);
//		tree.inorderTraverse(mirrorNode);
//		tree.breadFirstTraverse(tree.root);

		//======================= Testing for printing two BST alternately =======================
		MyBinarySearchTree tree1 = new MyBinarySearchTree(6);
		tree1.insertNode(4);
		tree1.insertNode(10);
		tree1.insertNode(5);
		tree1.insertNode(3);
		tree1.insertNode(2);
		tree1.insertNode(7);

		MyBinarySearchTree tree2 = new MyBinarySearchTree(60);
		tree2.insertNode(40);
		tree2.insertNode(100);
		tree2.insertNode(50);
		tree2.insertNode(30);
		tree2.insertNode(20);
		tree2.insertNode(70);
		
		tree1.inorderTraverseTwoTrees(tree1.root, tree2.root);
		//==================================================================================================

	}
}
