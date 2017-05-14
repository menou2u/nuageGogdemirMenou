package pidr.view.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pidr.model.Constraints;

/**
 * Quand on a choisi une contrainte de type "point".
 * @author Romain
 *
 */
public class PointConstraint extends JPanel {
	
	public PointConstraint(Constraints c){
		GridLayout gL = new GridLayout(2,4);
		JTextField xWTrue = new JTextField();
		JTextField xWTreated = new JTextField();
		JTextField yWTrue = new JTextField();
		JTextField yWTreated = new JTextField();
		JLabel xWTrueLabel = new JLabel("xw brut = ");
		JLabel yWTrueLabel = new JLabel("yw brut = ");
		JLabel xWTreatedLabel = new JLabel("xw traité = ");
		JLabel yWTreatedLabel = new JLabel("yw traité = ");
		this.setLayout(gL);
		this.add(xWTrueLabel);
		this.add(xWTrue);
		this.add(xWTreatedLabel);
		this.add(xWTreated);
		this.add(yWTrueLabel);
		this.add(yWTrue);
		this.add(yWTreatedLabel);
		this.add(yWTreated);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
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
