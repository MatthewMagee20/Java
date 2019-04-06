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

	public static void FileChooser(JButton open) throws IOException{
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		JFileChooser FC = new JFileChooser();
		FC.setMultiSelectionEnabled(true);			//Enables selection of more than one file
		FC.setFileFilter(filter); 					//Filter to make sure only text files can be selected
		FC.setDialogTitle("Choose File");
		int x = FC.showOpenDialog(null);	
		File files = FC.getSelectedFile();
		
 
		if(x == JFileChooser.APPROVE_OPTION)
		{
			files = FC.getSelectedFile();
			BufferedReader reader = new BufferedReader(new FileReader(files));
			Map<String, Integer> frequency = new HashMap<>();
			
			String line = reader.readLine();
			while(line != null) {
				System.out.println("Processing line: " + line);
				
				if(!line.trim().equals("")) {
					String [] words = line.split(" ");
					
					for(String word : words) {
						if(word == null || word.trim().equals("")) {
							continue;
						}
						String processed = word.toLowerCase();
						processed = processed.replace(",", "");
						
						if(frequency.containsKey(processed)) {
							frequency.put(processed, 
									frequency.get(processed) + 1);
						} else {
							frequency.put(processed, 1);
						}
					}
				}
				
				line = reader.readLine();
			}
			
			
			System.out.println(frequency);
			
			int mostFrequentlyUsed = 0;
			String theWord = null;
			
			for(String word : frequency.keySet()) {
				Integer theVal = frequency.get(word);
				if(theVal > mostFrequentlyUsed) {
					mostFrequentlyUsed = theVal;
					theWord = word;
				}
			}
			System.out.println();
			System.out.printf("the most frequently used word is '%s', %d times", 
					theWord, mostFrequentlyUsed);
			
		}

	}
		}
		

		/*try
		{
			Desktop.getDesktop().open(files);
		}catch(IOException EE)
		{
			System.out.println("FAIL");
		}
	}
}

/*int i = reader.read();
while (i != -1)
{
    // Convert to char and print
    char ch = (char)i;
    System.out.print(ch);
    // Get next  from read()
    i = reader.read();
    j++;
}*/


