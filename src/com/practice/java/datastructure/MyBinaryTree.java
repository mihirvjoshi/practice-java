package com.practice.java.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * A BinaryTree consists of "nodes"--each "node" is itself a BinaryTree.
 * Each node has a parent (unless it is the root), may have a left child,
 * and may have a right child. This class implements loop-free binary trees,
 * allowing shared subtrees.
 */
public class MyBinaryTree {
    /**
     * The value (data) in this node of the binary tree; may be of
     * any object type.
     */
    public int value;
    private MyBinaryTree leftChild;
    private MyBinaryTree rightChild;

    /**
     * Constructor for BinaryTree.
     * 
     * @param value The value to be placed in the root.
     * @param leftChild The left child of the root (may be null).
     * @param rightChild The right child of the root (may be null).
     */
    public MyBinaryTree(int value, MyBinaryTree leftChild, MyBinaryTree rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Constructor for a BinaryTree leaf node (that is, with no children).
     * 
     * @param value The value to be placed in the root.
     */
    public MyBinaryTree(int value) {
        this(value, null, null);
    }

    
    /**
     * Getter method for the value in this BinaryTree node.
     * 
     * @return The value in this node.
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Getter method for left child of this BinaryTree node.
     * 
     * @return The left child (<code>null</code> if no left child).
     */
    public MyBinaryTree getLeftChild() {
        return leftChild;
    }
    
    /**
     * Getter method for right child of this BinaryTree node.
     * 
     * @return The right child (<code>null</code> if no right child).
     */
    public MyBinaryTree getRightChild() {
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
    public void setLeftChild(MyBinaryTree subtree) throws IllegalArgumentException {
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
    public void setRightChild(MyBinaryTree subtree) throws IllegalArgumentException {
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
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Tests whether this node is a leaf node.
     * 
     * @return <code>true</code> if this BinaryTree node has no children.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
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
        if (o == null || !(o instanceof MyBinaryTree)) {
            return false;
        }
        MyBinaryTree otherTree = (MyBinaryTree) o;
        return equals(value, otherTree.value)
            && equals(leftChild, otherTree.getLeftChild())
            && equals(rightChild, otherTree.getRightChild());
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
    protected boolean contains(MyBinaryTree tree, MyBinaryTree targetNode) {
        if (tree == null)
            return false;
        if (tree == targetNode)
            return true;
        return contains(targetNode, tree.getLeftChild())
            || contains(targetNode, tree.getRightChild());
    }
    
    /**
     * Returns a String representation of this BinaryTree.
     * 
     * @see java.lang.Object#toString()
     * @return A String representation of this BinaryTree.
     */
    public String toString() {
        if (isLeaf()) {
            return String.valueOf(value);
        }
        else {
            String root, left = "null", right = "null";
            root = String.valueOf(value);
            if (getLeftChild() != null) {
                left = getLeftChild().toString();
            }
            if (getRightChild() != null) {
                right = getRightChild().toString();
            }
            return root + " (" + left + ", " + right + ")";
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
        int result = value;
        if (leftChild != null) {
            result += 3 * leftChild.hashCode();
        }
        if (rightChild != null) {
            result += 7 * leftChild.hashCode();
        }
        return result;
    }
    
    /**
     * Prints the binary tree rooted at this BinaryTree node.
     */
    public void print() {
        print(this, 0);
    }
    
    private void print(MyBinaryTree root, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
        
        if (root == null) {
            System.out.println("null");
            return;
        }
        
        System.out.println(root.value);
        if (root.isLeaf()) return;
        print(root.leftChild, indent + 1);
        print(root.rightChild, indent + 1);
    }
    
	public void calculateDistance(MyBinaryTree root, int distance, Map<Object, List<Object>> map) {
		MyBinaryTree current = root;	
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
	
	/**
	 * Symmetric tree is the one which if cut from the middle and folded then will look same.
	 * @param root
	 */
	public boolean isSymmetricTreeNonRecursive(MyBinaryTree root){

		Queue<MyBinaryTree> queueLeft = new LinkedList<MyBinaryTree>();
		Queue<MyBinaryTree> queueRight = new LinkedList<MyBinaryTree>();

		MyBinaryTree left = root.leftChild;
		MyBinaryTree right = root.rightChild;
		
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

	public boolean isSymmetricTreeRecursive(MyBinaryTree left, MyBinaryTree right){
		
		if(right!=null && left!=null) {
			if(left.value==right.value 
					&& isSymmetricTreeRecursive(left.rightChild,right.leftChild) 
					&& isSymmetricTreeRecursive(left.leftChild, right.rightChild)){
				return true;
			} else return false;				
		} else if (left==null && right == null) return true;
		else return false;		
	}

	public boolean isBST(MyBinaryTree root) {
		MyBinaryTree current = root;
		
		if(current==null) return true;
		
		if(current.leftChild != null && current.rightChild != null) {
			int center = (Integer) current.value;
			int left = (Integer) current.leftChild.value;
			int right = (Integer) current.rightChild.value;
			
			if(left < center && center < right && isBST(current.leftChild) && isBST(current.rightChild)) return true;
			else return false;
		} else return true;
	}
	
	public int[] findSecondHighestNode(MyBinaryTree tree, int[] pair){
//		int[] pair=new int[2];
		if(tree==null) return new int[2];
		else{
			int root=0, left=0, right=0, max=0;
			int[] leftpair=findSecondHighestNode(tree.leftChild, pair);
			int[] rightpair=findSecondHighestNode(tree.rightChild, pair);			
			root=tree.value;
			if(tree.leftChild!=null){
				left=tree.leftChild.value;
			}
			if(tree.rightChild!=null){
				right=tree.rightChild.value;
			}
			max=Math.max(left, root);
		}
		return pair;
	}
	
	private void compareAndSwap(int a, int b, int[] pair){
		if(a>b){
			pair[0]=b;//second highest.
			pair[1]=a;
		} else{
			pair[0]=a;//second highest.
			pair[1]=b;
		}
	}
	
    public static void main(String args[]) {
    	MyBinaryTree tree9 = new MyBinaryTree(9);
    	MyBinaryTree tree8 = new MyBinaryTree(8);
    	MyBinaryTree tree7 = new MyBinaryTree(7);
    	MyBinaryTree tree6 = new MyBinaryTree(6);
    	MyBinaryTree tree5 = new MyBinaryTree(5);
    	MyBinaryTree tree4 = new MyBinaryTree(4);
    	MyBinaryTree tree3 = new MyBinaryTree(3);
    	MyBinaryTree tree2 = new MyBinaryTree(2);
    	MyBinaryTree tree1 = new MyBinaryTree(1);
    	
    	tree6.setRightChild(tree8);
    	tree7.setRightChild(tree9);
    	
    	tree3.setLeftChild(tree6);
    	tree3.setRightChild(tree7);
    	
    	tree2.setLeftChild(tree4);
    	tree2.setRightChild(tree5);
    	
    	tree1.setLeftChild(tree2);
    	tree1.setRightChild(tree3);
    	
    	tree1.print();
    	int[] pair=tree1.findSecondHighestNode(tree1, new int[2]);
    	System.out.println(pair[0]+"====>"+pair[1]);
//    	System.out.println(tree1.contains(tree3, tree3));
    	
    	System.out.println(tree1.isBST(tree1));
//    	Map<Object, List<Object>> map = new TreeMap<Object, List<Object>>();
//    	tree1.calculateDistance(tree1, 0, map);

//        Iterator<?> it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
//        }
    	
    	
    	/**
    	 * This instantiation is for the asymmetric tree test
    	 */
//    	MyBinaryTree tree1 = new MyBinaryTree(1);
//
//    	MyBinaryTree tree6L = new MyBinaryTree(6);
//    	MyBinaryTree tree5L = new MyBinaryTree(5);
//    	MyBinaryTree tree4L = new MyBinaryTree(4);
//    	MyBinaryTree tree3L = new MyBinaryTree(3);
//    	MyBinaryTree tree2L = new MyBinaryTree(2);
//
//    	tree3L.setLeftChild(tree5L);
//    	tree3L.setRightChild(tree6L);
//    	
//    	tree2L.setLeftChild(tree3L);
//    	tree2L.setRightChild(tree4L);
//    	
//    	tree1.setLeftChild(tree2L);
//    	
//    	MyBinaryTree tree6R = new MyBinaryTree(6);
//    	MyBinaryTree tree5R = new MyBinaryTree(5);
//    	MyBinaryTree tree4R = new MyBinaryTree(4);
//    	MyBinaryTree tree3R = new MyBinaryTree(3);
//    	MyBinaryTree tree2R = new MyBinaryTree(2);    	
//
//    	tree3R.setLeftChild(tree6R);
//    	tree3R.setRightChild(tree5R);
//    	
//    	tree2R.setLeftChild(tree4R);
//    	tree2R.setRightChild(tree3R);
//    	
//    	tree1.setRightChild(tree2R);    	
//    	tree1.print();
//    	System.out.println(tree1.isSymmetricTreeNonRecursive(tree1));
//    	System.out.println(tree1.isSymmetricTreeRecursive(tree1.leftChild, tree1.rightChild));    	
    }
}