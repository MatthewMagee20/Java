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

import java.util.Random;

public class GUI extends JFrame implements ActionListener,MouseListener 
{

	  //Attributes
	  private JButton ChooseFile;
	  private JButton Results;
	  private JTextField quantity;
	  private int fint;
	  private String text;
	  private JLabel label1;
	  
	  //create a section of screen (panel) that will hold some GUI components 
	  JPanel PanelN = new JPanel();
	  JPanel PanelC= new JPanel();
	  		  	 
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
		   
		   add(PanelC, BorderLayout.SOUTH);
		   PanelC.setBackground(Color.gray);
	
		   label1  = new JLabel("Enter amount of files to compare");
		   PanelC.add(label1); 
		   
			// set the location of the screen  
		   setLocation(500,100);

		   // Define the size of the frame  
		   setSize(300,300);
		   
		   
		   
		   //Instantiate new buttons
		   ChooseFile = new JButton("Choose File");
		   ChooseFile.setPreferredSize(new Dimension(100, 40));
		   ChooseFile.addActionListener(this);
		   
		   Results = new JButton("Results");
		   Results.setPreferredSize(new Dimension(100, 40));
		   Results.addActionListener(this);
		   
			//Add Buttons to the panels and add listener  
		   PanelN.add(ChooseFile);
		   PanelN.add(Results);
		   
		   quantity = new JTextField();
		   quantity.setPreferredSize(new Dimension(120, 30));
		   PanelC.add(quantity,BorderLayout.CENTER);
		   quantity.addActionListener(this);
		   quantity.setToolTipText("Enter number of file to compare");
		   
		// make the screen appear - without this, it doesn't!  
		   setVisible(true);
		   	   
	 }
	  
	 public void actionPerformed(ActionEvent event) {
		 
		 /*if(event.getSource() == ChooseFile){
			 JFileChooser FC = new JFileChooser();
			 JButton open = new JButton();
			 FileChooser.File();*/
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
