package com.ticTacToe;

public class GewinnenTest extends Thread {
	Feld fFelder[][];

	public GewinnenTest(Feld fFelder[][]) {
		this.fFelder = fFelder;
	}

	public void run() {
		while (true) {
			if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 3
					|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 3
					|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
					|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 3
					|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 3
					|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
					|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 3
					|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer()
							+ fFelder[2][0].getiBesitzer() == 3) {
				System.exit(0);
			}
			if (fFelder[0][0].getiBesitzer() + fFelder[0][1].getiBesitzer() + fFelder[0][2].getiBesitzer() == 12
					|| fFelder[1][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[1][2].getiBesitzer() == 12
					|| fFelder[2][0].getiBesitzer() + fFelder[2][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
					|| fFelder[0][0].getiBesitzer() + fFelder[1][0].getiBesitzer() + fFelder[2][0].getiBesitzer() == 12
					|| fFelder[0][1].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][1].getiBesitzer() == 12
					|| fFelder[0][2].getiBesitzer() + fFelder[1][2].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
					|| fFelder[0][0].getiBesitzer() + fFelder[1][1].getiBesitzer() + fFelder[2][2].getiBesitzer() == 12
					|| fFelder[0][2].getiBesitzer() + fFelder[1][1].getiBesitzer()
							+ fFelder[2][0].getiBesitzer() == 12) {
				System.exit(0);
			}

			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
