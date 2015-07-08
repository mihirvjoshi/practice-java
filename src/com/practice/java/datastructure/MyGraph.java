package com.practice.java.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyGraph {

	List<Node> vertices; 
	
	MyGraph() {
		this.vertices = new LinkedList<Node>();
	}
	
	public void addEdges(int src, int dest) {
		Node source = new Node(src);
		Node destination = new Node(dest);
		
		if(this.vertices.contains(source)){
			source = this.vertices.get(this.vertices.indexOf(source));	
			source.getEdges().add(destination);
		} else {
			source.addEdge(destination);
			this.vertices.add(source);	
		}
		
		if(this.vertices.contains(destination)){
			destination = this.vertices.get(this.vertices.indexOf(destination));	
			destination.getEdges().add(source);
		} else {
			destination.addEdge(source);
			this.vertices.add(destination);	
		}
	}
	
	public void print() {
		
		String edges = null;
		for (Iterator iterator = this.vertices.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			System.out.println("Adjacency list of vertex  :" + node.getData());
			edges = "head -> " ;
			for (Iterator iterator2 = node.getEdges().iterator(); iterator2.hasNext();) {
				Node edge = (Node) iterator2.next();	
				edges = edges + edge.getData() + " -> ";
			}
			System.out.println(edges);
		}
	}
	
	public void finShortestPath(int src, int dest) {
		Node source = new Node(src);
		Node destination =  new Node(dest);
		
		
	}
	
	
	public static void main(String args[]) {
		MyGraph graph = new MyGraph();
		graph.addEdges(0, 1);
		graph.addEdges(0, 4);
		graph.addEdges(1, 2);
		graph.addEdges(1, 3);
		graph.addEdges(1, 4);
		
		graph.print();
		
		System.out.println("===================================");
		
		MyGraph graph2 = new MyGraph();
		graph2.addEdges(1, 2);
		graph2.addEdges(2, 3);
		graph2.addEdges(3, 4);
		graph2.addEdges(4, 1);
		graph2.addEdges(1, 3);
		
		graph2.print();
	}
	
	
	class Node {
		Object data;
		List<Node> edges;
		
		Node(Object data) {
			this.data = data;
			this.edges = new LinkedList<Node>();
		}
		
		Node(Object data, List<Node> edges) {
			this.data = data;
			this.edges = edges;
		}
		
		public void addEdge(Node edgeNode) {
			this.edges.add(edgeNode);
		}
		
		public Object getData(){
			return this.data;
		}
		
		public List<Node> getEdges() {
			return this.edges;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((edges == null) ? 0 : edges.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			return true;
		}

		private MyGraph getOuterType() {
			return MyGraph.this;
		}
	}
	
}
