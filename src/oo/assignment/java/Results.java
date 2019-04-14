/****************************************
* 
* Results: Receives file array from FileChooser class
* 
* Counts for word frequency using 2 Array lists
* 
* Removes stop words
* 
* Author: Matthew Magee
* 
*****************************************/


package oo.assignment.java;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;

//loop to find frequency of words in file is not my own work

//https://www.youtube.com/watch?v=jsZo3JBjr90

public class Results extends JFrame implements ActionListener, MouseListener
{
	//Attributes
	private JButton printCalc;
	private JTextArea display;
	private Scanner fileScanner;
	private JScrollPane scrollBar; 
	private File [] files;
	private String [] stopWords;
	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<Integer> wordCount = new ArrayList<Integer>();
	
	//private ArrayList<String> nWords = new ArrayList<String>();
	


	public Results(String title) {
		
		super(title);
			
		files = getFile();																	//file = file array from FileChooser class									
	
		JPanel PanelN = new JPanel();														// Create new Panel
		add(PanelN, BorderLayout.NORTH);													// add the panel to the screen 
		PanelN.setBackground(Color.gray);
		PanelN.setPreferredSize(new Dimension(900, 50));
		
		printCalc = new JButton("Results");													// Create new Button
		printCalc.setPreferredSize(new Dimension(140, 30));
		printCalc.addActionListener(this);
		PanelN.add(printCalc);																// Add button to panel

		display = new JTextArea();															// Create JTextArea
		display.setEditable(false);		
		
		scrollBar = new JScrollPane(display);												// Create vertical Scroll Bar (Found on JavaAPI)
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  		
        add(scrollBar); 																	// Add to panel
        
        setLocation(500, 100);																// set the location of the screen
		setSize(900, 900);																	// Define the size of the frame
		setVisible(true);																	// make the screen appear
		
	}	

	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource() == printCalc)
		{	
			
			for(int l = 0; l < files.length; l++)											// for loop to iterate through file array
			{
				
				StopWords sWords = new StopWords();											// Create new stopWords object
			
				stopWords = sWords.getStopWordsArray();										// Assign stop words from class to stopWords variable
			
				try 
				{
					fileScanner = new Scanner(files[l]);
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			
			while(fileScanner.hasNext())
			{
				
				String nextWord = fileScanner.next().toLowerCase();							// Convert word to lower case, so stop words can be removed
				
				if(words.contains(nextWord))												// If words array already contains the net word in the file
				{																			// the count for the word is incremented by 1
					
					int index = words.indexOf(nextWord);
					wordCount.set(index,wordCount.get(index)+1);
					
				}
				
				else 																		// Else, the word is added to the list
				{																			// Count for word is set to 1
					
					words.add(nextWord);
					wordCount.add(1);
					
				}
		
				for (int i = 0; i < stopWords.length; i++) 									//For loop to remove stop words	
				{
					
	                if (words.contains(stopWords[i])) 
	                {
	                	
	                    words.remove(stopWords[i]);
	                    
	                }
	               
				}
			
			}
			
			// For readability
			display.append("\""+files[l]+"\"");
			
			display.append("\n");
			display.append("\n");

			display.append("-- STOP WORDS REMOVED --");
			
			display.append("\n");
			display.append("\n");

			display.append("-- WORDS WILL DISPLAY FREQUENCY --");
			display.append("\n");
			display.append("\n");
		
		for(int i = 0; i < words.size(); i++)
		{
			
			display.append("\n");
			
			display.append("\""+words.get(i)+"\""+" occured " +wordCount.get(i)+" time/s");
			
			display.append("\n");
			display.append("\n");

			
		}
		
		display.append("\n");
		display.append("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		display.append("\n");
		display.append("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		display.append("\n");
		
	

		}
		
	}
		
		fileScanner.close();

		display.append("\n\n");
}
	
	
	// 									Getter and Setter Methods
	
	
	public String[] getStopWords() {
		return stopWords;
	}

	public void setStopWords(String[] stopWords) {
		this.stopWords = stopWords;
	}

	public File [] getFile() {
		return files;
	}

	public void setFile(File[] file1) {
		this.files = file1;
	}
	
	
	//								Unimplemented methods
	
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {		
	}

	public void mouseReleased(MouseEvent arg0) {
	}

}


		
	
	







