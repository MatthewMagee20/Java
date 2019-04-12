package oo.assignment.java;

public class Control {

	private static GUI GUI;

	public static void main(String[] args) {
		
		GUI = new GUI("GUI");

	}

	public static GUI getGUI() {
		return GUI;
	}

	public static void setGUI(GUI gUI) {
		GUI = gUI;
	}

}
