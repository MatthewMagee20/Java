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
	private String[] strs;
	
	public Results(Map<String, Integer> frequency, File files, String[] strs)
	{
	
		this.files = files;		
		this.frequency = frequency;
		this.strs = getStrs();
	
	}
	

public void Calculations(File files) throws IOException 
{
	
	reader = new BufferedReader(new FileReader(getFiles()));
	scanner = new Scanner(getFiles());

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
	
   String[] strs = frequency.keySet().toArray(new String[frequency.size()]);

	frequency.keySet().removeAll(Arrays.asList(arr)); // removes words from frequency

	//frequency.entrySet().toArray();
	System.out.println(strs);
	
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
	
	public String[] getStrs() {
		return Arrays.copyOf(strs, strs.length);
	}

	public void setStrs(String[] strs) {
		this.strs = Arrays.copyOf(strs, strs.length);
	}



   }





