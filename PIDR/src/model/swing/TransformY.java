package model.swing;

import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransformY extends Observable{
	
	private JTextField transformY;
	private JLabel transformYLabel;
	
	public TransformY(){
		transformY = new JTextField(8);
		transformYLabel = new JLabel("Y = ty(y)");
	}
	
	public JTextField getTransformY() {
		return transformY;
	}

	public JLabel getTransformYLabel() {
		return transformYLabel;
	}

	
}