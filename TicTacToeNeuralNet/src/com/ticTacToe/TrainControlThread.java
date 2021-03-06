package com.ticTacToe;

import java.util.ArrayList;

public class TrainControlThread extends Thread {
	Main main;
	int iNeural1;
	int iNeural2;
	int iZeichen1;
	int iZeichen2;
	
	public TrainControlThread(Main main, int iNeural1, int iNeural2, int iZeichen1, int iZeichen2) {
		this.main = main;
		this.iNeural1 = iNeural1;
		this.iNeural2 = iNeural2;
		this.iZeichen1 = iZeichen1;
		this.iZeichen2 = iZeichen2;
	}
	public void run() {
		while(true) {
			int iKreuzPunkte = 0;
			int iKreisPunkte = 0;
			InputThread itNet1 = new InputThread(main, iNeural1, iZeichen1);
			InputThread itNet2 = new InputThread(main, iNeural2, iZeichen2);
			itNet1.start();
			itNet2.start();
			try {
				itNet1.join();
				itNet2.join();
				System.out.println("HALLO");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Feld[] felds:main.getfFelder()) {
				for (Feld feld : felds) {
					if (feld.getiBesitzer() == 1) {
						iKreuzPunkte++;
					}
					if (feld.getiBesitzer() == -1) {
						iKreisPunkte++;
					}
				}
				
			}
			main.jfMainWindow.setTitle("Tic Tac Toe Kreuz: "+iKreuzPunkte+" Kreis: "+iKreisPunkte);
			System.out.println("Kreis"+iKreisPunkte+"Kreuz"+iKreuzPunkte);
			if (iKreisPunkte < iKreuzPunkte) {
				iNeural2 = main.getaGeneticAlg().mutate(iNeural1, 6-iKreuzPunkte);
			}
			else if(iKreisPunkte > iKreuzPunkte){
				iNeural1 = main.getaGeneticAlg().mutate(iNeural2, 6-iKreisPunkte);
			}
			else {
				/*ArrayList<Integer> struct = new ArrayList<Integer>();
				struct.add(9);
				
				struct.add(6);
				struct.add(5);
				struct.add(3);
				
				struct.add(1);
				iNeural1 = main.getaGeneticAlg().createPopulation(struct, 9, 1);*/
				iNeural2 = main.getaGeneticAlg().mutate(iNeural2,0.1);
				iNeural1 = main.getaGeneticAlg().mutate(iNeural1,0.1);
			}
			for(Feld[] felds:main.getfFelder()) {
				for (Feld feld : felds) {
					feld.setBesitzer(0);
				}
				
			}
			try {
				main.setiSpieler(1);
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
}
