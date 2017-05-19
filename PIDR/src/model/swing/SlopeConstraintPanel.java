package model.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Quand on a choisi une contrainte de type "pente".
 * 
 * @author Romain
 *
 */
@SuppressWarnings("serial")
public class SlopeConstraintPanel extends JPanel {
	
	private JTextField slope;

	public SlopeConstraintPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		slope = new JTextField(8);
		JLabel slopeLabel = new JLabel("Pente = ");

		this.add(slopeLabel,gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(slope,gbc);
	}
	
	

	/**
	 * @return the slope
	 */
	public JTextField getSlope() {
		return slope;
	}



	public static void main(String[] args) {
		JFrame frame = new JFrame("PointConstraint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SlopeConstraintPanel newContentPane = new SlopeConstraintPanel();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

}
