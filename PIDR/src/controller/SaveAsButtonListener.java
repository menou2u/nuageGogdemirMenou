package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import model.filesChoosers.SaveFileChooser;
import model.swing.Tools;

public class SaveAsButtonListener implements ActionListener {

	private Tools toolsReference;
	
	public SaveAsButtonListener(Tools tools) {
		toolsReference = tools;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File file = toolsReference.getMainWindow().getCurrentFile();
		SaveFileChooser saveFileChooser = new SaveFileChooser(toolsReference.getMainWindow().getMode());
		int returnVal = saveFileChooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = saveFileChooser.getSelectedFile();
			toolsReference.getMainWindow().setCurrentFile(file);
			toolsReference.getMainWindow().saveInFile(file);
		}
	}

}
