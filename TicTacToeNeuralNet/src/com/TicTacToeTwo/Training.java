package com.TicTacToeTwo;

import java.util.ArrayList;

import com.geneticAlgorithm.Population;
import com.network.Network;

public class Training extends Thread {

	int iAIAtTurn = 1;
	int iSpeed = 1;
	ArrayList<Double> dInputsAI1;
	ArrayList<Double> dInputsAI2;
	boolean failed1;
	boolean failed2;
	int iFelderNumAI1;
	int iFelderNumAI2;
	boolean bEinmal;
	
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
		
		bEinmal = true;
		
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
			
			if (iFelderNumAI1 + iFelderNumAI2 == 9) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Main.gui.bAIPlaying = false;
				
			} else if(failed1 & failed2 & !bEinmal) {
				Main.pop = new Population(2, 9, 1);
				Main.gui.reset();
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				iFelderNumAI1 = 0;
				iFelderNumAI2 = 0;
				failed1 = false;
				failed2 = false;	
			
			} else if(failed1 & failed2) {
				
				if(iFelderNumAI1 < iFelderNumAI2) {
					Main.gui.reset();
					
					Main.pop.setNetwork(0, Main.pop.mutate2(0));
				} else if (iFelderNumAI1 > iFelderNumAI2){
					Main.gui.reset();
					
					Main.pop.setNetwork(1, Main.pop.mutate2(1));
				}else {
					Main.gui.reset();
					Main.pop.setNetwork(1, Main.pop.mutate2(1));
					Main.pop.setNetwork(0, Main.pop.mutate2(0));
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI1.set(i, 0.0);
				}
				
				for (int i = 0; i < 9; i++) {
					dInputsAI2.set(i, 0.0);
				}
				
				System.out.println(iFelderNumAI1 + iFelderNumAI2);
				
				iFelderNumAI1 = 0;
				iFelderNumAI2 = 0;
				
				failed1 = false;
				failed2 = false;
			}
			
			/*if (Main.gui.GewinnenTestAI() == 1) {
				
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
				
				Main.pop.setNetwork(1, Main.pop.mutate2(0));
				
				bEinmal = true;
				
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
				
				Main.pop.setNetwork(0, Main.pop.mutate2(1));
				
				bEinmal = true;
			}*/
			
			try {
				Thread.sleep(iSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
