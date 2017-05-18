package model.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Quand on a choisi une contrainte de type "point".
 * @author Romain
 *
 */
@SuppressWarnings("serial")
public class PointConstraint extends JPanel {
	
	private JTextField xWTrue;
	private JTextField xWTreated;
	private JTextField yWTrue;
	private JTextField yWTreated;

	public PointConstraint(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		xWTrue = new JTextField(8);
		xWTreated = new JTextField(8);
		yWTrue = new JTextField(8);
		yWTreated = new JTextField(8);
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
	
	public LinkedList<Double> getOmegaDatas(){
		LinkedList<Double> omegaDatas = new LinkedList<Double>();
		omegaDatas.add(Double.parseDouble(xWTrue.getText()));
		omegaDatas.add(Double.parseDouble(yWTrue.getText()));
		omegaDatas.add(Double.parseDouble(xWTreated.getText()));
		omegaDatas.add(Double.parseDouble(yWTreated.getText()));
		return omegaDatas;
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("PointConstraint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PointConstraint newContentPane = new PointConstraint();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
