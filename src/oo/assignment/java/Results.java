package oo.assignment.java;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Results extends JFrame implements ActionListener, MouseListener
{
	private JButton freqWords;
	private boolean check = false;
	private JButton remStopWords;
	private JTextArea display;
	private JLabel label;
	private Scanner fileInput;
	private Scanner freqScanner;
	private File [] file;
	private String [] stopWords;
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<Integer> count = new ArrayList<Integer>();
	ArrayList<String> nWords = new ArrayList<String>();
	


	public Results(String title) {
		// set the title
		super(title);
			
		file = getFile();
	
		JPanel PanelN = new JPanel();
		JPanel PanelC = new JPanel();	

		// add the panel to the screen ,set background colour and panel dimensions
		
		add(PanelN, BorderLayout.NORTH);
		PanelN.setBackground(Color.gray);
		PanelN.setPreferredSize(new Dimension(580, 50));
		add(PanelC, BorderLayout.CENTER);
		PanelC.setBackground(Color.white);	
		
		label = new JLabel("Please choose an Option");
		PanelC.add(label);
		
		freqWords = new JButton("Word Frequency");
		freqWords.setPreferredSize(new Dimension(140, 30));
		freqWords.addActionListener(this);

		remStopWords = new JButton("Remove Stop Words");
		remStopWords.setPreferredSize(new Dimension(140, 30));
		remStopWords.addActionListener(this);

		display = new JTextArea();
		display.setEditable(false);		
		this.setPreferredSize(new Dimension(200, 200));
		this.add(display, BorderLayout.CENTER);
		
		PanelN.add(remStopWords);
		PanelN.add(freqWords);
		
		// set the location of the screen
		setLocation(500, 100);

		// Define the size of the frame
		setSize(600, 500);

		// make the screen appear - without this, it doesn't!
		setVisible(true);
		
	}	

	public void actionPerformed(ActionEvent event) {
	
		for(int l = 0; l < file.length; l++)
		{

		if(event.getSource() == remStopWords)
		{
			check = true;
		
			StopWords sw = new StopWords();
			
			stopWords = sw.getStopWordsArray();
			
			
			try {
				fileInput = new Scanner(file[l]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(fileInput.hasNext())
			{
				String nextWord = fileInput.next().toLowerCase();
				
				if(words.contains(nextWord))
				{
					int index = words.indexOf(nextWord);
					count.set(index,count.get(index)+1);
				}
				
				else {
					words.add(nextWord);
					count.add(1);
				}
		
				for (int i = 0; i < stopWords.length; i++) 
				{
	                if (words.contains(stopWords[i])) 
	                {
	                    words.remove(stopWords[i]);
	                }
	               

	            }
			
			}
			
			display.append("--- FREQUENCY OF WORDS IN TEXT FILE WITH STOP WORDS REMOVED ---\n");
		
		for(int i = 0; i < words.size(); i++)
		{
			display.append("\n");
			display.append(words.get(i)+" " +count.get(i)+"\n");
			
		}
		
	
		fileInput.close();

		}
		
		}
		
		display.append("\n\n");
		}
	
	public String[] getStopWords() {
		return stopWords;
	}



	public void setStopWords(String[] stopWords) {
		this.stopWords = stopWords;
	}



	public File [] getFile() {
		return file;
	}

	public void setFile(File[] file1) {
		this.file = file1;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


		
	
	







