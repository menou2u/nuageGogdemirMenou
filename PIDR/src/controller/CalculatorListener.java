package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MathShortcuts;

public class CalculatorListener implements ActionListener{

	MathShortcuts calculatorReference;
	String functionClicked;
	
	public CalculatorListener(MathShortcuts calculator, String function){
		calculatorReference = calculator;
		functionClicked = function;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String buttonText = ((JButton) arg0.getSource()).getText();
		calculatorReference.updatePhiJ(buttonText);
	}

}