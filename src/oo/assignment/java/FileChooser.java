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
	int x;
	boolean check;
	String line;
		
	String[] data;
	
	FileChooser() throws IOException
	{
	
		FC = new JFileChooser();

		FC.setMultiSelectionEnabled(true); // Enables selection of more than one file

		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		FC.setFileFilter(filter); // Filter to make sure only text files can be selected

		FC.setDialogTitle("Choose File");

		int x = FC.showOpenDialog(null);
		


		if (x == JFileChooser.APPROVE_OPTION)
		{
			files = FC.getSelectedFile();
			System.out.println("File Chosen" );
			
			BufferedReader abc = new BufferedReader(new FileReader(files));
			List<String> lines = new ArrayList<String>();
			
			try {
				while((line = abc.readLine()) != null) {
				    lines.add(line);
				    System.out.println(data);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			abc.close();

			// If you want to convert to a String[]
			String[] data = lines.toArray(new String[]{});
		}
		
}

}
