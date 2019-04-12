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

public class Results extends JFrame implements ActionListener, MouseListener
{
	
	private JButton calcButton;
	private JTextArea resultsArea;
	private Scanner scanner;
	String filename;
	GUI obj;
	//private String[] arr = { "a", "the" }; // stop words
	ArrayList<String> word = new ArrayList<String>();
	ArrayList<Integer> count = new ArrayList<Integer>();
		
	
	
	  JPanel PanelN = new JPanel();
	  JPanel PanelS = new JPanel();
	  JPanel PanelC = new JPanel();
	  
	
	
	public Results(String filename) {
		// set the title
		super(filename);
	
	
		// sets the screen layout - in this case, border layout

		// create a section of screen (panel) that will hold some GUI components
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
	
		calcButton = new JButton("Calculate");
		calcButton.setPreferredSize(new Dimension(140, 30));
		calcButton.addActionListener(this);
		
		resultsArea = new JTextArea();
		resultsArea.setEditable(false);
		this.setPreferredSize(new Dimension(200, 200));
		this.add(resultsArea, BorderLayout.CENTER);
		
		PanelS.add(calcButton);
	
		// set the location of the screen
				setLocation(500, 100);

				// Define the size of the frame
				setSize(600, 500);

				// make the screen appear - without this, it doesn't!
				setVisible(true);

	}
	


	public void actionPerformed(ActionEvent event, String filename) {
		if (event.getSource() == calcButton) {
				
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
		}
		
		//System.out.println(filename);
	}


public ArrayList<String> getWord() {
	return word;
}

public void setWord(ArrayList<String> word) {
	this.word = word;
}




@Override
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

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}





		
		

		
	}
	



		
	
	







