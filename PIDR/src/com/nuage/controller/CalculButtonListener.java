package com.nuage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nuage.model.swing.CalculatedFunction;

public class CalculButtonListener implements ActionListener {

	private CalculatedFunction calculatedFunctionReference;
	
	public CalculButtonListener(CalculatedFunction calculatedFunction) {
		calculatedFunctionReference = calculatedFunction;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (calculatedFunctionReference.getFunctionCalculated().getText().equals("") || calculatedFunctionReference.getPoint().getText().equals("")){
			new PopUp(this);
		}
		else {
			calculatedFunctionReference.eval();	
		}
	}
	
	
	
}
