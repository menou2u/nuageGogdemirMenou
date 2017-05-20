package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.swing.Tools;

public class ExecuteButtonListener implements ActionListener {

	Tools toolsReference;
	
	public ExecuteButtonListener(Tools tools) {
		toolsReference = tools;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		toolsReference.getMainWindow().runMath();
	}

}
