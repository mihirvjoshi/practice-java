package com.practice.java.datastructure;

public interface IQueue {
	
  /**
   * will insert data at the top of the queue
   * @param o
   */
  public void add(Object o);
  
  /**
   * will return the data at the top of the queue and null if empty
   * @param o
   * @return
   */
  public Object pop();
  

  /**
   * will return data from the top but will not remove the head from the queue.
   * @param o
   * @return
   */
  public Object peek();
  
  public int size(); 
  
}
