package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import model.InfosWindow;
import model.filesChoosers.SaveFileChooser;
import model.swing.Tools;

public class SaveButtonListener implements ActionListener {

	private Tools toolsReference;
	
	public SaveButtonListener(InfosWindow infosWindow) {
		// TODO When want to save via Info window
	}

	public SaveButtonListener(Tools tools) {
		toolsReference = tools;
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
				file = saveFileChooser.getSelectedFile();
				toolsReference.getMainWindow().setCurrentFile(file);
				toolsReference.getMainWindow().saveInFile(file);
			}
		}
	}

}
