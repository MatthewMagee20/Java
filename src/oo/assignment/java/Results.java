package oo.assignment.java;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
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
	private JButton remStopWords;
	private JTextArea display;
	private JLabel label;
	private Scanner fileInput;
	private File [] file;
	private String [] stopWords;
	
	public Results(String title) {
		// set the title
		super(title);
			
		file = getFile();
	
		JPanel PanelN = new JPanel();
		JPanel PanelC = new JPanel();
		JPanel PanelS = new JPanel();

		// add the panel to the screen ,set background colour and panel dimensions
		add(PanelN, BorderLayout.NORTH);
		PanelN.setBackground(Color.gray);
		PanelN.setPreferredSize(new Dimension(580, 50));
		add(PanelC, BorderLayout.CENTER);
		PanelC.setBackground(Color.white);
		add(PanelS, BorderLayout.SOUTH);
		PanelS.setBackground(Color.gray);
		
		label = new JLabel("Please choose an Option");
		PanelN.add(label);
		
		freqWords = new JButton("Most Frequent words");
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
		if(event.getSource() == freqWords)
		{
			
			for(int j = 0; j < 2; j++)
			{
				try {
					fileInput = new Scanner(file[j]);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
					
			ArrayList<String> words = new ArrayList<String>();
			ArrayList<Integer> count = new ArrayList<Integer>();

			while(fileInput.hasNext())
			{
				String nextWord = fileInput.next();
				
				if(words.contains(nextWord))
				{
					int index = words.indexOf(nextWord);
					count.set(index, count.get(index)+ 1);
					
				}
				else {
					words.add(nextWord);
					count.add(1);
					
				}
			}
			
			fileInput.close();
			
			System.out.println(file[j].getName() + " word frequency");
			
			for(int i = 0; i < words.size(); i ++)
			{
				

				System.out.println("____________________________________");
				System.out.println("     "+words.get(i)+" = " + count.get(i)+ " time/s");
		
			}
			
			System.out.println("");

			System.out.println("  ----- End -----");
			System.out.println("");
		}
		
		if(event.getSource() == remStopWords)
		{
			
			StopWords sw = new StopWords();
			
			stopWords = sw.getStopWordsArray();
			
			for(int p = 0; p < 2; p++)
			{
			
			try {
				fileInput = new Scanner(file[p]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//ArrayList<String> remStop = new ArrayList<>(Arrays.asList(stopWords));
			
			ArrayList<String> words = new ArrayList<String>();

			while(fileInput.hasNext())
			{
				String nextWord = fileInput.next().toLowerCase();
				
				if(words.contains(nextWord))
				{
					int i = words.indexOf(nextWord);
					
				}
				else {
					words.add(nextWord);
					
				}
			
			}
			
			ArrayList<String> wordsClean = new ArrayList<String>();

			 for (int j = 0; j < stopWords.length; j++) {
	                if (words.contains(stopWords[j])) {
	                    words.remove(stopWords[j]);
	                    wordsClean.add(j,words.get(j));
	                    
	                }
	            }
			
			fileInput.close();

			System.out.println(file[p].getName() + " without stopwords");
			for(int i = 0; i < words.size(); i ++)
			{
				

				System.out.println("____________________________________");
				System.out.println("     "+words.get(i));
				
			}
			
			System.out.println("----- End -----");
			System.out.println("");
			
		}
			}
	}
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

	public void setFile(File [] file) {
		this.file = file;
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


		
	
	







