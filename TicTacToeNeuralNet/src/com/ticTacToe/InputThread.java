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

		for (int n = 0; n < 5; n++) {
			int[] feldZahlen = new int[9];
			int v = 0;

			for (Feld[] felds : main.getfFelder()) {
				for (Feld feld : felds) {
					feldZahlen[v] = feld.getiBesitzer();
					v++;
				}
			}
			System.out.println(feldZahlen[0]+" "+feldZahlen[1]+" "+feldZahlen[2]);
			System.out.println(feldZahlen[3]+" "+feldZahlen[4]+" "+feldZahlen[5]);
			System.out.println(feldZahlen[0]+" "+feldZahlen[7]+" "+feldZahlen[8]);
			
			while (main.getiSpieler() != iZeichen) {
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
			double dResult = (main.getaGeneticAlg().getResults(iNeural).get(0) + 1) * 4.4;
			System.out.println(dResult);
			if (!main.setFeld((int) dResult)) {
				main.setiSpieler(main.getiSpieler() * -1);

			}

			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
