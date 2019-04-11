package oo.assignment.java;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Results
{
	
	PrintWriter pwInput;
	
	private String filename;
	private Scanner scanner;
	private File files;
	//private String[] arr = { "a", "the" }; // stop words
	ArrayList<String> word = new ArrayList<String>();
	ArrayList<Integer> count = new ArrayList<Integer>();
	
		
	
	// Constructor
	Results(String filename)
	{
		
		this.filename = filename;
		
	}
	
	void connectToFile() 
	{
		files = new File(filename);
	}
	
ArrayList<String> ReadFile() throws FileNotFoundException
{
	
	scanner = new Scanner(filename); 
	while(scanner.hasNext())
	{
		String nextword = scanner.next();
		
		//word in arraylist?
		if(word.contains(nextword))
		{
			int i = word.indexOf(nextword);
			count.set(i, count.get(i)+1);
		}
		else {
			word.add(nextword);
			count.add(1);
		}
		System.out.println(word);
	}
	
	
	return word;
	
}

void getFileWriter()
{
	try
	{
		pwInput = new PrintWriter(files);
	}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
	
}	

void writeLineToFile(String line)
{
   System.out.println(line);
		pwInput.println(line);    	
}	
		/*String line = reader.readLine();
		
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
		

		//frequency.keySet().removeAll(Arrays.asList(arr)); // removes words from frequency
		
		//String[] strs = frequency.keySet().toArray(new String[frequency.size()]);

		frequency.entrySet().toArray();
		System.out.println(frequency);
		
		int mostFrequentlyUsed = 0;
		String theWord = null;
		
		for(String word : frequency.keySet()) 
		{
			Integer theVal = frequency.get(word);
			if(theVal > mostFrequentlyUsed) 
			{
				mostFrequentlyUsed = theVal;
				theWord = word;		
			}
		}
		System.out.println();
		System.out.printf("the most frequently used word is '%s', %d times", 
				theWord, mostFrequentlyUsed);
		

	{
		System.out.println("run time error " );
	}
		
		return strs;
		*/

 

 

public ArrayList<String> getWord() {
	return word;
}

public void setWord(ArrayList<String> word) {
	this.word = word;
}
}





