package oo.assignment.java;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.io.BufferedReader;
import java.io.File;


public class Results extends JPanel 
{
	private String filename;
	private Scanner scanner;
	private String strs;
	private File[] files;
	private String[] arr = { "a", "the" }; // stop words
	private Map<String, Integer> frequency = new HashMap<>();
	private BufferedReader reader;
		
	Results(File[] file)
	{
	
		this.files = file;
	
	}
	


void connectToFile() 
{
	
	File file = new File(filename);
}


Map<String, Integer> ReadFile()
{
	
	String line;
	try {
		line = reader.readLine();
	
	

	while(line != null) {
		
		if(!line.trim().equals("")) {
			String [] words = line.split(" ");
			
			for(String word : words) {
				if(word == null || word.trim().equals("")) {
					continue;
				}
				String processed = word.toLowerCase();
				processed = processed.replace(",", "");
				
				if(frequency.containsKey(processed)) {
					frequency.put(processed, 
							frequency.get(processed) + 1);
				} else {
					frequency.put(processed, 1);
				}
			}
		}
		
		line = reader.readLine();
	}
	

	frequency.keySet().removeAll(Arrays.asList(arr)); // removes words from frequency
	
	   String[] strs = frequency.keySet().toArray(new String[frequency.size()]);

	//frequency.entrySet().toArray();
	System.out.println(frequency);
	
	int mostFrequentlyUsed = 0;
	String theWord = null;
	
	for(String word : frequency.keySet()) {
		Integer theVal = frequency.get(word);
		if(theVal > mostFrequentlyUsed) {
			mostFrequentlyUsed = theVal;
			theWord = word;		}
	}
	System.out.println();
	System.out.printf("the most frequently used word is '%s', %d times", 
			theWord, mostFrequentlyUsed);
	
	} catch (IOException e) 
	{
		System.out.println("run time error " + e.getMessage());
	}
	return frequency;		
}

public String getStrs() {
	return strs;
}



public void setStrs(String strs) {
	this.strs = strs;
}



public File[] getFiles() {
	return files;
}

public void setFiles(File[] files) {
	this.files = files;
}

public Map<String, Integer> getFrequency() {
	return frequency;
}

public void setFrequency(Map<String, Integer> frequency) {
	this.frequency = frequency;
}


   }





