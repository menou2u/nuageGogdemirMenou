package view.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.swing.Constraints;

/**
 * Quand on a choisi une contrainte de type "pente".
 * 
 * @author Romain
 *
 */
@SuppressWarnings("serial")
public class SlopeConstraint extends JPanel {

	public SlopeConstraint(Constraints c) {
		GridLayout gL = new GridLayout(1, 2);
		JTextField slope = new JTextField();
		JLabel slopeLabel = new JLabel("Pente = ");
		this.setLayout(gL);
		this.add(slopeLabel);
		this.add(slope);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("PointConstraint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constraints c = new Constraints();
		SlopeConstraint newContentPane = new SlopeConstraint(c);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

}
