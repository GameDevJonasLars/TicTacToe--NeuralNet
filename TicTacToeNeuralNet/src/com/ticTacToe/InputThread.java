package com.ticTacToe;

import java.util.ArrayList;

import com.ticTacToe.Main;

public class InputThread extends Thread{
	Main main;
	public InputThread(Main main) {
		this.main = main;
	}
	public void run() {
		while(true) {
			if (main.getiSpieler() == 4) {
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
				main.getaGeneticAlg().giveTask(dInputs, main.getiNeuralNet());
				double dResult = (main.getaGeneticAlg().getResults(main.getiNeuralNet()).get(0)+1)*4;
				System.out.println(dResult);
				if (!main.setFeld((int)dResult)) {
					main.setiSpieler(1);
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
