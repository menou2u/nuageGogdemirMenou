package com.nuage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.nuage.model.InfosWindow;
import com.nuage.model.filesChoosers.SaveFileChooser;
import com.nuage.model.swing.Tools;

public class SaveButtonListener extends AbstractSaveButtonListener implements ActionListener {

	public SaveButtonListener(Tools tools) {
		super(tools);
	}

	public SaveButtonListener(InfosWindow infosWindow) {
		super(infosWindow);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		File file = toolsReference.getMainWindow().getCurrentFile();
		if (toolsReference.getMainWindow().getCurrentFile() != null) {
			toolsReference.getMainWindow().saveInFile(file);
		} else {
			SaveFileChooser saveFileChooser = new SaveFileChooser(toolsReference.getMainWindow().getMode());
			int returnVal = saveFileChooser.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = new File(saveFileChooser.getSelectedFile() + getDescription());
				toolsReference.getMainWindow().setCurrentFile(file);
				toolsReference.getMainWindow().saveInFile(file);
			}
		}
	}
}
