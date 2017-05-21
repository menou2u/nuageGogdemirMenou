package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.swing.MathShortcuts;

public class CalculatorListener implements ActionListener{

	MathShortcuts calculatorReference;
	String functionClicked;
	
	public CalculatorListener(MathShortcuts calculator, String function){
		calculatorReference = calculator;
		functionClicked = function;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text;
		if (!functionClicked.equals("")){
			text = functionClicked;
		}
		else {
			text = ((JButton) arg0.getSource()).getText();
		}
		Component focusedComponent = JFrame.getFrames()[0].getFocusOwner();
		System.out.println("component "+focusedComponent.getName());
		if (focusedComponent != null){
			if (focusedComponent instanceof JTextArea) {
				((JTextArea) focusedComponent).setText(text);
			}
			if (focusedComponent instanceof JTextField) {
				((JTextField) focusedComponent).setText(text);
			}	
		}
		calculatorReference.updatePhiJ(text);
	}

}
