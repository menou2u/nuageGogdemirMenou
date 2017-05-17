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
 * Quand on a choisi une contrainte de type "point".
 * @author Romain
 *
 */
@SuppressWarnings("serial")
public class PointConstraint extends JPanel {
	
	public PointConstraint(Constraints c){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JTextField xWTrue = new JTextField(8);
		JTextField xWTreated = new JTextField(8);
		JTextField yWTrue = new JTextField(8);
		JTextField yWTreated = new JTextField(8);
		JLabel xWTrueLabel = new JLabel("Xw brut = ");
		JLabel yWTrueLabel = new JLabel("Yw brut = ");
		JLabel xWTreatedLabel = new JLabel("Xw traité = ");
		JLabel yWTreatedLabel = new JLabel("Yw traité = ");
		
		this.add(xWTrueLabel,gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(xWTrue,gbc);
		
		gbc.gridx+=gbc.gridwidth;
		this.add(xWTreatedLabel,gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(xWTreated,gbc);
		
		gbc.gridx=0;
		gbc.gridy+=gbc.gridheight;
		this.add(yWTrueLabel,gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(yWTrue,gbc);
		
		gbc.gridx+=gbc.gridwidth;
		this.add(yWTreatedLabel,gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(yWTreated,gbc);
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("PointConstraint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        PointConstraint newContentPane = new PointConstraint(c);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
