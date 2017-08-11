package model.swing.datas;

import javax.swing.JButton;

public class TransformationsLine {

	private TransformX transformX;
	private TransformY transformY;
	private JButton validation;
	
	public TransformationsLine(){
		transformX = new TransformX();
		transformY = new TransformY();
		validation = new JButton("Validation des données");
	}

	public TransformX getTransformX() {
		return transformX;
	}

	public TransformY getTransformY() {
		return transformY;
	}
	
	public JButton getValidation(){
		return validation;
	}
}
