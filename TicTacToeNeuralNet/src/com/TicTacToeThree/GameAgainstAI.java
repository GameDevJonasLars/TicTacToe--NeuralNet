package com.TicTacToeThree;

import java.util.ArrayList;

import com.SomeFunktions.ArrayListFunktions;

public class GameAgainstAI extends Thread {

	ArrayList<Double> dInputsAI1;
	int iFelderNumAI1;
	
	public GameAgainstAI() {
		
	}
	
	public void  run() {
		
		while (Main.gui.bAIPlaying) {
			
			Main.gui.jfMainWindow.validate();
			Main.gui.jfMainWindow.repaint();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (Main.gui.GewinnenTestAI() == 1) {
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
								
				}
				
				iFelderNumAI1 = 0;
				

				for (Feld[] felds : Main.gui.fFelder) {
					for (Feld feld : felds) {
						feld.setUsable(true);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Main.gui.reset();
				
			}else if (Main.gui.GewinnenTestAI() == 4) {
				
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}
				

				for (Feld[] felds : Main.gui.fFelder) {
					for (Feld feld : felds) {
						feld.setUsable(true);
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					
				iFelderNumAI1 = 0;
				Main.gui.reset();
				
			}else if (iFelderNumAI1 == 5) {
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				for (Feld[] felds : Main.gui.fFelder) {
					for (Feld feld : felds) {
						feld.setUsable(true);
					}
				}
				
				iFelderNumAI1 = 0;
				
				Main.gui.reset();
			}
			
			if (Main.gui.iSpieler == 1) {
				
				Main.gui.bPlaying = false;
				
				dInputsAI1 = new ArrayList<Double>();
				for (Feld[] felds : Main.gui.getfFelder()) {
					for (Feld feld : felds) {
						if (feld.getiBesitzer() == 1) {
							dInputsAI1.add(1.0);
						}
						else if (feld.getiBesitzer() == 4) {
							dInputsAI1.add(-1.0);
						}
						else if (feld.getiBesitzer() == 0) {
							dInputsAI1.add(0.0);
						}
					}
				}
				
				Main.pop.giveTask(dInputsAI1, 0);
				ArrayList<Double> dOutPuts = new ArrayList<Double>();
				dOutPuts = Main.pop.getResults(0);
				for (int i = 0; i < dOutPuts.size(); i++) {
					dOutPuts.set(i, dOutPuts.get(i) + 1);
				} 
				boolean AI1Playing = true;
				while (AI1Playing ) {
					int iResult = dOutPuts.indexOf(ArrayListFunktions.maxD(dOutPuts));
					
					if (Main.gui.setFeld(iResult)) {
						
						iFelderNumAI1++;
						AI1Playing = false;
					
					}else {
						dOutPuts.set(iResult, 0.0);
					}
				}
				
				Main.gui.iSpieler = 4;
				
				Main.gui.bPlaying = true;
			}
			
		}
	}
}
