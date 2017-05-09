package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.swing.Tools;

public class ImportButtonListener implements ActionListener {
	
	Tools toolsReference;
	
	public ImportButtonListener(Tools tools) {
		toolsReference = tools;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		toolsReference.getImportFileChooser().showOpenDialog(null);
	}

}
