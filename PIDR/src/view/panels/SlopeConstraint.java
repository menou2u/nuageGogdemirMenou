package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JTextField slope = new JTextField(8);
		JLabel slopeLabel = new JLabel("Pente = ");

		this.add(slopeLabel,gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(slope,gbc);
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
