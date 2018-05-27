package com.ticTacToeNeunOut;

public class GewinnenTest extends Thread {
	Feld fFelder[][];
	Main main;

	public GewinnenTest(Feld fFelder[][], Main main) {
		this.fFelder = fFelder;
		this.main = main;
	}

	public void run() {
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 3
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 3
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3) {
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(false);
				}
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();

			}
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setBesitzer(0);
					feld.setUsable(true);
				}
			}
			main.setiSpieler(1);

		}
		if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 12
				|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 12
				|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12
				|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
				|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12) {
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(false);
				}
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();

			}
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setBesitzer(0);
					feld.setUsable(true);
				}
			}
			main.setiSpieler(1);

		}
		int iUnentschieden = 1;
		for (Feld[] felds : fFelder) {
			for (Feld feld : felds) {
				iUnentschieden *= feld.getiBesitzer();
			}
		}
		if (iUnentschieden != 0) {
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setUsable(false);
				}
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();

			}
			for (Feld[] felds : fFelder) {
				for (Feld feld : felds) {
					feld.setBesitzer(0);
					feld.setUsable(true);
				}
			}
			main.setiSpieler(1);
		}

	}
}
