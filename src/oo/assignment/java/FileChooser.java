/*package oo.assignment.java;

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
	
	private File [] files;
	private JFileChooser FC;
	private FileNameExtensionFilter filter;
	int x;
	boolean check;
	private Results result;
		
	FileChooser(File[] files,Results result) 
	{
		
		this.result = result;
		this.files = files;
		
	}
	
	public void FilePick() throws IOException 
	{

		JFileChooser FCgui = new JFileChooser();

		FCgui.setMultiSelectionEnabled(true); // Enables selection of more than one file

		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		FCgui.setFileFilter(filter); // Filter to make sure only text files can be selected

		FCgui.setDialogTitle("Choose File");

		int x = FCgui.showOpenDialog(null);
		


		if (x == JFileChooser.APPROVE_OPTION)
		{
			files = FCgui.getSelectedFiles();
			result = new Results(files);
		
		}
		

	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public void setSelectedFiles(File[] files) {
		this.setSelectedFiles(files);
}
}
*/