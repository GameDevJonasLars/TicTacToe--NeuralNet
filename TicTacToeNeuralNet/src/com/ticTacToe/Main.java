package com.ticTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main implements ActionListener {
	JFrame jfMainWindow;
	JPanel jpMainGame;
	JPanel jpMainMenu;
	Feld fFelder[][];
	GewinnenTest gtGewinnen;
	int iSpieler;
	boolean bPlaying;

	public Main() {
		//
		jfMainWindow = new JFrame("Tic Tac Toe");
		jpMainMenu = new JPanel();
		jpMainGame = new JPanel();
		jfMainWindow.setDefaultCloseOperation(jfMainWindow.EXIT_ON_CLOSE);
		jpMainGame.setLayout(null);
		jfMainWindow.setResizable(true);
		jfMainWindow.setSize(960, 990);
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

	public void testGewinnen() {
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 3
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 3
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 12
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 12
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Main game = new Main();
		game.jfMainWindow.add(game.jpMainGame);
		// game.gtGewinnen.start();
	}

	public void actionPerformed(ActionEvent ae) {
		if (bPlaying) {
			if (ae.getSource() == fFelder[0][0].getJbFeld()) {
				fFelder[0][0].setBesitzer(iSpieler);
				fFelder[0][0].setUsable(false);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[0][1].getJbFeld()) {
				fFelder[0][1].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[0][2].getJbFeld()) {
				fFelder[0][2].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[1][0].getJbFeld()) {
				fFelder[1][0].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[1][1].getJbFeld()) {
				fFelder[1][1].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[1][2].getJbFeld()) {
				fFelder[1][2].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[2][0].getJbFeld()) {
				fFelder[2][0].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[2][1].getJbFeld()) {
				fFelder[2][1].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (ae.getSource() == fFelder[2][2].getJbFeld()) {
				fFelder[2][2].setBesitzer(iSpieler);
				testGewinnen();
			}
			if (iSpieler == 1) {
				iSpieler = 4;
			} else {
				iSpieler = 1;
			}
		}
	}

}
