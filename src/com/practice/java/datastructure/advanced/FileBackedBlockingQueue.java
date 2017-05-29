package com.practice.java.datastructure.advanced;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.practice.java.datastructure.MyQueue;

public class FileBackedBlockingQueue extends MyQueue implements IBlockingQueue, Serializable {

    /** Lock to fetch elements  */
    private final ReentrantLock takeLock = new ReentrantLock();

    /** condition to pull items from the queue */
    private final Condition hasSpace = takeLock.newCondition();

    /** Lock to put, offer, etc */
    private final ReentrantLock putLock = new ReentrantLock();

    /** condition to wait on the queue */
    private final Condition hasItems = putLock.newCondition();

    /** Current number of elements */
    private final AtomicInteger count = new AtomicInteger(this.SIZE);
    
    private int CAPACITY = 10; //some randome default capacity.
    
    private static File sharedFile = new File("c:\\Temp\\FileQueue.txt");
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    
    static{
		try {
			fw = new FileWriter(sharedFile.getAbsoluteFile());
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    FileBackedBlockingQueue(int CAPACITY) {
    	this.CAPACITY = CAPACITY;
    }
    
    /**
     * this method will retrieve the head of the queue if queue is non empty
     * of will wait till the data is available.
     */
	@Override
	public Object take() {
        int c = 0; Object popedObject = null;
		takeLock.lock();
		try {
			while(this.SIZE == 0) {
				hasSpace.await();
			}			
			popedObject = pop();
			c = count.decrementAndGet();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			hasSpace.signalAll();
		}

	    return popedObject;
	}

	
	@Override
	public void offer(Object o) {
		putLock.lock();
		
		try{
			
			//TODO - write the code here to check if last time it was crashed.
			// and sync the queue from the file in that case before
			// starting to add to the queue.
			try {
				fw = new FileWriter(sharedFile.getAbsoluteFile());
				bw = new BufferedWriter(fw);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			while(count.get() >= CAPACITY) {
				hasItems.await();
			}
			
			add(o);
			
			bw.write(o.toString());
 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hasItems.signalAll();
		}
		
		//TODO - serialize the queue and write it to the shared file.
	}

	public static void main(String[] args) {
		IBlockingQueue m = new FileBackedBlockingQueue(20);
		m.offer(10);
		System.out.println(m.take());
//		System.out.println(m.take());
	}

}
