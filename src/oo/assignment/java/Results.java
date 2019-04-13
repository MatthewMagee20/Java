package oo.assignment.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;

public class Results extends JFrame implements ActionListener, MouseListener
{
	private JButton freqWords;
	private JButton remStopWords;
	private JTextArea display;
	private JLabel label;
	private Scanner fileInput;
	private File file;

	
	public Results(String title) {
		// set the title
		super(title);
			
		file = getFile();
		
		JPanel PanelN = new JPanel();
		JPanel PanelC = new JPanel();
		JPanel PanelS = new JPanel();

		// add the panel to the screen ,set background colour and panel dimensions
		add(PanelN, BorderLayout.NORTH);
		PanelN.setBackground(Color.gray);
		PanelN.setPreferredSize(new Dimension(580, 50));
		add(PanelC, BorderLayout.CENTER);
		PanelC.setBackground(Color.white);
		add(PanelS, BorderLayout.SOUTH);
		PanelS.setBackground(Color.gray);
		
		label = new JLabel("Please choose an Option");
		PanelN.add(label);
		
		freqWords = new JButton("Most Frequent words");
		freqWords.setPreferredSize(new Dimension(140, 30));
		freqWords.addActionListener(this);

		remStopWords = new JButton("Remove Stop Words");
		remStopWords.setPreferredSize(new Dimension(140, 30));
		remStopWords.addActionListener(this);

		display = new JTextArea();
		display.setEditable(false);
		this.setPreferredSize(new Dimension(200, 200));
		this.add(display, BorderLayout.CENTER);

		PanelN.add(remStopWords);
		PanelN.add(freqWords);
		
		// set the location of the screen
		setLocation(500, 100);

		// Define the size of the frame
		setSize(600, 500);

		// make the screen appear - without this, it doesn't!
		setVisible(true);
		
	}
	


	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == freqWords)
		{
			
			
				try {
					fileInput = new Scanner(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
					
			ArrayList<String> words = new ArrayList<String>();
			ArrayList<Integer> count = new ArrayList<Integer>();

			while(fileInput.hasNext())
			{
				String nextWord = fileInput.next();
				
				if(words.contains(nextWord))
				{
					int index = words.indexOf(nextWord);
					count.set(index, count.get(index)+ 1);
					
				}
				else {
					words.add(nextWord);
					count.add(1);
					
				}
			}
			
			fileInput.close();
			
			for(int i = 0; i < words.size(); i ++)
			{
				

				System.out.println("____________________________________");
				System.out.println("     "+words.get(i)+" = " + count.get(i)+ " time/s");
		
			}
		}
		
		if(event.getSource() == remStopWords)
		{
			try {
				fileInput = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] stopWords = {"a", "as", "able", "about",
					"above", "according", "accordingly", "across", "actually",
					"after", "afterwards", "again", "against", "aint", "all",
					"allow", "allows", "almost", "alone", "along", "already",
					"also", "although", "always", "am", "among", "amongst", "an",
					"and", "another", "any", "anybody", "anyhow", "anyone", "anything",
					"anyway", "anyways", "anywhere", "apart", "appear", "appreciate",
					"appropriate", "are", "arent", "around", "as", "aside", "ask", "asking",
					"associated", "at", "available", "away", "awfully", "be", "became", "because",
					"become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being",
					"believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both",
					"brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes",
					"certain", "certainly", "changes", "clearly", "co", "com", "come",
					"comes", "concerning", "consequently", "consider", "considering", "contain",
					"containing",    "contains","corresponding","could", "couldnt", "course", "currently",
					"definitely", "described", "despite", "did", "didnt", "different", "do", "does",
					"doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu",
					"eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially",
					"et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere",
					"ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed",   
					"following", "follows", "for", "former", "formerly", "forth", "four", "from", "further",
					"furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone",
					"got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have",
					"havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", 
					"i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", 
					"just", 
					"keep", "keeps", "kept", "know", "knows", "known", 
					"last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd", 
					"mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself",
					"name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere",
					"obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own",
					"particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", 
					"que", "quite", "qv", 
					"rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", 
					"said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", 
					"ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", 
					"un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually",
					"value", "various", "very", "via", "viz", "vs", 
					"want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", 
					"yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", 
					"zero"};
			
			//ArrayList<String> remStop = new ArrayList<>(Arrays.asList(stopWords));
			
			ArrayList<String> words = new ArrayList<String>();

			while(fileInput.hasNext())
			{
				String nextWord = fileInput.next().toLowerCase();
				
				if(words.contains(nextWord))
				{
					int i = words.indexOf(nextWord);
					
				}
				else {
					words.add(nextWord);
					
				}
			
			}
			
			 for (int j = 0; j < stopWords.length; j++) {
	                if (words.contains(stopWords[j])) {
	                    words.remove(stopWords[j]);//remove it
	                }
	            }
			
			fileInput.close();

			for(int i = 0; i < words.size(); i ++)
			{
				

				System.out.println("____________________________________");
				System.out.println("     "+words.get(i));
				
			}
		}
			}
	

			



			
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


		
	
	







