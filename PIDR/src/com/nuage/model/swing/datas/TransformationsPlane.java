package com.nuage.model.swing.datas;

import javax.swing.JButton;

public class TransformationsPlane {

	private TransformX transformX;
	private TransformY transformY;
	private TransformZ transformZ;
	private JButton validation;
	
	public TransformationsPlane(){
		transformX = new TransformX();
		transformY = new TransformY();
		transformZ = new TransformZ();
		validation = new JButton("Validation des données");
	}

	public TransformX getTransformX() {
		return transformX;
	}

	public TransformY getTransformY() {
		return transformY;
	}

	public TransformZ getTransformZ() {
		return transformZ;
	}

	public JButton getValidation() {
		return validation;
	}
	
}
