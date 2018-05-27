package com.TicTacToeThree;

import java.util.ArrayList;

import com.SomeFunktions.ArrayListFunktions;
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
				ArrayList<Double> dOutPuts = new ArrayList<Double>();
				dOutPuts = Main.pop.getResults(0);
				for (int i = 0; i < dOutPuts.size(); i++) {
					dOutPuts.set(i, dOutPuts.get(i) + 1);
				} 
				boolean AI1Playing = true;
				while (AI1Playing ) {
					int iResult = dOutPuts.indexOf(ArrayListFunktions.maxD(dOutPuts));
					
					if (Main.gui.setFeld(iResult)) {
						dInputsAI1.set(iResult, 1.0);
						dInputsAI2.set(iResult, -1.0);
						iFelderNumAI1++;
						AI1Playing = false;
					
					}else {
						dOutPuts.set(iResult, 0.0);
					}
				}
				
				Main.gui.iSpieler = 4;
				iAIAtTurn = 2;
			}
			else {
				
				Main.pop.giveTask(dInputsAI2, 1);
				ArrayList<Double> dOutPuts = new ArrayList<Double>();
				dOutPuts = Main.pop.getResults(1);
				for (int i = 0; i < dOutPuts.size(); i++) {
					dOutPuts.set(i, dOutPuts.get(i) + 1);
				} 
				boolean AI2Playing = true;
				while (AI2Playing ) {
					int iResult = dOutPuts.indexOf(ArrayListFunktions.maxD(dOutPuts));
					
					if (Main.gui.setFeld(iResult)) {
						dInputsAI1.set(iResult, 1.0);
						dInputsAI2.set(iResult, -1.0);
						iFelderNumAI1++;
						AI2Playing = false;
					
					}else {
						dOutPuts.set(iResult, 0.0);
					}
				}
				
				Main.gui.iSpieler = 1;
				iAIAtTurn = 1;
			}
			
			try {
				Thread.sleep(2002 - Main.gui.iSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (Main.gui.GewinnenTestAI() == 1) {
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
								
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				
				iFelderNumAI1 = 0;
				iFelderNumAI2 = 0;
				
				Main.gui.reset();
				
				iPunkteAI1 ++;
				
			}else if (Main.gui.GewinnenTestAI() == 4) {
				
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				
				iFelderNumAI1 = 0;
				iFelderNumAI2 = 0;
				Main.gui.reset();
				
				iPunkteAI2 ++;
				
			}else if (iFelderNumAI1 + iFelderNumAI2 == 9) {
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				
				Main.pop.setNetwork(0, Main.pop.mutate2(0));
				Main.pop.setNetwork(1, Main.pop.mutate2(1));
				
				iFelderNumAI1 = 0;
				iFelderNumAI2 = 0;
				iPunkteAI1 = 0;
				iPunkteAI2 = 0;
				
				Main.gui.reset();
			}
			System.out.println("AI1:" + iPunkteAI1);
			System.out.println("AI1:" + iPunkteAI2);
			
			if (iPunkteAI1 == 8) {
				Main.pop.setNetwork(1, Main.pop.createRandomNetwork(9, 9));
				iPunkteAI1 = 0;
				iPunkteAI2 = 0;
				iFelderNumAI1 = 0;
				iFelderNumAI2 = 0;
				Main.gui.reset();
			}else if (iPunkteAI2 == 8) {
				Main.pop.setNetwork(0, Main.pop.createRandomNetwork(9, 9));
				iPunkteAI1 = 0;
				iPunkteAI2 = 0;
				iFelderNumAI1 = 0;
				iFelderNumAI2 = 0;
				Main.gui.reset();
			}
			
			if (iPunkteAI1 == 4 || iPunkteAI2 == 4) {
				Main.pop.swapNet(0, 1);
			}
		}
		
	}

}
