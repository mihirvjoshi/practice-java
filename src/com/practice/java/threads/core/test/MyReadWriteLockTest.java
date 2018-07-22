package com.practice.java.threads.core.test;

import com.practice.java.threads.core.MyReadWriteLock;

public class MyReadWriteLockTest {
	public static void main(String[] args) {
		MyReadWriteLock lock = new MyReadWriteLock();
		ReaderThread reader = new ReaderThread(lock);
		WriterThread writer = new WriterThread(lock);
		
		for (int i = 0; i < 10; i++) {
			new Thread(reader, "Reader-" + i).start();
			new Thread(writer, "Writer-" + i).start();
		}
	}
}
