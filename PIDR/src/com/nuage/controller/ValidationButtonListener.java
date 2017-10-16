package com.nuage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import com.nuage.model.swing.mode.Line;

import javagiac.context;
import javagiac.gen;
import javagiac.giac;

public class ValidationButtonListener implements ActionListener {

	private Line lineReference;
	private String formulaXReference;
	private String formulaYReference;

	public ValidationButtonListener(Line line) {
		lineReference = line;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			System.load("C:\\Users\\camil\\git\\nuageGogdemirMenou\\PIDR\\libNuage\\javagiac.dll");
			// JavaGiacLoader.loadJavaGiac(null);
		} catch (UnsatisfiedLinkError f) {
			System.err.println(
					"Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n"
							+ f);
			System.exit(1);
		}

		formulaXReference = lineReference.getTransformationsLine().getTransformX().getTransformX().getText();
		formulaYReference = lineReference.getTransformationsLine().getTransformY().getTransformY().getText();

		LinkedList<Double> newCalculatedXPoints = new LinkedList<Double>();
		LinkedList<Double> newCalculatedYPoints = new LinkedList<Double>();

		if (formulaXReference != null && !formulaXReference.equals("")) {
			if (!formulaXReference.contains("x")) {
				new PopUp(formulaXReference, "x");
			} else {
				context C = new context();
				gen g;
				String formulaXCopy;
				for (int i = 0; i < lineReference.getData().getX().size(); i++) {
					formulaXCopy = formulaXReference.replaceAll("x", "" + lineReference.getData().getX().get(i));
					g = new gen(formulaXCopy, C);
					newCalculatedXPoints.add(Double.parseDouble(giac._factor(g, C).print(C)));
				}
			}
		}

		if (formulaYReference != null && !formulaYReference.equals("")) {
			if (!formulaYReference.contains("y")) {
				new PopUp(formulaYReference, "y");
			} else {
				context C = new context();
				gen g;
				String formulaYCopy;
				for (int i = 0; i < lineReference.getData().getY().size(); i++) {
					formulaYCopy = formulaYReference.replaceAll("y", "" + lineReference.getData().getY().get(i));
					g = new gen(formulaYCopy, C);
					newCalculatedYPoints.add(Double.parseDouble(giac._factor(g, C).print(C)));
				}
			}
		}

		lineReference.getDataLinePanel().getTc2dmTrans().fillPoints(newCalculatedXPoints, newCalculatedYPoints, null);
	}

}
