package com.nuage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.nuage.model.filesChoosers.OpenFileChooser;
import com.nuage.model.swing.Tools;
import com.nuage.model.swing.mode.Updatable;

public class OpenButtonListener implements ActionListener {

	private Tools toolsReference;

	public OpenButtonListener(Tools tools) {
		toolsReference = tools;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Updatable mode = toolsReference.getMainWindow().getMode();
		OpenFileChooser openFileChooser = new OpenFileChooser(mode);
		int returnVal = openFileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = openFileChooser.getSelectedFile();
			toolsReference.getMainWindow().setCurrentFile(file);
			toolsReference.getMainWindow().readFile(file);
		}
	}

}
