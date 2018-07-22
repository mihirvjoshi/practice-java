package com.practice.java.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PrintCharacterEncoding {

    public static void main(String[] args) {
	int ch;
	File myFile = null;
	FileInputStream fin = null;
	StringBuffer strContent = new StringBuffer("");

	try {
	    myFile = new File("C:\\workspace\\practice-java\\test_encoding.txt");
	    fin = new FileInputStream(myFile);

	    while ((ch = fin.read()) != -1) {
		System.out.println("Character :: " + (char) ch + " byte code : " + ch);
		strContent.append((char) ch);
	    }

	    fin.close();

	} catch (FileNotFoundException e) {
	    System.out.println("File " + myFile.getAbsolutePath()
		    + " could not be found on filesystem");
	} catch (IOException ioe) {
	    System.out.println("Exception while reading the file" + ioe);
	}

	System.out.println("File contents :");
	System.out.println(strContent);
	byte inbytes[] = new byte[1024];
	inbytes= stringToBytesASCII(strContent.toString());
	try {
	    String in = new String(inbytes, "cp1252");
	    System.out.println(in);
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
    }

    public static byte[] stringToBytesASCII(String str) {
	byte[] b = new byte[str.length()];
	for (int i = 0; i < b.length; i++) {
	    b[i] = (byte) str.charAt(i);
//	    System.out.println((char)b[i]+":::"+b[i]);
	}
	return b;
    }

}
