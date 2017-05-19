package model.swing;

import java.util.LinkedList;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Quand on a choisi une contrainte de type "point".
 * @author Romain
 *
 */
@SuppressWarnings("serial")
public class PointConstraint extends Observable {
	
	private JTextField xWTrue;
	private JTextField xWTreated;
	private JTextField yWTrue;
	private JTextField yWTreated;
	
	private JLabel xWTrueLabel;
	private JLabel yWTrueLabel;
	private JLabel xWTreatedLabel;
	private JLabel yWTreatedLabel;

	public PointConstraint(){
		xWTrue = new JTextField(8);
		xWTreated = new JTextField(8);
		yWTrue = new JTextField(8);
		yWTreated = new JTextField(8);
		xWTrueLabel = new JLabel("Xw brut = ");
		yWTrueLabel = new JLabel("Yw brut = ");
		xWTreatedLabel = new JLabel("Xw traité = ");
		yWTreatedLabel = new JLabel("Yw traité = ");
	}
	
	public LinkedList<Double> getOmegaDatas(){
		LinkedList<Double> omegaDatas = new LinkedList<Double>();
		omegaDatas.add(Double.parseDouble(xWTrue.getText()));
		omegaDatas.add(Double.parseDouble(yWTrue.getText()));
		omegaDatas.add(Double.parseDouble(xWTreated.getText()));
		omegaDatas.add(Double.parseDouble(yWTreated.getText()));
		return omegaDatas;
	}

	public JTextField getxWTrue() {
		return xWTrue;
	}

	public JTextField getxWTreated() {
		return xWTreated;
	}

	public JTextField getyWTrue() {
		return yWTrue;
	}

	public JTextField getyWTreated() {
		return yWTreated;
	}

	public JLabel getxWTrueLabel() {
		return xWTrueLabel;
	}

	public JLabel getyWTrueLabel() {
		return yWTrueLabel;
	}

	public JLabel getxWTreatedLabel() {
		return xWTreatedLabel;
	}

	public JLabel getyWTreatedLabel() {
		return yWTreatedLabel;
	}
	
}
