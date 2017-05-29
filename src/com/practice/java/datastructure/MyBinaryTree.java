package com.practice.java.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * A BinaryTree consists of "nodes"--each "node" is itself a BinaryTree.
 * Each node has a parent (unless it is the root), may have a left child,
 * and may have a right child. This class implements loop-free binary trees,
 * allowing shared subtrees.
 */
public class MyBinaryTree {
	
	Node root;
	
	public MyBinaryTree(Node root) {
		this.root=root;
	}
	
	public MyBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	class Node{
	    /**
	     * The value (data) in this node of the binary tree; may be of
	     * any object type.
	     */
	    public Object value;
	    private Node leftChild;
	    private Node rightChild;

	    /**
	     * Constructor for BinaryTree.
	     * 
	     * @param value The value to be placed in the root.
	     * @param leftChild The left child of the root (may be null).
	     * @param rightChild The right child of the root (may be null).
	     */
	    public Node(Object value, Node leftChild, Node rightChild) {
	        this.value = value;
	        this.leftChild = leftChild;
	        this.rightChild = rightChild;
	    }

	    /**
	     * Constructor for a BinaryTree leaf node (that is, with no children).
	     * 
	     * @param value The value to be placed in the root.
	     */
	    public Node(Object value) {
	        this(value, null, null);
	    }

	    /**
	     * Getter method for the value in this BinaryTree node.
	     * 
	     * @return The value in this node.
	     */
	    public Object getValue() {
	        return value;
	    }
	    
		/**
	     * Getter method for left child of this BinaryTree node.
	     * 
	     * @return The left child (<code>null</code> if no left child).
	     */
	    public Node getLeftChild() {
	        return leftChild;
	    }
	    
	    /**
	     * Getter method for right child of this BinaryTree node.
	     * 
	     * @return The right child (<code>null</code> if no right child).
	     */
	    public Node getRightChild() {
	        return rightChild;
	    }

	    /**
	     * Sets the left child of this BinaryTree node to be the
	     * given subtree. If the node previously had a left child,
	     * it is discarded. Throws an <code>IllegalArgumentException</code>
	     * if the operation would cause a loop in the binary tree.
	     * 
	     * @param subtree The node to be added as the new left child.
	     * @throws IllegalArgumentException If the operation would cause
	     *         a loop in the binary tree.
	     */
	    public void setLeftChild(Node subtree) throws IllegalArgumentException {
	        if (contains(subtree, this)) {
	            throw new IllegalArgumentException(
	                "Subtree " + this +" already contains " + subtree);
	        }
	        leftChild = subtree;
	    }

	    /**
	     * Sets the right child of this BinaryTree node to be the
	     * given subtree. If the node previously had a right child,
	     * it is discarded. Throws an <code>IllegalArgumentException</code>
	     * if the operation would cause a loop in the binary tree.
	     * 
	     * @param subtree The node to be added as the new right child.
	     * @throws IllegalArgumentException If the operation would cause
	     *         a loop in the binary tree.
	     */
	    public void setRightChild(Node subtree) throws IllegalArgumentException {
	        if (contains(subtree, this)) {
	            throw new IllegalArgumentException(
	                    "Subtree " + this +" already contains " + subtree);
	        }
	        rightChild = subtree;
	    }

	    /**
	     * Sets the value in this BinaryTree node.
	     * 
	     * @param value The new value.
	     */
	    public void setValue(Object value) {
	        this.value = value;
	    }

	}

    
    /**
     * Tests whether this node is a leaf node.
     * 
     * @return <code>true</code> if this BinaryTree node has no children.
     */
    public boolean isLeaf() {
        return root.leftChild == null && root.rightChild == null;
    }
    
    /**
     * Tests whether this BinaryTree is equal to the given object.
     * To be considered equal, the object must be a BinaryTree,
     * and the two binary trees must have equal values in their
     * roots, equal left subtrees, and equal right subtrees.
     * 
     * @return <code>true</code> if the binary trees are equal.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Node)) {
            return false;
        }
        Node otherTree = (Node) o;
        return equals(root.value, otherTree.value)
            && equals(root.leftChild, otherTree.getLeftChild())
            && equals(root.rightChild, otherTree.getRightChild());
    }
    
    /**
     * Tests whether its two arguments are equal.
     * This method simply checks for <code>null</code> before
     * calling <code>equals(Object)</code> so as to avoid possible
     * <code>NullPointerException</code>s.
     * 
     * @param x The first object to be tested.
     * @param y The second object to be tested.
     * @return <code>true</code> if the two objects are equal.
     */
    private boolean equals(Object x, Object y) {
        if (x == null) return y == null;
        return x.equals(y);
    }

    /**
     * Tests whether the <code>tree</code> argument contains within
     * itself the <code>targetNode</code> argument.
     * 
     * @param tree The root of the binary tree to search.
     * @param targetNode The node to be searched for.
     * @return <code>true</code> if the <code>targetNode</code> argument can
     *        be found within the binary tree rooted at <code>tree</code>.
     */
    protected boolean contains(Node tree, Node targetNode) {
        if (tree == null)
            return false;
        if (tree == targetNode)
            return true;
        return contains(targetNode, tree.getLeftChild())
            || contains(targetNode, tree.getRightChild());
    }
    
    /**
     * 
     */
    public boolean areCousins(Node n1, Node n2){
    	Queue q=new LinkedList();
    	Node current = root;
    	q.add(current);
    	q.add("#");
    	while(q.size()>0){
//    		if(q.)
    	}
    	
    	return true;
    }
    
    
    /**
     * Returns a String representation of this BinaryTree.
     * 
     * @see java.lang.Object#toString()
     * @return A String representation of this BinaryTree.
     */
    public String toString() {
        if (isLeaf()) {
            return root.value.toString();
        }
        else {
            String rootStr, left = "null", right = "null";
            rootStr = root.value.toString();
            if (root.getLeftChild() != null) {
                left = root.getLeftChild().toString();
            }
            if (root.getRightChild() != null) {
                right = root.getRightChild().toString();
            }
            return rootStr + " (" + left + ", " + right + ")";
        }
    }
    
    /**
     * Computes a hash code for the complete binary tree rooted
     * at this BinaryTree node.
     * 
     * @return A hash code for the binary tree with this root.
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        int result = root.value.hashCode();
        if (root.leftChild != null) {
            result += 3 * root.leftChild.hashCode();
        }
        if (root.rightChild != null) {
            result += 7 * root.leftChild.hashCode();
        }
        return result;
    }
    
    /**
     * Prints the binary tree rooted at this BinaryTree node.
     */
    public void print() {
        print(this.root, 0);
    }
    
    private void print(Node root, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
        
        if (root == null) {
            System.out.println("null");
            return;
        }
        
        System.out.println(root.value);
        if (isLeaf()) return;
        print(root.leftChild, indent + 1);
        print(root.rightChild, indent + 1);
    }
    
	public void calculateDistance(Node root, int distance, Map<Object, List<Object>> map) {
		Node current = root;	
		int currentDistance = distance;
		List<Object> nodeList = new ArrayList<Object>(); 
		
		if(current != null) {
			if(map.containsKey(distance)){
				nodeList = map.get(distance);
			}
			nodeList.add(current.value);
			map.put(distance, nodeList);
			calculateDistance(current.leftChild, --distance, map);
			distance  = currentDistance;
			calculateDistance(current.rightChild, ++distance, map);
		}		
	}
	
	public void verticalTraverse(Node root){
		Map<Integer, List<Integer>> levelMap = new TreeMap<Integer, List<Integer>>();
		verticalTraverse(root, levelMap, 0);
		System.out.println("Printing in top view order:");
		printVerticalOrTopViewOrder(levelMap, true);
		System.out.println("Printing in vertical order:");
		printVerticalOrTopViewOrder(levelMap, false);
	}

	private void printVerticalOrTopViewOrder(
			Map<Integer, List<Integer>> levelMap, boolean isTopView) {
		
		for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
			Integer key = entry.getKey();
			List<Integer> values = entry.getValue();

			if(isTopView)
				System.out.println(key + " => " + values.get(0));
			else{
				for (Integer integer : values) {
					System.out.println(key + " => " + integer);
				}
			}
		}
	}
	
	private void verticalTraverse(Node root, Map<Integer, List<Integer>> levelMap, int level){
		if(root==null) return;
		int leftLevel=level-1;
		int rightLevel=level+1;
		List<Integer> levelList;
		if(levelMap.get(level)!=null){
			levelList=levelMap.get(level);
		}else{
			levelList=new ArrayList<Integer>(10);
		}
		levelList.add((Integer) root.value);
		levelMap.put(level, levelList);
		verticalTraverse(root.leftChild, levelMap, leftLevel);
		verticalTraverse(root.rightChild, levelMap, rightLevel);
		
	}
	/**
	 * Symmetric tree is the one which if cut from the middle and folded then will look same.
	 * @param root
	 */
	public boolean isSymmetricTreeNonRecursive(Node root){

		Queue<Node> queueLeft = new LinkedList<Node>();
		Queue<Node> queueRight = new LinkedList<Node>();

		Node left = root.leftChild;
		Node right = root.rightChild;
		
		queueLeft.add(left);
		queueRight.add(right);
		
		while(!queueLeft.isEmpty() && !queueRight.isEmpty()){
				left = queueLeft.poll();
				right = queueRight.poll();				
				if(left != null && right != null && left.value == right.value) {
					System.out.println("left is " + left.value + " right is " + right.value);
					queueLeft.add(left.leftChild);
					queueLeft.add(left.rightChild);
					queueRight.add(right.rightChild);
					queueRight.add(right.leftChild);
				} else if(left == null &&  right == null) return true; 
				else return false;
		}
		return false;
	}

	public boolean isSymmetricTreeRecursive(Node left, Node right){
		if(right!=null && left!=null) {
			if(left.value==right.value 
					&& isSymmetricTreeRecursive(left.rightChild,right.leftChild) 
					&& isSymmetricTreeRecursive(left.leftChild, right.rightChild)){
				return true;
			} else return false;				
		} else if (left==null && right == null) return true;
		  else return false;		
	}

	public static boolean isBST(Node root) {
		Node current = root;
		if(current==null) return true;
		if(current.leftChild != null && current.rightChild != null) {
			int center = (Integer) current.value;
			int left = (Integer) current.leftChild.value;
			int right = (Integer) current.rightChild.value;
			if(left < center && center < right && isBST(current.leftChild) && isBST(current.rightChild)) return true;
			else return false;
		} else return true;
	}

	public static boolean isIncorrectBSTImplementation(Node root) {
		boolean isLeftOk = false;
		boolean isRightOk = false;
		
		if(root == null) return true; //null node should return true since that doesn't need to be checked for < or > values.
		
		isLeftOk = isIncorrectBSTImplementation(root.leftChild);
		isRightOk = isIncorrectBSTImplementation(root.rightChild);
		
		if(isLeftOk && isRightOk) return true;
		return false;
	}
	
	public void printInternalNodes(Node root) {
		
	}
	
	
    public static void main(String args[]) {
/*    	MyBinaryTree tree = setTree();
    	System.out.println(tree.isBST(tree));
*/    	
/*    	MyBinaryTree nonBST = new MyBinaryTree(); 
    	nonBST.setAnotherTree();
    	System.out.println(isBST(nonBST.root));//fail case: should return false
    	System.out.println(isIncorrectBSTImplementation(nonBST.root));
*/    
    	MyBinaryTree verticalTraverseTree = new MyBinaryTree(); 
    	verticalTraverseTree=verticalTraverseTree.setTree4VerticalTraverse();
    	verticalTraverseTree.verticalTraverse(verticalTraverseTree.root);
    }

    private MyBinaryTree setTree4VerticalTraverse(){    
    	Node root = new Node(1);
    	Node node2 = new Node(2);
    	Node node3 = new Node(3);
    	Node node4 = new Node(4);
    	Node node5 = new Node(5);
    	Node node6 = new Node(6);
    	Node node7 = new Node(7);
    	Node node8 = new Node(8);
    	
    	root.setLeftChild(node2);
    	root.setRightChild(node3);
    	
    	node2.setLeftChild(node4);
    	node2.setRightChild(node5);
    	node3.setLeftChild(node6);
    	node3.setRightChild(node7);
    	
    	node7.setRightChild(node8);
		return new MyBinaryTree(root);
    }
    
	private MyBinaryTree setAnotherTree() {
		Node tree7 = new Node(7);
    	Node tree6 = new Node(6);
    	Node tree5 = new Node(5);
    	Node tree4 = new Node(4);
    	Node tree3 = new Node(3);
    	Node tree2 = new Node(2);
    	Node tree1 = new Node(1);
    	
    	//create subtree 3
    	tree3.setLeftChild(tree2);
    	tree3.setRightChild(tree5);
    	
    	//assign subtree3 to left of 4.
    	tree4.setLeftChild(tree1);
    	tree4.setRightChild(tree3);
    	
    	//set root
    	tree6.setLeftChild(tree4);
    	tree6.setRightChild(tree7);
	
    	MyBinaryTree tree=new MyBinaryTree(tree6);
    	return tree;
	}

	private MyBinaryTree setBST() {
		Node tree7 = new Node(7);
    	Node tree6 = new Node(6);
    	Node tree5 = new Node(5);
    	Node tree4 = new Node(4);
    	Node tree3 = new Node(3);
    	Node tree2 = new Node(2);
    	Node tree1 = new Node(1);
    	
    	//create subtree 3
    	tree4.setLeftChild(tree2);
    	tree4.setRightChild(tree5);
    	
    	//assign subtree3 to left of 4.
    	tree3.setLeftChild(tree1);
    	tree3.setRightChild(tree4);
    	
    	tree6.setLeftChild(tree4);
    	tree6.setRightChild(tree7);
    	
    	MyBinaryTree tree=new MyBinaryTree(tree6);
    	return tree;
	}
	
	private MyBinaryTree setTree() {
		Node tree9 = new Node(9);
    	Node tree8 = new Node(8);
    	Node tree7 = new Node(7);
    	Node tree6 = new Node(6);
    	Node tree5 = new Node(5);
    	Node tree4 = new Node(4);
    	Node tree3 = new Node(3);
    	Node tree2 = new Node(2);
    	Node tree1 = new Node(1);
    	
    	tree6.setRightChild(tree8);
    	tree7.setRightChild(tree9);
    	
    	tree3.setLeftChild(tree6);
    	tree3.setRightChild(tree7);
    	
    	tree2.setLeftChild(tree4);
    	tree2.setRightChild(tree5);
    	
    	tree1.setLeftChild(tree2);
    	tree1.setRightChild(tree3);
    	
    	MyBinaryTree tree=new MyBinaryTree(tree1);
    	return tree;
	}
}