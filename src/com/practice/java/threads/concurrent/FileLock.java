package com.practice.java.threads.concurrent;

/**
 * The main objective of this class is to implement file level lock using java to 
 * access the file content in thread safe manner.
 * For ex: 
 * 1. Thread A checks and aquires lock on File F to read and process the content.
 * 2. Thread B checks and waits for the lock to be released.
 * 3. Thread A releases the lock.
 * 4. Thread B acquires the lock and processes the content.
 * @author Mihir
 *
 */
public class FileLock {

}
