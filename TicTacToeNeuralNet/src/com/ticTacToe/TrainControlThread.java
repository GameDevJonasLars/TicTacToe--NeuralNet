package com.ticTacToe;

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
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Feld[] felds:main.getfFelder()) {
				for (Feld feld : felds) {
					if (feld.getiBesitzer() == 1) {
						iKreuzPunkte++;
					}
					if (feld.getiBesitzer() == 4) {
						iKreisPunkte++;
					}
				}
				
			}
			if (iKreisPunkte < iKreuzPunkte) {
				iNeural2 = main.getaGeneticAlg().mutate(iNeural1);
			}
			else {
				iNeural1 = main.getaGeneticAlg().mutate(iNeural2);
			}
			for(Feld[] felds:main.getfFelder()) {
				for (Feld feld : felds) {
					feld.setBesitzer(0);
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
