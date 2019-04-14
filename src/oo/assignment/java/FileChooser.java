/****************************************
* Control: Purpose of this class is 
* 
* for the user to select an array of files
* 
* which will then be passed to the Results class, 
* 
* where all the handling will happen.
* 
* Author: Matthew Magee
* 
*****************************************/

package oo.assignment.java;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class FileChooser 
{
	
	// Attributes
	private JFileChooser jFChooser;
	private FileNameExtensionFilter filter;
	private int x;

	FileChooser() throws FileNotFoundException 
	{

		jFChooser = new JFileChooser();

		jFChooser.setMultiSelectionEnabled(true); 										// Enables selection of more than one file

		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");				// Filter to make sure only text files can be selected
		jFChooser.setFileFilter(filter); 

		jFChooser.setDialogTitle("Choose File"); 										// Sets title of JFileChooser GUI

		x = jFChooser.showOpenDialog(null);

		if (x == JFileChooser.APPROVE_OPTION) 
		{
			
			File [] fileArray = jFChooser.getSelectedFiles();							// Array to store files
			
			System.out.println("Files Selected are: ");
			System.out.println("");
			
			for(int i = 0; i < fileArray.length; i ++)
			{
				
				System.out.println(fileArray[i]+"\n");
				
			}
						
			Results result = new Results("Results Menu"); 								// Instantiate new Results Object

			result.setFile(fileArray);	
			
		}
			
	}
		
}
