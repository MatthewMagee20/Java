/****************************************
* GUI: Holds button that when pressed, FileChooser class is
* 
* called
*   
* Author: Matthew Magee
* 
*****************************************/

package oo.assignment.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.FileNotFoundException;

public class GUI extends JFrame implements ActionListener, MouseListener 
{

	// Attributes
	private JButton ChooseFileButton;
	private FileChooser FileChooser;
	
	// Constructor
	public GUI(String title) 
	{
		// set the title
		super(title);

		
		JPanel PanelC = new JPanel();									 // create a section of screen (panel) that will hold some GUI components
		
		
		add(PanelC);													// add the panel to the screen ,set background colour
		PanelC.setBackground(Color.white);
			
		
		ChooseFileButton = new JButton("Choose Files");					//Instantiate Button and add it to PanelC
		ChooseFileButton.setPreferredSize(new Dimension(300, 260));
		ChooseFileButton.addActionListener(this);
		ChooseFileButton.setLayout(null);
		PanelC.add(ChooseFileButton);
		
		setLocation(500, 100);											// set the location of the screen
		
		setSize(300, 300);												// Define the size of the frame

		setVisible(true);												// make the screen appear - without this, it doesn't!

	}

	public void actionPerformed(ActionEvent event)
	{
		
		if (event.getSource() == ChooseFileButton) 
		{
			JOptionPane.showMessageDialog(this, "Hold CTRL + Left mouse click to choose multiple files");
			
				try 
				{
					
					FileChooser = new FileChooser();
					
				} 
				
				catch (FileNotFoundException e) 
				{
					
					e.printStackTrace();
					
				}
		
			}
		
				setVisible(false);										// GUI will disappear when button is pressed
	    }
	
	//								Unimplemented methods
     	
	public void mouseClicked(MouseEvent e) {
	}

	
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
}
