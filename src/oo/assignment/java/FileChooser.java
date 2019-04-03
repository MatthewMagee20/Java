package oo.assignment.java;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

import java.util.Random;

public class FileChooser {
	String fileName;
	File fileExample;
	Scanner myScanner;
    PrintWriter pwInput;
	
	public FileChooser(){
		JFileChooser FC = new JFileChooser();
		JButton open = new JButton();
		
		FC.setMultiSelectionEnabled(true);
				
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		FC.setFileFilter(filter); //Filter to make sure only text files can be selected
		
		FC.setCurrentDirectory(new java.io.File("C:/Documents")); //Put user into Downloads Directory when option is selected
		FC.setDialogTitle("Choose File");
		
		int returnValue = FC.showOpenDialog(null);
		
		if(FC.showOpenDialog(open)==JFileChooser.APPROVE_OPTION) {
			File[] files = FC.getSelectedFiles();
			Arrays.asList(files).forEach(x -> 
			{
				if (x.isDirectory()) 
				{
					System.out.println(x.getName());
				}
			});
		}
		//("You chose the file: "+FC.getSelectedFile().getAbsolutePath(), 0);
			
	}

	private void FileManager(String fileName2) {
		// TODO Auto-generated method stub
		
	}

}

