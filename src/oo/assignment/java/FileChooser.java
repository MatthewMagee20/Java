package oo.assignment.java;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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

import java.util.Random;

public class FileChooser extends JPanel {

	public static void FileChooser(JButton open){
		
		JFileChooser FC = new JFileChooser();
		FC.setMultiSelectionEnabled(true);
		int x = FC.showOpenDialog(null);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		FC.setFileFilter(filter); //Filter to make sure only text files can be selected
		FC.setDialogTitle("Choose File");
						
		if(x == JFileChooser.APPROVE_OPTION)
		{
		File files = FC.getSelectedFile();
		try
		{
			Desktop.getDesktop().open(files);
		}catch(IOException EE)
		{
			System.out.println("FAIL");
		}
	}
}

}


