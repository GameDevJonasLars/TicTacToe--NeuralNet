package com.ticTacToeNeunOut;

import java.util.ArrayList;

public class TrainControlThread extends Thread {
	Main main;
	int iNeural1;
	int iNeural2;
	int iZeichen1;
	int iZeichen2;
	boolean runing;
	InputThread itNet1;
	InputThread itNet2;
	
	public TrainControlThread(Main main, int iNeural1, int iNeural2, int iZeichen1, int iZeichen2) {
		this.main = main;
		this.iNeural1 = iNeural1;
		this.iNeural2 = iNeural2;
		this.iZeichen1 = iZeichen1;
		this.iZeichen2 = iZeichen2;
		runing = true;
	}
	public void delete() {
		runing = false;
	}
	public void run() {
		while(runing) {
			int iKreuzPunkte = 0;
			int iKreisPunkte = 0;
			itNet1 = new InputThread(main, iNeural1, iZeichen1);
			itNet2 = new InputThread(main, iNeural2, iZeichen2);
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
			if (main.testWin() == 1) {
				iKreuzPunkte += 4;
			}
			else if (main.testWin() == -1) {
				iKreisPunkte +=4;
			}
			iKreuzPunkte--;
			main.jfMainWindow.setTitle("Tic Tac Toe Kreuz: "+iKreuzPunkte+" Kreis: "+iKreisPunkte);
			System.out.println("Kreis"+iKreisPunkte+"Kreuz"+iKreuzPunkte);
			if (iKreisPunkte < iKreuzPunkte) {
				iNeural2 = main.getaGeneticAlg().mutate(iNeural2, 10);
			}
			else if(iKreisPunkte > iKreuzPunkte){
				iNeural1 = main.getaGeneticAlg().mutate(iNeural1, 10);
			}
			else {
				/*ArrayList<Integer> struct = new ArrayList<Integer>();
				struct.add(9);
				
				struct.add(6);
				struct.add(5);
				struct.add(3);
				
				struct.add(1);
				iNeural1 = main.getaGeneticAlg().createPopulation(struct, 9, 1);*/
				main.getaGeneticAlg().swapNet(iNeural1, iNeural2);
				iNeural1 = main.getaGeneticAlg().mutate(iNeural1, 1);
				iNeural2 = main.getaGeneticAlg().mutate(iNeural2, 1);
			}
			try {
				Thread.sleep(2000/main.getiSpeed());
			} catch (Exception e) {
				// TODO: handle exception
			}
			for(Feld[] felds:main.getfFelder()) {
				for (Feld feld : felds) {
					feld.setBesitzer(0);
				}
				
			}
			main.setiSpieler(1);
			try {
				Thread.sleep(2000/main.getiSpeed());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
}
