package com.ticTacToe;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Feld {
	int iSpalte;
	int iZeile;
	JButton jbFeld;
	int iBesitzer;
	public Feld(int Zeile, int Spalte) {
		iSpalte = Spalte;
		iZeile = Zeile;
		jbFeld = new JButton();
		jbFeld.setBounds((300*(iSpalte))+(10*(iSpalte+1)), (300*(iZeile))+(10*(iZeile+1)), 300, 300);
		jbFeld.setLayout(null);
		jbFeld.setBorder(null);
		jbFeld.setIcon(new ImageIcon("res/feldNormal.png"));
		jbFeld.setDisabledIcon(new ImageIcon("res/feldNormal.png"));
	}
	public int getiSpalte() {
		return iSpalte;
	}

	public int getiZeile() {
		return iZeile;
	}

	public JButton getJbFeld() {
		return jbFeld;
	}
	public void setJbFeld(JButton jbFeld) {
		this.jbFeld = jbFeld;
	}
	public void setBesitzer(int iBesizer) {
		// 0=keiner 1=kreuz 4=kreis
		
		switch (iBesizer) {
		case 0:
			this.iBesitzer = iBesizer;
			jbFeld.setIcon(new ImageIcon("res/feldNormal.png"));
			jbFeld.setDisabledIcon(new ImageIcon("res/feldNormal.png"));
			jbFeld.repaint();
			break;
		case 1:
			this.iBesitzer = iBesizer;
			jbFeld.setIcon(new ImageIcon("res/feldKreuz.png"));
			jbFeld.setDisabledIcon(new ImageIcon("res/feldKreuz.png"));
			jbFeld.repaint();
			break;
		case 4:
			this.iBesitzer = iBesizer;
			jbFeld.setIcon(new ImageIcon(new ImageIcon("res/feldKreis.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
			jbFeld.setDisabledIcon(new ImageIcon(new ImageIcon("res/feldKreis.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
			jbFeld.repaint();
			break;
			
		default:
			break;
		}
	}
	public void setUsable(boolean bWahl) {
		jbFeld.setEnabled(bWahl);
	}
	public int getiBesitzer() {
		return iBesitzer;
	}
	

	

}
