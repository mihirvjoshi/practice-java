package com.practice.java.datastructure.algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;

public class MyCSVReader {
	
	public void parse() throws IOException{

		String[] column = null;
		String rowString = null;
		String csvFilename = ".\\Batting.csv";
		String outputFileName = ".\\temp.txt"; 
		int counter = 0;
		
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		File outputFile = new File(outputFileName);
		FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
	
		while((column = csvReader.readNext()) != null) {
			rowString = ++counter + column[0] + " # " + column[1] + " #  " + column[2];
			bw.write(rowString);
		}
		
		csvReader.close();
		bw.close();
	}

	public static void main(String[] args) {
		try {
			new MyCSVReader().parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
