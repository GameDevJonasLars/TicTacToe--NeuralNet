package com.ticTacToeNeunOut;

public class InputPlayerNetThread extends Thread {
	Main main;

	public InputPlayerNetThread(Main main) {
		this.main = main;
	}

	public void run() {
		InputThread itThread = new InputThread(main, 0, -1);
		itThread.start();
		while (main.testWin() == 0) {
			
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		main.jfMainWindow.remove(main.jpMainGame);
		main.jfMainWindow.add(main.jpMainMenu);
		main.jfMainWindow.validate();
		main.jfMainWindow.repaint();
		main.bPlaying = false;
		for (Feld[] felds : main.fFelder) {
			for (Feld feld : felds) {
				feld.setBesitzer(0);
			}
			
		}
		main.setiSpieler(1);
	}
}
