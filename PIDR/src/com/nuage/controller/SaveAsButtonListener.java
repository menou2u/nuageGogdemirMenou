package com.nuage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.nuage.model.filesChoosers.SaveFileChooser;
import com.nuage.model.swing.Tools;

public class SaveAsButtonListener extends AbstractSaveButtonListener implements ActionListener {

	public SaveAsButtonListener(Tools tools) {
		super(tools);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File file = toolsReference.getMainWindow().getCurrentFile();
		SaveFileChooser saveFileChooser = new SaveFileChooser(toolsReference.getMainWindow().getMode());
		int returnVal = saveFileChooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = new File(saveFileChooser.getSelectedFile() + getDescription());
			toolsReference.getMainWindow().setCurrentFile(file);
			toolsReference.getMainWindow().saveInFile(file);
		}
	}

}
