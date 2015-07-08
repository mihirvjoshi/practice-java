package com.practice.java.datastructure.advanced;

import com.practice.java.datastructure.IQueue;

public interface IBlockingQueue extends IQueue {

	public Object take();
	
	public void offer(Object o);
}
