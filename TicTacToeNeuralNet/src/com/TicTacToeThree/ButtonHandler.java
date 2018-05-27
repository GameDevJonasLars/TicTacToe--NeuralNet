package com.TicTacToeThree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.geneticAlgorithm.Population;

public class ButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Main.gui.jbLocalSpielen) {
			Main.gui.jfMainWindow.add(Main.gui.jpMainGame);
			Main.gui.jfMainWindow.remove(Main.gui.jpMainMenu);
			Main.gui.jfMainWindow.validate();
			Main.gui.bPlaying = true;
			
		}
		if (ae.getSource() == Main.gui.jbNeuralSpielen) {
			Main.gui.jfMainWindow.add(Main.gui.jpNeuralNet);
			Main.gui.jfMainWindow.remove(Main.gui.jpMainMenu);
			Main.gui.jfMainWindow.validate();
			Main.gui.bPlaying = false;
			Main.pop = new Population(2, 9, 9);
			
		}
		if (ae.getSource() == Main.gui.jbCreateNet) {
			Main.gui.jfMainWindow.add(Main.gui.jpMainGame);
			Main.gui.jfMainWindow.remove(Main.gui.jpNeuralNet);
			Main.gui.jpMainGame.add(Main.gui.jsSpeed);
			Main.gui.jpMainGame.add(Main.gui.jbReturn);
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			Main.gui.bPlaying = false;
			Main.gui.bAIPlaying = true;
			
			System.out.println(Main.pop.size());
			
			Training training = new Training();
			training.start();
			
		}
		if (ae.getSource() == Main.gui.jbEvolveNet) {
			Main.gui.jfMainWindow.add(Main.gui.jpMainGame);
			Main.gui.jfMainWindow.remove(Main.gui.jpNeuralNet);
			
			Main.gui.jpMainGame.add(Main.gui.jbReturn);
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			Main.gui.bPlaying = true;
			Main.gui.bAIPlaying = true;
			
			for (Feld[] felds : Main.gui.fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(true);
				}
			}
			
			GameAgainstAI game = new GameAgainstAI();
			game.start();
			
		}
		if (ae.getSource() == Main.gui.jbReturn) {
			Main.gui.jfMainWindow.add(Main.gui.jpNeuralNet);
			Main.gui.jfMainWindow.remove(Main.gui.jpMainGame);
			Main.gui.jpMainGame.remove(Main.gui.jsSpeed);
			Main.gui.jpMainGame.remove(Main.gui.jbReturn);
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			Main.gui.bAIPlaying = false;
			Main.gui.reset();
			Main.gui.iSpieler = 1;
			for (Feld[] felds : Main.gui.fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(false);
				}
			}
			
		}
		if (Main.gui.bPlaying & !Main.gui.bAIPlaying) {
			if (ae.getSource() == Main.gui.fFelder[0][0].getJbFeld()) {
				Main.gui.fFelder[0][0].setBesitzer(Main.gui.iSpieler);
				Main.gui.fFelder[0][0].setUsable(false);
				Main.gui.GewinnenTest();
				
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[0][1].getJbFeld()) {
				Main.gui.fFelder[0][1].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[0][2].getJbFeld()) {
				Main.gui.fFelder[0][2].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[1][0].getJbFeld()) {
				Main.gui.fFelder[1][0].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[1][1].getJbFeld()) {
				Main.gui.fFelder[1][1].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[1][2].getJbFeld()) {
				Main.gui.fFelder[1][2].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[2][0].getJbFeld()) {
				Main.gui.fFelder[2][0].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[2][1].getJbFeld()) {
				Main.gui.fFelder[2][1].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
			if (ae.getSource() == Main.gui.fFelder[2][2].getJbFeld()) {
				Main.gui.fFelder[2][2].setBesitzer(Main.gui.iSpieler);
				Main.gui.GewinnenTest();
				if (Main.gui.iSpieler == 1) {
					Main.gui.iSpieler = 4;
				} else {
					Main.gui.iSpieler = 1;
				}
			}
		}
		if (Main.gui.bPlaying & Main.gui.bAIPlaying) {
				if (ae.getSource() == Main.gui.fFelder[0][0].getJbFeld()) {
					Main.gui.fFelder[0][0].setBesitzer(Main.gui.iSpieler);
					Main.gui.fFelder[0][0].setUsable(false);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[0][1].getJbFeld()) {
					Main.gui.fFelder[0][1].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[0][2].getJbFeld()) {
					Main.gui.fFelder[0][2].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[1][0].getJbFeld()) {
					Main.gui.fFelder[1][0].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[1][1].getJbFeld()) {
					Main.gui.fFelder[1][1].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[1][2].getJbFeld()) {
					Main.gui.fFelder[1][2].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[2][0].getJbFeld()) {
					Main.gui.fFelder[2][0].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[2][1].getJbFeld()) {
					Main.gui.fFelder[2][1].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
				if (ae.getSource() == Main.gui.fFelder[2][2].getJbFeld()) {
					Main.gui.fFelder[2][2].setBesitzer(Main.gui.iSpieler);
					
					if (Main.gui.iSpieler == 1) {
						Main.gui.iSpieler = 4;
					} else {
						Main.gui.iSpieler = 1;
					}
				}
		}
	}
}
