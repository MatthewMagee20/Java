package oo.assignment.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import oo.assignment.*;

public class GUI extends JFrame implements ActionListener, MouseListener {

	// Attributes
	private JButton ChooseFileButton;
	private JButton ResultsButton;
	private JButton open;
	private JTextArea textarea;
	private JLabel label1;
	boolean check;
	private int x;
	private File[] files;
	private Scanner scan;
	private String filename;
	private Results result;
	
	GUI(Results result,String filename)
	{
this.result = result;
this.filename = filename;
	}
	


	// Constructor
	public GUI(String title) {
		// set the title
		super(title);

		// sets the screen layout - in this case, border layout
		setLayout(new BorderLayout());

			
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

		label1 = new JLabel("Please choose an Option");
		PanelN.add(label1);

		ChooseFileButton = new JButton("Choose Files");
		ChooseFileButton.setPreferredSize(new Dimension(140, 30));
		ChooseFileButton.addActionListener(this);

		ResultsButton = new JButton("Display Results");
		ResultsButton.setPreferredSize(new Dimension(140, 30));
		ResultsButton.addActionListener(this);

		textarea = new JTextArea();
		textarea.setEditable(false);
		this.setPreferredSize(new Dimension(200, 200));
		this.add(textarea, BorderLayout.CENTER);

		PanelN.add(ChooseFileButton);
		PanelN.add(ResultsButton);

		// set the location of the screen
		setLocation(500, 100);

		// Define the size of the frame
		setSize(600, 500);

		// make the screen appear - without this, it doesn't!
		setVisible(true);

	}

	public void actionPerformed(ActionEvent event) 
	{
		
		if (event.getSource() == open || event.getSource() == ChooseFileButton) 
		{
			JOptionPane.showMessageDialog(this, "You will now select files");
			
			JFileChooser FCGUI = new JFileChooser();

			FCGUI.setMultiSelectionEnabled(true); // Enables selection of more than one file

			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			FCGUI.setFileFilter(filter); // Filter to make sure only text files can be selected

			int x = FCGUI.showOpenDialog(null);

			FCGUI.setDialogTitle("Choose File");
			
			if (x == JFileChooser.APPROVE_OPTION)
			{

				System.out.println("File Chosen");
				//files = FCGUI.getSelectedFiles();
				
				files = FCGUI.getSelectedFiles();
				
				String filename = FCGUI.getSelectedFile().getAbsolutePath();

				result = new Results(filename);

			}
			
			check = true;
	    }
     		
		

		else if (event.getSource() == ResultsButton && check == true) 
		{
			
			
			//result.getFrequency();
			//textarea.setText(result.getFrequency().values().toString()); 
			// attempt to get print to tx area
			
			
				//FileManager fm = new FileManager("names.txt");

				result.connectToFile();
				result.ReadFile();
				System.out.println(result.Calc());
				
				
		
		}

		else 
		{
			JOptionPane.showMessageDialog(this, "Click \"Choose files\" first!");

		}

	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
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
