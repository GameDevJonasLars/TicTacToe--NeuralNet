package com.ticTacToeNeunOut;

import java.util.ArrayList;

import com.ticTacToeNeunOut.Main;

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
			if (iZeichen == 1) {
				for (Feld[] felds : main.getfFelder()) {
					for (Feld feld : felds) {
						feldZahlen[v] = feld.getiBesitzer();
						v++;
					}
				}
			}
			if (iZeichen == -1) {
				for (Feld[] felds : main.getfFelder()) {
					for (Feld feld : felds) {
						feldZahlen[v] = feld.getiBesitzer()*-1;
						v++;
					}
				}
			}
			System.out.println(feldZahlen[0] + " " + feldZahlen[1] + " " + feldZahlen[2]);
			System.out.println(feldZahlen[3] + " " + feldZahlen[4] + " " + feldZahlen[5]);
			System.out.println(feldZahlen[0] + " " + feldZahlen[7] + " " + feldZahlen[8]);

			while (main.getiSpieler() != iZeichen) {
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			ArrayList<Double> dInputs = new ArrayList<Double>();
			for (int feldZahl : feldZahlen) {
				if (feldZahl == 1) {
					dInputs.add((double) 1);
					dInputs.add((double) 0);
				}
				else if (feldZahl == -1) {
					dInputs.add((double) 0);
					dInputs.add((double) 1);
				}
				else {
					dInputs.add((double) 0);
					dInputs.add((double) 0);
				}
			}
			/*dInputs.add((double) (feldZahlen[0]));
			dInputs.add((double) (feldZahlen[1]));
			dInputs.add((double) (feldZahlen[2]));
			dInputs.add((double) (feldZahlen[3]));
			dInputs.add((double) (feldZahlen[4]));
			dInputs.add((double) (feldZahlen[5]));
			dInputs.add((double) (feldZahlen[6]));
			dInputs.add((double) (feldZahlen[7]));
			dInputs.add((double) (feldZahlen[8]));*/
			main.getaGeneticAlg().giveTask(dInputs, iNeural);
			ArrayList<FeldMatch> fmMatches = new ArrayList<FeldMatch>();
			for (int i = 0; i < main.getaGeneticAlg().getResults(iNeural).size(); i++) {
				fmMatches.add(new FeldMatch(i, main.getaGeneticAlg().getResults(iNeural).get(i)));
			}
			while(main.getiSpieler() == iZeichen) {
				double dRes = 0;
				int para = 0;
				for (int i=0; i<fmMatches.size();i++) {
					if (dRes > fmMatches.get(i).getFeldVal()) {
						dRes = fmMatches.get(i).getFeldVal();
						para = i;
					}
				}
				if(!main.setFeld(fmMatches.get(para).getFeld())){
					fmMatches.remove(para);
				}
				
				
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
