package com.TicTacToeThree;

import java.util.ArrayList;

import com.geneticAlgorithm.Population;
import com.network.Network;

public class Training extends Thread {

	int iAIAtTurn = 1;
	ArrayList<Double> dInputsAI1;
	ArrayList<Double> dInputsAI2;
	boolean failed1;
	boolean failed2;
	int iFelderNumAI1;
	int iFelderNumAI2;
	int iPunkteAI1;
	int iPunkteAI2;
	
	public Training() {
		dInputsAI1 = new ArrayList<Double>();
		dInputsAI2 = new ArrayList<Double>();
		
		for (int i = 0; i < 9; i++) {
			dInputsAI1.add(0.0);
		}
		
		for (int i = 0; i < 9; i++) {
			dInputsAI2.add(0.0);
		}
		
		failed1 = false;
		failed2 = false;
	}
	
	public void  run() {
		
		while (Main.gui.bAIPlaying) {
			
			if (iAIAtTurn == 1) {
				
				Main.pop.giveTask(dInputsAI1, 0);
				
				double dResult = (Main.pop.getResults(0).get(0) + 1) * 4;
				
				if (Main.gui.setFeld((int) (dResult))) {
					dInputsAI1.set((int) (dResult), 1.0);
					dInputsAI2.set((int) (dResult), -1.0);
					iFelderNumAI1++;
					
				}else {
					failed1 = true;
				}
				
				Main.gui.iSpieler = 4;
				iAIAtTurn = 2;
			}
			else {
				
				Main.pop.giveTask(dInputsAI2, 1);
				
				double dResult = (Main.pop.getResults(1).get(0) + 1) * 4;
				
				if (Main.gui.setFeld((int) (dResult))) {
					dInputsAI2.set((int) (dResult), 1.0);
					dInputsAI1.set((int) (dResult), -1.0);
					iFelderNumAI2++;
					
				}else {
					failed2 = true;	
				}
				
				Main.gui.iSpieler = 1;
				iAIAtTurn = 1;
			}
			
			if (Main.gui.GewinnenTestAI() == 1) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
								
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				
				Main.gui.reset();
				
				iPunkteAI1 ++;
				
			}else if (Main.gui.GewinnenTestAI() == 4) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				
				Main.gui.reset();
				
				iPunkteAI2 ++;
				
			}else if (iFelderNumAI1 + iFelderNumAI2 == 9) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				
				Main.gui.reset();
			}
			
			try {
				Thread.sleep(Main.gui.iSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
