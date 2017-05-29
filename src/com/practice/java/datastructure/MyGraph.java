package com.practice.java.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyGraph {
	Map<Integer, Set<Integer>> vertices;	
	
 	public void addEdges(int src, int dest){
		if(vertices != null){
			if(vertices.get(src)!=null){
				Set<Integer> edges=vertices.get(src);
				edges.add(dest);
			} else {
				Set<Integer> sourceEdges=new HashSet<Integer>();
				sourceEdges.add(dest);
				vertices.put(src, sourceEdges);
			}			
			if(vertices.get(dest)!=null){
				Set<Integer> destEdges=vertices.get(dest);
				if(!destEdges.contains(src))
					destEdges.add(src);
			} else {
				Set<Integer> destEdges=new HashSet<Integer>();
				destEdges.add(src);
				vertices.put(dest, destEdges);
			}
		} else {
			vertices=new HashMap<Integer, Set<Integer>>();
			Set<Integer> sourceEdges=new HashSet<Integer>();
			sourceEdges.add(dest);
			vertices.put(src, sourceEdges);

			Set<Integer> destEdges=new HashSet<Integer>();
			destEdges.add(src);
			vertices.put(dest, destEdges);
		}
	}
	
	public void print() {
		for (Map.Entry<Integer, Set<Integer>> entry : this.vertices.entrySet()) {
			int vertex = entry.getKey();
			Set<Integer> edges = this.vertices.get(vertex);
			for (Iterator iterator = edges.iterator(); iterator.hasNext();) {
				int edge =  (Integer) iterator.next();				
				System.out.println("vertex  :" + vertex + " => edge  :" + edge);
			}
		}
	}
	
	public static void main(String[] args) {
		MyGraph graph = new MyGraph();
		graph.addEdges(0, 1);
		graph.addEdges(0, 3);
		
		graph.addEdges(1, 0);
		graph.addEdges(1, 2);
		graph.addEdges(1, 3);

		graph.addEdges(2, 1);
		graph.addEdges(2, 4);
		
		graph.addEdges(3, 0);
		graph.addEdges(3, 1);
		graph.addEdges(3, 4);
		graph.print();
	}
}
