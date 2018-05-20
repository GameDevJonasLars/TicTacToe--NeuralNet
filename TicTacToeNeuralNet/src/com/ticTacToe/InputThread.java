package com.ticTacToe;

import java.util.ArrayList;

import com.ticTacToe.Main;

public class InputThread extends Thread {
	Main main;
	int iZeichen;
	int iNeural;

	public InputThread(Main main, int iNeural, int iZeichen) {
		this.main = main;
		this.iZeichen = iZeichen;
		this.iNeural = iNeural;
	}

	public void run() {
		int[] feldZahlen = new int[9];
		int v = 0;
		if (iZeichen == 4) {
			for (Feld[] felds : main.getfFelder()) {
				for (Feld feld : felds) {
					if (feld.getiBesitzer() == 1) {
						feldZahlen[v] = 4;
					}
					if (feld.getiBesitzer() == 4) {
						feldZahlen[v] = 1;
					}
					v++;
				}
			}
		} else {
			for (Feld[] felds : main.getfFelder()) {
				for (Feld feld : felds) {
					if (feld.getiBesitzer() == 1) {
						feldZahlen[v] = 4;
					}
					if (feld.getiBesitzer() == 4) {
						feldZahlen[v] = 1;
					}
					v++;
				}
			}
		}
		for (int n = 0; n < 9; n++) {
			while(main.getiSpieler() != iZeichen) {
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
				ArrayList<Double> dInputs = new ArrayList<Double>();
				dInputs.add((double) (feldZahlen[0]));
				dInputs.add((double) (feldZahlen[1]));
				dInputs.add((double) (feldZahlen[2]));
				dInputs.add((double) (feldZahlen[3]));
				dInputs.add((double) (feldZahlen[4]));
				dInputs.add((double) (feldZahlen[5]));
				dInputs.add((double) (feldZahlen[6]));
				dInputs.add((double) (feldZahlen[7]));
				dInputs.add((double) (feldZahlen[8]));
				main.getaGeneticAlg().giveTask(dInputs, iNeural);
				double dResult = (main.getaGeneticAlg().getResults(iNeural).get(0) + 1) * 4;
				System.out.println(dResult);
				if (!main.setFeld((int) dResult)) {
					if (iZeichen == 4) {
						main.setiSpieler(1);
					} else {
						main.setiSpieler(4);
					}

				}
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
