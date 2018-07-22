package com.practice.java.design.patterns.command;

public interface FileSystemReceiver {
	void openFile();
	void writeFile();
	void closeFile();
}
