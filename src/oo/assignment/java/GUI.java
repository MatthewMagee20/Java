package oo.assignment.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener,MouseListener 
{

	  //Attributes
	  private JButton ChooseFile;
	  private JButton Results;
	  private JButton open;
	  private String ftext;
	  private JTextField quantity;
	  private int fint;
	  private String text;
	  private JLabel label1;
	  boolean gencheck;
	  
	  GUI(JButton open){
		  this.open = open;
	  }
	  //create a section of screen (panel) that will hold some GUI components 
	  JPanel PanelN = new JPanel();
	  JPanel PanelC= new JPanel();
	  JPanel PanelS = new JPanel();
	  		  	 
	  //Constructor
	  public GUI(String title)
	  {
		  //set the title
		  super(title);
		
		  //sets the screen layout  - in this case, border layout
		  setLayout(new BorderLayout());
		   		   
		   //add the panel to the screen ,set background colour and panel dimensions
		   add(PanelN, BorderLayout.NORTH);
		   PanelN.setBackground(Color.gray);
		   add(PanelC, BorderLayout.CENTER);
		   PanelC.setBackground(Color.white);
		   add(PanelS, BorderLayout.SOUTH);
		   PanelS.setBackground(Color.gray);
	
		   label1  = new JLabel("Please choose an Option");
		   PanelC.add(label1); 
		   
		   
		   ChooseFile = new JButton("Choose Files");
		   ChooseFile.setPreferredSize(new Dimension(140, 30));
		   ChooseFile.addActionListener(this);
		   
		   Results = new JButton("Display Results");
		   Results.setPreferredSize(new Dimension(140, 30));
		   Results.addActionListener(this);
		   
		   PanelC.add(ChooseFile);
		   PanelC.add(Results);
		   
			// set the location of the screen  
		   setLocation(500,100);

		   // Define the size of the frame  
		   setSize(300,300);
		   
		   // make the screen appear - without this, it doesn't!  
		   setVisible(true);
		   	   
	 }
			  
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == open || event.getSource() == ChooseFile)
		{
			JOptionPane.showMessageDialog(this, "You will now select files");
			gencheck = true;
			try {
				FileChooser.FileChooser(open);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		else if(event.getSource() == Results) {
			JOptionPane.showMessageDialog(this, "Click \"Choose files\" first!");
		}
		
			

	}
		
	public void mouseClicked(MouseEvent e) {
	
		 
		if(SwingUtilities.isLeftMouseButton(e)) {
			//JOptionPane.showMessageDialog(this, "Left Click");
			
		
		}
		else if(SwingUtilities.isRightMouseButton(e)) {
			//JOptionPane.showMessageDialog(this, "Right Click");
			
		}
	}

	@Override
	 public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
   	 public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	 public void mouseEntered(MouseEvent e) {
		
		//JOptionPane.showMessageDialog(this, "Mouse Entered the left panel");
		
	}

	@Override
	 public void mouseExited(MouseEvent e) {
		//JOptionPane.showMessageDialog(this, "Mouse left the left panel");
		
		
	}
}
