package com.TicTacToeTwo;

import com.geneticAlgorithm.Population;

public class Main {

	public static Gui gui;
	public static Population pop;
	
	public static void main(String[] args) {
		gui = new Gui();
		gui.jfMainWindow.add(gui.jpMainMenu);
	}

}
