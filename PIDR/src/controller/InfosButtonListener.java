package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.swing.Tools;
import view.window.InfosWindowFrame;

public class InfosButtonListener implements ActionListener {

	private Tools toolsReference;
	
	public InfosButtonListener(Tools tools) {
		toolsReference = tools;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//new InfosWindowFrame(toolsReference.getMainWindow());
		
	}

}
