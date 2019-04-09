package oo.assignment.java;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JPanel;

import java.io.BufferedReader;
import java.io.File;


public class Results extends JPanel {
	
	Scanner scanner;
	private File files;





	public Results(File files) throws IOException {
		
				
		Map<String, Integer> frequency = new HashMap<>();
		BufferedReader reader = new BufferedReader(new FileReader(files));
		
	    scanner = new Scanner(files);

        this.files = files;
     	
	
	
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
}




