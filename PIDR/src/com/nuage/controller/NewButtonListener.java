package com.nuage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nuage.model.swing.Tools;

public class NewButtonListener implements ActionListener {

	private Tools toolsReference;

	public NewButtonListener(Tools tools) {
		toolsReference = tools;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		toolsReference.getMainWindow().reset();

	}

}
