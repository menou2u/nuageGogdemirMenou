package com.nuage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CloseButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		PopUp quitConfirmation = new PopUp(this);
		if (quitConfirmation.getAnswer() == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
