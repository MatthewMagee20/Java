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
	private Results result;
	private JFileChooser FC;
	private FileNameExtensionFilter filter;
	int x;
	boolean check;
	
	public FileChooser(File files, Results result, FileNameExtensionFilter filter) 
	{
		
		this.files = files;
		this.result = result;
		this.filter = filter;
	
	}
	
	public static void FilePick(JButton open, File files, boolean check, Results result) throws IOException {

		JFileChooser FC = new JFileChooser();

		FC.setMultiSelectionEnabled(true); // Enables selection of more than one file

		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		FC.setFileFilter(filter); // Filter to make sure only text files can be selected

		FC.setDialogTitle("Choose File");

		int x = FC.showOpenDialog(null);

		if (x == JFileChooser.APPROVE_OPTION) {
			files = FC.getSelectedFile();
			check = true;
		}
		
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
	}

	public Results getResult() {
		return result;
	}

	public void setResult(Results result) {
		this.result = result;
	}

	public JFileChooser getFC() {
		return FC;
	}

	public void setFC(JFileChooser fC) {
		FC = fC;
	}

	public FileNameExtensionFilter getFilter() {
		return filter;
	}

	public void setFilter(FileNameExtensionFilter filter) {
		this.filter = filter;
	}

}