package com.ticTacToe;

import java.util.ArrayList;

import com.ticTacToe.Main;

public class InputThread extends Thread{
	Main main;
	int iZeichen;
	int iNeural;
	public InputThread(Main main,int iNeural,int iZeichen) {
		this.main = main;
		this.iZeichen = iZeichen;
		this.iNeural = iNeural;
	}
	public void run() {
		for(int n = 0; n < 9; n++) {
			if (main.getiSpieler() == iZeichen) {
				ArrayList<Double> dInputs = new ArrayList<Double>();
				dInputs.add((double)(main.getfFelder()[0][0].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[0][1].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[0][2].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[1][0].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[1][1].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[1][2].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[2][0].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[2][1].getiBesitzer()));
				dInputs.add((double)(main.getfFelder()[2][2].getiBesitzer()));
				main.getaGeneticAlg().giveTask(dInputs, iNeural);
				double dResult = (main.getaGeneticAlg().getResults(iNeural).get(0)+1)*4;
				System.out.println(dResult);
				if (!main.setFeld((int)dResult)) {
					if (iZeichen == 4) {
						main.setiSpieler(1);	
					}
					else {
						main.setiSpieler(4);
					}
					
				}
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
