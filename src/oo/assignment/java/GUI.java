package oo.assignment.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class GUI extends JFrame implements ActionListener, MouseListener {

	// Attributes
	private JButton ChooseFileButton;
	private JButton ResultsButton;
	private JButton open;
	private JTextArea textarea;
	private JLabel label1;
	private boolean check;
	private Scanner scanner;
	private int x;
	private File file;
	private String filename;
	private FileChooser FileChooser;
	Results Results;
	
	
	// Constructor
	public GUI(String title) {
		// set the title
		super(title);

		// sets the screen layout - in this case, border layout

		// create a section of screen (panel) that will hold some GUI components
		JPanel PanelC = new JPanel();

		// add the panel to the screen ,set background colour
		add(PanelC);
		PanelC.setBackground(Color.white);
			
		ChooseFileButton = new JButton("Choose Files");
		ChooseFileButton.setPreferredSize(new Dimension(140, 30));
		ChooseFileButton.addActionListener(this);

		ChooseFileButton.setLayout(null);
		PanelC.add(ChooseFileButton);
		
		  
		
		//ChooseFileButton.setLocation(135, 80);


		// set the location of the screen
		setLocation(700, 200);
		// Define the size of the frame
		setSize(300, 300);

		// make the screen appear - without this, it doesn't!
		setVisible(true);

	}

	public void actionPerformed(ActionEvent event)
	{
		
		if (event.getSource() == ChooseFileButton) 
		{
			JOptionPane.showMessageDialog(this, "You will now select files");
			
				try {
					FileChooser = new FileChooser();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		
			}
				setVisible(false);
	    }
     		
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	

	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {
			// JOptionPane.showMessageDialog(this, "Left Click");

		} else if (SwingUtilities.isRightMouseButton(e)) {
			// JOptionPane.showMessageDialog(this, "Right Click");

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

		// JOptionPane.showMessageDialog(this, "Mouse Entered the left panel");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// JOptionPane.showMessageDialog(this, "Mouse left the left panel");

	}


	
	
}
