package oo.assignment.java;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooser {
	
	public static void File(){
		JFileChooser FC = new JFileChooser();
		JButton open = new JButton();
		
		FC.setMultiSelectionEnabled(true); //Select more than one file
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		FC.setFileFilter(filter); //Filter to make sure only text files can be selected
		
		FC.setCurrentDirectory(new java.io.File("C:/Documents")); //Put user into Downloads Directory when option is selected
		FC.setDialogTitle("Choose File");
		
		if(FC.showOpenDialog(open)==JFileChooser.APPROVE_OPTION) {
		//	
		}
		
		System.out.println("You chose the file: "+FC.getSelectedFile().getAbsolutePath());
	
	}


}

