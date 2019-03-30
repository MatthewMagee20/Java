package oo.assignment.java;

import javax.swing.*;

public class FileChooser {
	
	public static void File(){
		JFileChooser FC = new JFileChooser();
		JButton open = new JButton();
		
		FC.setCurrentDirectory(new java.io.File("C:/Downloads"));
		FC.setDialogTitle("Choose File");
		FC.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if(FC.showOpenDialog(open)==JFileChooser.APPROVE_OPTION) {
			
		}
		
		System.out.println(FC.getSelectedFile().getAbsolutePath());
	}


}

