/****************************************
* Control: Purpose of this class is for the user to select an array of files
* which will then be passed to the Results class, where all the handling will happen.
* 
* Author: Matthew Magee
* 
*****************************************/

package oo.assignment.java;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FileChooser extends JPanel {

	private File files;
	private JFileChooser FC;
	private FileNameExtensionFilter filter;
	private int x;
	private String filename;

	FileChooser() throws FileNotFoundException {

		FC = new JFileChooser();

		FC.setMultiSelectionEnabled(true); 										// Enables selection of more than one file

		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");		// Filter to make sure only text files can be selected
		FC.setFileFilter(filter); 

		FC.setDialogTitle("Choose File"); 										// Sets title of JFileChooser GUI

		x = FC.showOpenDialog(null);

		if (x == JFileChooser.APPROVE_OPTION) 
		{
			File [] file1 = FC.getSelectedFiles();

			filename = files.getAbsolutePath();
			
			System.out.println("file == " +file1[0] + "\n"+file1[1]); 			//Print path of file
						
			Results result = new Results("Results Menu"); 						// Instantiate new Results Object

			result.setFile(file1);
			}
			
		}
		
		

	}
