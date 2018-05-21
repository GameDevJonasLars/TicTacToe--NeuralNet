package com.ticTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.geneticAlgorithm.Algorithm;

public class Main implements ActionListener {
	JFrame jfMainWindow;
	JPanel jpMainGame;
	JPanel jpMainMenu;
	JPanel jpNeuralNet;
	JButton jbLocalSpielen;
	JButton jbNeuralSpielen;
	JButton jbLoadNet;
	JButton jbCreateNet;
	JButton jbEvolveNet;
	Feld fFelder[][];
	GewinnenTest gtGewinnen;
	Algorithm aGeneticAlg;
	int iSpieler;
	int iNeuralNet1;
	int iNeuralNet2;
	boolean bPlaying;
	static Main game;

	
	//Könntest du die Funktion vlt. umbenenen in createGame oder so das mit Main ist nen bisschen verwirre
	public Main() {
		//
		jfMainWindow = new JFrame("Tic Tac Toe");
		jpNeuralNet = new JPanel();
		jpMainMenu = new JPanel();
		jpMainGame = new JPanel();
		jbLocalSpielen = new JButton("Multiplayer");
		jbNeuralSpielen = new JButton("Neural Net");
		jbCreateNet = new JButton("Create Network");
		jbEvolveNet = new JButton("Evolve Network");
		jbLoadNet = new JButton("Load Network");
		aGeneticAlg = new Algorithm();
		jfMainWindow.setResizable(false);
		jfMainWindow.setDefaultCloseOperation(jfMainWindow.EXIT_ON_CLOSE);
		jpMainGame.setLayout(null);
		jpMainMenu.setLayout(null);
		jpNeuralNet.setLayout(null);
		jfMainWindow.setResizable(true);
		jfMainWindow.setSize(960, 990);
		jbLocalSpielen.setBounds(150, 450, 300, 50);
		jbNeuralSpielen.setBounds(540, 450, 300, 50);
		jbCreateNet.setBounds(345, 150, 300, 50);
		jbEvolveNet.setBounds(345, 250, 300, 50);
		jbLoadNet.setBounds(345, 350, 300, 50);
		jbCreateNet.addActionListener(this);
		jbEvolveNet.addActionListener(this);
		jbLoadNet.addActionListener(this);
		jbLocalSpielen.addActionListener(this);
		jbNeuralSpielen.addActionListener(this);
		jpMainMenu.add(jbLocalSpielen);
		jpMainMenu.add(jbNeuralSpielen);
		jpNeuralNet.add(jbCreateNet);
		jpNeuralNet.add(jbEvolveNet);
		jpNeuralNet.add(jbLoadNet);

		fFelder = new Feld[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				fFelder[i][j] = new Feld(i, j);
				jpMainGame.add(fFelder[i][j].getJbFeld());
				JButton jbButton = fFelder[i][j].getJbFeld();
				jbButton.addActionListener(this);
				fFelder[i][j].setJbFeld(jbButton);
			}
		}
		gtGewinnen = new GewinnenTest(fFelder);
		jfMainWindow.setVisible(true);
		jfMainWindow.repaint();
		iSpieler = 1;
	}
	
	

	public Feld[][] getfFelder() {
		return fFelder;
	}




	public Algorithm getaGeneticAlg() {
		return aGeneticAlg;
	}



	public int getiSpieler() {
		return iSpieler;
	}



	public boolean isbPlaying() {
		return bPlaying;
	}
	
	
	public static Main getGame() {
		return game;
	}

	

	public void setiSpieler(int iSpieler) {
		this.iSpieler = iSpieler;
	}



	public boolean setFeld(int iFeld) {
		int n = 0;
		for (Feld[] felds : fFelder) {
			for (Feld feld : felds) {
				
				if (iFeld == n) {
					if (feld.getiBesitzer() == 0) {
						feld.setBesitzer(iSpieler);
						feld.setUsable(false);
						iSpieler *= -1;
						//new GewinnenTest(fFelder).start();
						
						return true;
					}
					else {
						return false;
					}
				}
				n++;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		game = new Main();
		game.jfMainWindow.add(game.jpMainMenu);
		// game.gtGewinnen.start();
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbLocalSpielen) {
			jfMainWindow.add(jpMainGame);
			jfMainWindow.remove(jpMainMenu);
			jfMainWindow.validate();
			bPlaying = true;
			
		}
		if (ae.getSource() == jbNeuralSpielen) {
			jfMainWindow.add(jpNeuralNet);
			jfMainWindow.remove(jpMainMenu);
			jfMainWindow.validate();
			bPlaying = false;
		}
		if (ae.getSource() == jbCreateNet) {
			jfMainWindow.add(jpMainGame);
			jfMainWindow.remove(jpNeuralNet);
			jfMainWindow.validate();
			bPlaying = false;
			ArrayList<Integer> struct = new ArrayList<Integer>();
			struct.add(9);
			
			struct.add(6);
			struct.add(5);
			struct.add(3);
			
			struct.add(1);
			iNeuralNet1 = aGeneticAlg.createPopulation(struct,9,1);
			iNeuralNet2 = aGeneticAlg.createPopulation(struct,9,1);
			new TrainControlThread(game, iNeuralNet1, iNeuralNet2, 1, -1).start();

		}
		if (bPlaying) {
			if (ae.getSource() == fFelder[0][0].getJbFeld()) {
				fFelder[0][0].setBesitzer(iSpieler);
				fFelder[0][0].setUsable(false);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[0][1].getJbFeld()) {
				fFelder[0][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[0][2].getJbFeld()) {
				fFelder[0][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[1][0].getJbFeld()) {
				fFelder[1][0].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[1][1].getJbFeld()) {
				fFelder[1][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[1][2].getJbFeld()) {
				fFelder[1][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[2][0].getJbFeld()) {
				fFelder[2][0].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[2][1].getJbFeld()) {
				fFelder[2][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[2][2].getJbFeld()) {
				fFelder[2][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				iSpieler *= -1;
			}

		}
	}

}
