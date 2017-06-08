package com.practice.java.datastructure;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
	int size=0;
	float threshold=0.75f;
	int defaultSize=10;
	List<Entry<K,V>> entries = new ArrayList<Entry<K, V>>(10);
	Object[] buckets;
	
	MyHashMap(int size){
		this.size=size;
		buckets = new Object[this.size];
	}
	
	void put(K k, V v){
		Entry<K, V> entry = new Entry<K, V>(k, v);
		int bucketNo = hashify(k);
		if(buckets[bucketNo]==null){
			entries = new ArrayList<Entry<K, V>>(10);
			entries.add(entry);
		} else{
			entries=(List<MyHashMap<K, V>.Entry<K, V>>) buckets[bucketNo];
			entries.add(entry);
		}
		buckets[bucketNo] = entries;
	}
	
	public V get(K k) {
		int bucketNo = hashify(k);
		List<MyHashMap<K, V>.Entry<K, V>> entries = (List<MyHashMap<K, V>.Entry<K, V>>) buckets[bucketNo];
		if (entries != null && entries.size() > 1) {
			for (Entry<K, V> entry : entries) {
				K key = entry.getKey();
				if (key.equals(k)) {
					return entry.getValue();
				}
			}
		} else if (entries != null && entries.size() == 1){
			Entry<K, V> entry=entries.get(0);
			if(entry!=null) return entry.getValue();
		}
		return null;
	}
	
	private int hashify(K key){	
		int hashCode = key.hashCode();
		int bucket=hashCode%this.size;
		return bucket;
	}
	
	public static void main(String args[]){
		MyHashMap map = new MyHashMap<String, String>(10);
		map.put("s", "s1");
		map.put("l", "l2");
		map.put("m", "m2");
		
		System.out.println(map.get("s"));
	}
	
	private class Entry<K,V>{
		K key;
		V value;
		public Entry(K k, V v) {
			this.key=k;
			this.value=v;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}		
	}
}
