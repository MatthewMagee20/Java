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
	
	private Scanner scanner;
	private File files;
	private String[] arr = { "a", "the" }; // stop words
	private Map<String, Integer> frequency = new HashMap<>();
	private BufferedReader reader;
	
	public Results(Scanner scanner, File files,String[] arr, Map<String, Integer> frequency, BufferedReader reader)
	{
		this.scanner = scanner;
		this.files = files;	
		this.arr = arr;
		this.frequency = frequency;
		this.reader = reader;
		
	}
		
	public void Calculations(File files, BufferedReader reader) throws IOException 
	{
		
		reader = new BufferedReader(new FileReader(files));
	    scanner = new Scanner(files);

	String line = reader.readLine();
	
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

	System.out.println(frequency);
	
	int mostFrequentlyUsed = 0;
	String theWord = null;
	
	for(String word : frequency.keySet()) {
		Integer theVal = frequency.get(word);
		if(theVal > mostFrequentlyUsed) {
			mostFrequentlyUsed = theVal;
			theWord = word;
		}
	}
	System.out.println();
	System.out.printf("the most frequently used word is '%s', %d times", 
			theWord, mostFrequentlyUsed);
	
	
		
}
	
	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	public Map<String, Integer> getFrequency() {
		return frequency;
	}

	public void setFrequency(Map<String, Integer> frequency) {
		this.frequency = frequency;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}


   }





