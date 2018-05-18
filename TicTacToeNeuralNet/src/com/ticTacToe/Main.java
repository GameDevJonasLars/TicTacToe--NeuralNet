package com.ticTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
	int iSpieler;
	boolean bPlaying;

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

	public static void main(String[] args) {
		Main game = new Main();
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
		if (bPlaying) {
			if (ae.getSource() == fFelder[0][0].getJbFeld()) {
				fFelder[0][0].setBesitzer(iSpieler);
				fFelder[0][0].setUsable(false);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[0][1].getJbFeld()) {
				fFelder[0][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[0][2].getJbFeld()) {
				fFelder[0][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[1][0].getJbFeld()) {
				fFelder[1][0].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[1][1].getJbFeld()) {
				fFelder[1][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[1][2].getJbFeld()) {
				fFelder[1][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[2][0].getJbFeld()) {
				fFelder[2][0].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[2][1].getJbFeld()) {
				fFelder[2][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}
			if (ae.getSource() == fFelder[2][2].getJbFeld()) {
				fFelder[2][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder).start();
				if (iSpieler == 1) {
					iSpieler = 4;
				} else {
					iSpieler = 1;
				}
			}

		}
	}

}
