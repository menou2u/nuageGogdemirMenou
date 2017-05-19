package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.swing.PointConstraint;

public class PointConstraintPanel extends JPanel{

	
	public PointConstraintPanel(PointConstraint pointConstraint){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		this.add(pointConstraint.getxWTrueLabel(),gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(pointConstraint.getxWTrue(),gbc);
		
		gbc.gridx+=gbc.gridwidth;
		this.add(pointConstraint.getxWTreatedLabel(),gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(pointConstraint.getxWTreated(),gbc);
		
		gbc.gridx=0;
		gbc.gridy+=gbc.gridheight;
		this.add(pointConstraint.getyWTrueLabel(),gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(pointConstraint.getyWTrue(),gbc);
		
		gbc.gridx+=gbc.gridwidth;
		this.add(pointConstraint.getyWTreatedLabel(),gbc);
		gbc.gridx+=gbc.gridwidth;
		this.add(pointConstraint.getyWTreated(),gbc);
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("PointConstraint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PointConstraint pointConstraint = new PointConstraint();
        PointConstraintPanel newContentPane = new PointConstraintPanel(pointConstraint);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
