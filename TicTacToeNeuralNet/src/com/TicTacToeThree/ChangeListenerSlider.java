package com.TicTacToeThree;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerSlider implements ChangeListener{
	
	public ChangeListenerSlider() {
		
	}
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        Main.gui.iSpeed = (int)source.getValue()+1;
	        
	    }
	}
}
