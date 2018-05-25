package com.ticTacToeNeunOut;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

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
	JButton jbReturn;
	JButton jbNetX;
	JButton jbNetO;
	static JSlider jsSpeed;
	TrainControlThread tctTrain;
	Feld fFelder[][];
	GewinnenTest gtGewinnen;
	Algorithm aGeneticAlg;
	int iSpieler;
	int iNeuralNet1;
	int iNeuralNet2;
	int iSpeed;
	int iNetSpieler;
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
		jbEvolveNet = new JButton("Play Network");
		jbLoadNet = new JButton("Load Network");
		jbReturn = new JButton("Menu");
		jbNetX = new JButton("X");
		jbNetO = new JButton("O");
		jsSpeed = new JSlider(JSlider.HORIZONTAL, 0, 2000, 0);
		jsSpeed.setMajorTickSpacing(500);
		jsSpeed.setMinorTickSpacing(1);
		jsSpeed.setPaintTicks(true);
		jsSpeed.setPaintLabels(true);
		jsSpeed.setBounds(990, 200, 300, 50);
		Font font = new Font("Serif", Font.ITALIC, 15);
		jsSpeed.setFont(font);
		aGeneticAlg = new Algorithm();
		jfMainWindow.setResizable(false);
		jfMainWindow.setDefaultCloseOperation(jfMainWindow.EXIT_ON_CLOSE);
		jpMainGame.setLayout(null);
		jpMainMenu.setLayout(null);
		jpNeuralNet.setLayout(null);
		jfMainWindow.setResizable(true);
		jfMainWindow.setSize(1360, 990);
		jbLocalSpielen.setBounds(150, 450, 300, 50);
		jbNeuralSpielen.setBounds(540, 450, 300, 50);
		jbCreateNet.setBounds(345, 150, 300, 50);
		jbEvolveNet.setBounds(345, 250, 300, 50);
		jbLoadNet.setBounds(345, 350, 300, 50);
		jbReturn.setBounds(990, 100, 300, 50);
		jbNetX.setBounds(990, 300, 100, 50);
		jbNetO.setBounds(1190, 300, 100, 50);
		jbCreateNet.addActionListener(this);
		jbEvolveNet.addActionListener(this);
		jbLoadNet.addActionListener(this);
		jbLocalSpielen.addActionListener(this);
		jbNeuralSpielen.addActionListener(this);
		jbReturn.addActionListener(this);
		jbNetX.addActionListener(this);
		jbNetO.addActionListener(this);
		jpMainMenu.add(jbLocalSpielen);
		jpMainMenu.add(jbNeuralSpielen);
		jpNeuralNet.add(jbCreateNet);
		jpNeuralNet.add(jbEvolveNet);
		jpNeuralNet.add(jbLoadNet);
		jpMainGame.add(jbReturn);

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
		gtGewinnen = new GewinnenTest(fFelder, game);
		jfMainWindow.setVisible(true);
		jfMainWindow.repaint();
		iSpieler = 1;
		iSpeed = 1;
		iNetSpieler = 1;
	}
	
	

	public int getiSpeed() {
		return iSpeed;
	}

	

	public int getiNetSpieler() {
		return iNetSpieler;
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
	
	public int testWin() {
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 3
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 3
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3) {
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(false);
				}
			}
			return 1;
		}
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == -3
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == -3
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == -3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == -3
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == -3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == -3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == -3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == -3) {
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(false);
				}
			}
			return -1;
		}
		return 0;
	}


	public static void main(String[] args) {
		game = new Main();
		jsSpeed.addChangeListener(new ChangeListenerSlider(game));
		game.jfMainWindow.add(game.jpMainMenu);
		// game.gtGewinnen.start();
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbReturn) {
			jfMainWindow.add(jpMainMenu);
			jfMainWindow.remove(jpMainGame);
			jpMainGame.remove(jsSpeed);
			jpMainGame.remove(jbNetX);
			jpMainGame.remove(jbNetO);
			jfMainWindow.validate();
			jfMainWindow.repaint();
			bPlaying = false;
			tctTrain.delete();
		}
		if(ae.getSource() == jbEvolveNet) {
			jfMainWindow.add(jpMainGame);
			jfMainWindow.remove(jpNeuralNet);
			jpMainGame.add(jbNetX);
			jpMainGame.add(jbNetO);
			jfMainWindow.validate();
			jfMainWindow.repaint();
			bPlaying = true;
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(true);
				}
			}
			new InputPlayerNetThread(game).start();
		}
		if (ae.getSource() == jbLocalSpielen) {
			jfMainWindow.add(jpMainGame);
			jfMainWindow.remove(jpMainMenu);
			jfMainWindow.validate();
			jfMainWindow.repaint();
			bPlaying = true;
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(true);
				}
			}
		}
		if (ae.getSource() == jbNeuralSpielen) {
			jfMainWindow.add(jpNeuralNet);
			jfMainWindow.remove(jpMainMenu);
			jfMainWindow.validate();
			jfMainWindow.repaint();
			bPlaying = false;
		}
		if (ae.getSource() == jbCreateNet) {
			jfMainWindow.add(jpMainGame);
			jfMainWindow.remove(jpNeuralNet);
			jfMainWindow.validate();
			jfMainWindow.repaint();
			bPlaying = false;
			jpMainGame.add(jsSpeed);
			ArrayList<Integer> struct = new ArrayList<Integer>();
			struct.add(18);
			

			struct.add(16);
			
			struct.add(20);

			
			struct.add(9);
			iNeuralNet1 = aGeneticAlg.createPopulation(struct,18,1);
			iNeuralNet2 = aGeneticAlg.createPopulation(struct,18,1);
			tctTrain = new TrainControlThread(game, iNeuralNet1, iNeuralNet2, 1, -1);
			tctTrain.start();

		}
		if (ae.getSource() == jbNetX) {
			iNetSpieler = 1;
		}
		if (ae.getSource() == jbNetO) {
			iNetSpieler = -1;
		}
		if (bPlaying) {
			if (ae.getSource() == fFelder[0][0].getJbFeld()) {
				fFelder[0][0].setBesitzer(iSpieler);
				fFelder[0][0].setUsable(false);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[0][1].getJbFeld()) {
				fFelder[0][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[0][2].getJbFeld()) {
				fFelder[0][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[1][0].getJbFeld()) {
				fFelder[1][0].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[1][1].getJbFeld()) {
				fFelder[1][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[1][2].getJbFeld()) {
				fFelder[1][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[2][0].getJbFeld()) {
				fFelder[2][0].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[2][1].getJbFeld()) {
				fFelder[2][1].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}
			if (ae.getSource() == fFelder[2][2].getJbFeld()) {
				fFelder[2][2].setBesitzer(iSpieler);
				new GewinnenTest(fFelder, game).start();
				iSpieler *= -1;
			}

		}
	}
	

}
