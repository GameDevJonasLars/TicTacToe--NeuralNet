package com.TicTacToeThree;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.geneticAlgorithm.Algorithm;
import com.geneticAlgorithm.Population;

public class Gui {
	
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
	Feld fFelder[][];
	int iSpeed;
	JSlider jsSpeed;
	int iSpieler;
	boolean bPlaying;
	boolean bAIPlaying;

	public Gui() {
		//
		jfMainWindow = new JFrame("Tic Tac Toe");
		jpNeuralNet = new JPanel();
		jpMainMenu = new JPanel();
		jpMainGame = new JPanel();
		jbLocalSpielen = new JButton("Multiplayer");
		jbNeuralSpielen = new JButton("Neural Net");
		jbCreateNet = new JButton("Evolve Population");
		jbEvolveNet = new JButton("Play against Network");
		jbLoadNet = new JButton("Load Network");
		jbReturn = new JButton("Back to Menu");
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
		jbCreateNet.addActionListener(new ButtonHandler());
		jbEvolveNet.addActionListener(new ButtonHandler());
		jbLoadNet.addActionListener(new ButtonHandler());
		jbLocalSpielen.addActionListener(new ButtonHandler());
		jbNeuralSpielen.addActionListener(new ButtonHandler());
		jbReturn.addActionListener(new ButtonHandler());
		jpMainMenu.add(jbLocalSpielen);
		jpMainMenu.add(jbNeuralSpielen);
		jpNeuralNet.add(jbCreateNet);
		jpNeuralNet.add(jbEvolveNet);
		jpNeuralNet.add(jbLoadNet);
		jsSpeed = new JSlider(JSlider.HORIZONTAL, 0, 2000, 0);
		jsSpeed.setMajorTickSpacing(500);
		jsSpeed.setMinorTickSpacing(1);
		jsSpeed.setPaintTicks(true);
		jsSpeed.setPaintLabels(true);
		jsSpeed.setBounds(990, 200, 300, 50);
		Font font = new Font("Serif", Font.ITALIC, 15);
		jsSpeed.setFont(font);
		jsSpeed.addChangeListener(new ChangeListenerSlider());

		fFelder = new Feld[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				fFelder[i][j] = new Feld(i, j);
				jpMainGame.add(fFelder[i][j].getJbFeld());
				JButton jbButton = fFelder[i][j].getJbFeld();
				jbButton.addActionListener(new ButtonHandler());
				fFelder[i][j].setJbFeld(jbButton);
			}
		}
		
		jfMainWindow.setVisible(true);
		jfMainWindow.repaint();
		iSpieler = 1;
	}
	
	

	public Feld[][] getfFelder() {
		return fFelder;
	}

	public int getiSpieler() {
		return iSpieler;
	}

	public boolean isbPlaying() {
		return bPlaying;
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
						if (iSpieler == 1) {
							iSpieler = 4;
						} else {
							iSpieler = 1;
						}
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
	
	public void reset() {
		for (Feld[] felds : fFelder) {
			for (Feld feld : felds) {
				feld.setBesitzer(0);
			}
		}
	}
	
	public int GewinnenTestAI() {
		
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 3
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 3
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3) {
			
			return 1;
			
		}
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 12
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 12
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12) {
			return 4;
		}
		return 0;
	}
	
	public void GewinnenTest() {
		
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
			
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();

			}
			Main.gui.jfMainWindow.add(Main.gui.jpMainMenu);
			Main.gui.jfMainWindow.remove(Main.gui.jpMainGame);
			Main.gui.jpMainGame.remove(Main.gui.jsSpeed);
			Main.gui.jpMainGame.remove(Main.gui.jbReturn);
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			Main.gui.bAIPlaying = false;
			Main.gui.reset();
			Main.gui.iSpieler = 1;
		}
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 12
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 12
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12) {
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(false);
				}
			}
			
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();

			}
			Main.gui.jfMainWindow.add(Main.gui.jpNeuralNet);
			Main.gui.jfMainWindow.remove(Main.gui.jpMainGame);
			Main.gui.jpMainGame.remove(Main.gui.jsSpeed);
			Main.gui.jpMainGame.remove(Main.gui.jbReturn);
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			Main.gui.bAIPlaying = false;
			Main.gui.reset();
			Main.gui.iSpieler = 1;
		}
	}
}
