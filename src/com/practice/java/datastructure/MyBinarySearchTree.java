package com.practice.java.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.practice.java.datastructure.MyBinaryTree.Node;

public class MyBinarySearchTree {
	private Node root;	
	
	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	class Node {
		int data;
		private Node left;
		private Node right;
		private Node prev; //extra node for inorder traversal without recursion & stack.
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.prev = null;
		}
	}
	
	static class ListNode{
		int data;
		ListNode next;
		ListNode prev;
		ListNode(int data){
			this.data=data;
			this.next=null;
			this.prev=null;
		}
		ListNode(int data, ListNode next, ListNode prev){
			this.data=data;
			this.next=next;
			this.prev=prev;
		}
	}
	
	private MyBinarySearchTree(Node root){ this.root=root;}
	private MyBinarySearchTree(int data) { 
		this.root = new Node(data);
	}
	
	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	/* Function to insert data recursively */
	private Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else {
			if (data <= node.data)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
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
	
	public void printNonBoundaryNodesNonRec(Node root){
		Queue q = new LinkedList(); boolean start=false; boolean end=false;
		Node current=(Node) root;
		q.add("#");
		q.add(current.left);
		q.add(current.right);
		while(q.size()>0){
			start=false;
			Object obj = q.poll();
			if (obj != null && obj.equals("#")) {
				obj=q.poll(); // skip one more element next to # which is outer node
				start=true;
				end=false;
				q.add("#");
			}
			if(obj != null && q.peek()!=null && q.peek().equals("#")){
				end=true;
			}
			current=(Node) obj;
			q.add(current.left);
			q.add(current.right);
			if(end){
				q.add("#");
			}
			if (!start && !end && current.left != null && current.right != null) {
				System.out.println("Inside node =>" + current.data);
			}
		}
	}
	
	private void printNonBoundaryNodesRec(Node root, boolean goneLeft, boolean goneRight) {
	    if (root == null || (root.left==null && root.right==null)) return;

	    if (goneLeft && goneRight) System.out.println(root.data); 
	    printNonBoundaryNodesRec(root.left, true, goneRight);
	    printNonBoundaryNodesRec(root.right, goneLeft, true);
	}

	public void printNonBoundaryNodes(Node root) {
	    printNonBoundaryNodesRec(root, false, false);
	}
	
	/* Functions to delete data */
	public void delete(int k) {
		if (isEmpty())
			System.out.println("Tree Empty");
		else if (search(k) == false)
			System.out.println("Sorry " + k + " is not present");
		else {
			root = delete(root, k);
			System.out.println(k + " deleted from the tree");
		}
	}
	
	private Node delete(Node root, int k) {
		Node p, p2, n;
		if (root.data == k) {
			Node lt, rt;
			lt = root.left;
			rt = root.right;
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.left != null)
					p = p.left;
				p.left=lt;
				return p2;
			}
		}
		if (k < root.left.data) {
			n = delete(root.left, k);
			root.left=(n);
		} else {
			n = delete(root.right, k);
			root.right=n;
		}
		return root;
	}

	/* Functions to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}

	/* Function to search for an element recursively */
	private boolean search(Node r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.data;
			if (val < rval)
				r = r.left;
			else if (val > rval)
				r = r.right;
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
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

	public Queue<Integer> serialize(Node root, Queue<Integer> queue){
		Node current = root;
		if(current != null) {
			queue.add(current.data);
//			System.out.print(current.data + ",");
			serialize(current.left, queue);
			serialize(current.right, queue);
		}
		return queue;
	}

	public int maxSumOfPathFromLeafToRoot(Node root){
		if(root==null)return 0;
		int leftSum = maxSumOfPathFromLeafToRoot(root.left);
		int rightSum = maxSumOfPathFromLeafToRoot(root.right);
		
		return root.data + Math.max(leftSum, rightSum);
	}
		
	public int height(Node root) {
		if(root==null) return 0;
		else {
			int left = height(root.left);
			int right = height(root.right);
			return (1 + Math.max(left, right));
		}
	}
	
	public int diameter(Node root) {
		int leftHeight=0, rightHeight=0;
		if(root==null) return 0;
		else {
			int ldiameter = diameter(root.left);
			int rdiameter = diameter(root.right);
			if(root.left!=null)
				leftHeight = root.left.data + 1;
			if(root.right!=null)
				rightHeight = root.right.data + 1;
			int currentDiameter = leftHeight + rightHeight + 1 ;
			int maxDiameter = Math.max(currentDiameter , Math.max(rdiameter, ldiameter));
			System.out.println("root=>"+root.data+"currentDiameter=>"+currentDiameter+" maxDiameter=>"+maxDiameter);
			return maxDiameter;
		}
	}

	public Node deserialize(Queue<Integer> data){		
		if(data==null || data.size()==0) return null;
		else{
			Node root;
			Queue<Integer> newLeftQueue=new LinkedList<Integer>();
			Queue<Integer> newRightQueue=new LinkedList<Integer>();
			int currentLeft=data.poll();
			root=new Node(currentLeft);
			if(data != null && data.size()>0){
				currentLeft = data.poll();
				while(root.data > currentLeft && data != null && data.size()>0){
					newLeftQueue.add(currentLeft);
					currentLeft=(int) data.poll();			
				}
				int currentRight=currentLeft;	
				while(root.data < currentRight && data!=null && data.size()>0){
					newRightQueue.add(currentRight);
					currentRight=(int) data.poll();
				}
				newRightQueue.add(currentRight);
				root.left=deserialize(newLeftQueue);
				root.right=deserialize(newRightQueue);
			}
		}
		return root;
	}

	
	public void postorderTraverse(Node root){
		Node current = root;		
		if(current != null) {
			postorderTraverse(current.left);
			postorderTraverse(current.right);
			System.out.print(current.data + ",");
		}
	}

	public void preorderTraverseWithoutRecursion(Node root){
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue=new LinkedList<Node>();
		System.out.println(root.data);
		processLeftTree4PreOrder(root.left, stack);
		processRightTree4PreOrder(root.right, queue);			
	}

	private void processLeftTree4PreOrder(Node left, Stack<Node> stack){
		Node current=left; 
		Queue<Node> rightStack=new LinkedList<Node>();
		if(current!=null){
			while(current!=null){
				System.out.println(current.data);
				stack.push(current);
				current=current.left;
			}	

			while(!stack.isEmpty()){
				current=stack.pop();
				processRightTree4InOrder(current.right, rightStack);
			}
		}
	}
	
	private void processRightTree4PreOrder(Node right, Queue<Node> queue){
		Node current=right;Stack<Node> leftStack=new Stack<Node>();
		if(current!=null){
			while(current!=null){
				queue.add(current);
				current=current.right;
			}	
			while(!queue.isEmpty()){
				current=queue.poll();
				processLeftTree4InOrder(current.left,leftStack);
				System.out.println(current.data);
			}
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
	
	public void inorderTraverseWithoutRecursionAndStack(Node root){
		Node current = root;		
		if(current != null) {
			inorderTraverse(current.left);
			System.out.print(current.data + ",");
			inorderTraverse(current.right);
		}
	}

	private void processLeftTree4InOrder(Node left, Node root){
		Node current=left;
		Node prev=root;
		while(current != null){
			current.prev=prev;
			prev=current;
			current=current.left;
		}
	}
	
	private void processRightTree4InOrder(Node right, Node root){
		Node current=right;
		Node prev=root;
		while(current != null){
			current.prev=prev;
			prev=current;
			current=current.right;
		}
	}

	public void inorderTraverseWithoutRecursion(Node root){
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue=new LinkedList<Node>();
		processLeftTree4InOrder(root.left, stack);
		System.out.println(root.data);
		processRightTree4InOrder(root.right, queue);			
	}
	
	private void processLeftTree4InOrder(Node left, Stack<Node> stack){
		Node current=left; 
		Queue<Node> rightStack=new LinkedList<Node>();
		if (current != null) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			while (!stack.isEmpty()) {
				current = stack.pop();
				System.out.println(current.data);
				processRightTree4InOrder(current.right, rightStack);
			}
		}
	}
	
	private void processRightTree4InOrder(Node right, Queue<Node> queue){
		Node current=right;Stack<Node> leftStack=new Stack<Node>();
		if(current!=null){
			while(current!=null){
				queue.add(current);
				current=current.right;
			}	
			while(!queue.isEmpty()){
				current=queue.poll();
				processLeftTree4InOrder(current.left,leftStack);
				System.out.println(current.data);
			}
		}
	}

	public Node toDoublyLinkedList(Node root) {
		if (root == null)
			return root;
		Node left = toDoublyLinkedList(root.left);
		Node right = toDoublyLinkedList(root.right);
		return concatenateLists(left, root, right);
	}
	
	private Node concatenateLists(Node left, Node root, Node right){
		boolean hasChilderen=false;
		String print= "root :"; 
		print=print+root.data;		
		if(right != null){
			root.right=right;
			print=print+ " right: " + right.data;
		}
		if(left!=null){
			print=print+ " left: " + left.data;
			Node current = left;
			while(current.right != null){
				current = current.right;
			}
			current.right=root;
			hasChilderen=true;
		}
		System.out.println(print);
		if(hasChilderen) return left;
		else return root;
	}
	
	
	public void display(Node head) {
		System.out.println("Circular Linked List is :");
		Node itr = head;
		do {
			System.out.print(itr.data + " ");
			itr = itr.right;
		} while (itr != null);
		System.out.println();
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
		Map<Integer, List<Integer>> levelMap = new HashMap<Integer, List<Integer>>();
		Node current = root; Integer levelCounter = 1;
		queue.add(current);
		List<Integer> firstvalues =  new ArrayList<Integer>();
		firstvalues.add(Integer.valueOf(current.data));
		while(queue.size() > 0) {			
			current = queue.remove();
			List<Integer> values =  new ArrayList<Integer>();
			if(current != null){
				System.out.println(current.data);
				queue.add(current.left);
				queue.add(current.right);

				levelCounter++;
				values.add(current.left.data);
				values.add(current.right.data);
				levelMap.put(levelCounter,values);
			}
		}			
	}
	
	public void depthFirstTraverse(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		stack.add(current);
		while(stack.size() > 0) {			
			current = stack.pop();
			if(current != null){
				System.out.println(current.data);
				stack.add(current.right);
				stack.add(current.left);
			}
		}			
	}

	public void zedTraverse(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		Node current = root;
		queue.add(current);
		while(queue.size() > 0) {			
			current = queue.remove();
			if(current != null){
				System.out.println(current.data);
				queue.add(current.right);
				queue.add(current.left);
			}
		}			
	}

	public void zigZagTraverse(Node root) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		Node current = root;
		stack1.add(current);
		boolean isInProcess=true;
		while(isInProcess){
			while(stack1.size() > 0) {			
				current = stack1.pop();
				if(current != null){
					System.out.println(current.data);
					stack2.add(current.right);
					stack2.add(current.left);
				}
			}	
			while(stack2.size() > 0) {			
				current = stack2.pop();
				if(current != null){
					System.out.println(current.data);
					stack1.add(current.left);
					stack1.add(current.right);
				}
			}			
			if(stack1.size()==0 && stack2.size()==0){
				isInProcess = false;
			}
		}
	}

	
    /* Given two trees, return true if they are
    mirror of each other */
	boolean areMirror(Node a, Node b) {
		/* Base case : Both empty */
		if (a == null && b == null)
			return true;

		// If only one is empty
		if (a == null || b == null)
			return false;

		/*
		 * Both non-empty, compare them recursively Note that in recursive
		 * calls, we pass left of one tree and right of other tree
		 */
		return a.data == b.data && areMirror(a.left, b.right)
				&& areMirror(a.right, b.left);
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
	
	public Node convertToMirrorTreeNew(Node root){
		if(root == null) return root ;
		Node newRight = convertToMirrorTreeNew(root.left);
		Node newLeft = convertToMirrorTreeNew(root.right);
		root.left=newLeft;
		root.right=newRight;
		String str = "root=>" + root.data;
		if(newLeft!=null){
			str = str + " left=>" + newLeft.data ;					
		} 
		if(newRight!=null){
			str = str + " right=>" + newRight.data ;
		}
		System.out.println(str);
		return root;
	}

	private Object findSecondHighestNode(Node root, int[] a){
		a[0]=0;a[1]=0;			
		if(root == null) return 0;		
		if(a[0]<root.data || a[1]<root.data){			
		}
		return null;
	}

	private void findAllLeftNodes(Node root, List<Node> leftSet){
		while(root!=null){
			leftSet.add(root);
			root=root.left;
		}
	}
	
	private void findAllRightNodes(Node root, List<Node> rightSet){
		while(root!=null){
			rightSet.add(root);
			root=root.right;
		}
	}

	private void findAllLeafNodes(Node root, List<Node> leafSet){
		if(root==null) return;
		else{
			if(root.left==null && root.right==null){
				leafSet.add(root);
			}
			findAllLeafNodes(root.left, leafSet);
			findAllLeafNodes(root.right, leafSet);
		}
	}
	
	/**
	 * This method will return all the boundary nodes in anti-clockwise direction.
	 * @param root
	 */
	private void findAllBoundaryNodes(Node root){
		List<Node> boundaryNodes=new ArrayList<Node>(); 
		findAllLeftNodes(root, boundaryNodes);
		findAllLeafNodes(root, boundaryNodes);
		findAllRightNodes(root, boundaryNodes);
		
		printAllBoundaryNodes(boundaryNodes);
	}
	
	private void printAllBoundaryNodes(List<Node> boundaryNodes) {
		for (Iterator iterator = boundaryNodes.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			System.out.println("boundary node=>"+node.data);			
		}		
	}
	
	private static void setSerializeTree(MyBinarySearchTree tree4) {
		Queue<Integer> data = tree4.serialize(tree4.root, new LinkedList<Integer>());
		System.out.println("Searialized=>"+data.toString());
		System.out.println("================================================");
		tree4.root = tree4.deserialize(data);
		System.out.println("DeSearialized=>");
		tree4.preorderTraverse(tree4.root);
		System.out.println("height of tree is =>" + tree4.height(tree4.root));
		System.out.println("diameter of tree is =>" + tree4.diameter(tree4.root));
	}
	
	private static MyBinarySearchTree setTree() {
		MyBinarySearchTree tree4 = new MyBinarySearchTree(6);
		tree4.insertNode(3);
		tree4.insertNode(10);
		
		tree4.insertNode(1);
		tree4.insertNode(5);
		tree4.insertNode(2);
		tree4.insertNode(4);
		tree4.insertNode(8);
		tree4.insertNode(12);
		tree4.insertNode(11);
		tree4.insertNode(13);
		tree4.insertNode(14);
		return tree4;
	}
	
	public static void main(String args[]){
		MyBinarySearchTree tree4 = setTree();
//		serializeTree(tree4);
//		tree4.findAllBoundaryNodes(tree4.root);
		System.out.println(tree4.diameter(tree4.root));
		
/*		MyBinarySearchTree tree4 = new MyBinarySearchTree(10);
		tree4.insertNode(-2);
		tree4.insertNode(7);
		tree4.insertNode(-4);
		tree4.insertNode(8);
		tree4.insertNode(14);
		
		System.out.println(tree4.maxSumOfPathFromLeafToRoot(tree4.root));
*/		
	}
}
