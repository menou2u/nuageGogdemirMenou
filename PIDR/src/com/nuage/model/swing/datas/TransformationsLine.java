package com.nuage.model.swing.datas;

import javax.swing.JButton;

import com.nuage.controller.ValidationButtonListener;
import com.nuage.model.swing.mode.Line;

public class TransformationsLine {

	private TransformX transformX;
	private TransformY transformY;
	private JButton validation;

	public TransformationsLine(Line line) {
		transformX = new TransformX();
		transformY = new TransformY();
		validation = new JButton("Validation des donn�es");
		validation.addActionListener(new ValidationButtonListener(line));
	}

	public TransformX getTransformX() {
		return transformX;
	}

	public TransformY getTransformY() {
		return transformY;
	}

	public JButton getValidation() {
		return validation;
	}
}
