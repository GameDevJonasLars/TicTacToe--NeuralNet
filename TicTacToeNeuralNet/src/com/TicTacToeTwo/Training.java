package com.TicTacToeTwo;

import java.util.ArrayList;

import com.geneticAlgorithm.Population;

public class Training extends Thread {

	int iAIAtTurn = 1;
	int iSpeed = 100;
	ArrayList<Double> dInputsAI1;
	ArrayList<Double> dInputsAI2;
	boolean failed1;
	boolean failed2;
	
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
				}else {
					failed2 = true;
				}
				
				Main.gui.iSpieler = 1;
				iAIAtTurn = 1;
			}
			
			if(failed1 & failed2) {
				Main.pop = new Population(2, 9, 1);
				Main.gui.reset();
				failed1 = false;
				failed2 = false;
			}
			
			System.out.println(Main.gui.GewinnenTestAI());
			
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
				
				Main.pop.setNetwork(1, Main.pop.mutate2(0));
				
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
			}
			
			try {
				Thread.sleep(iSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
