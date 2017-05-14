package pidr.view.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import pidr.model.Constraints;


//Ajouter un bouton pour ajouter des contraintes :)
@SuppressWarnings("serial")
public class ConstraintsChoicePanel extends JPanel {
    
    public ConstraintsChoicePanel(Constraints c) {
        super(new GridLayout(3,3));
        
        JRadioButton noConstraint = new JRadioButton("Sans contrainte");
        JRadioButton pointConstraint = new JRadioButton("Droite passe par (Xw;Yw)");
        JRadioButton slopeConstraint = new JRadioButton("Fixer la pente de la droite");
        
        ButtonGroup bG = new ButtonGroup();
        
        bG.add(noConstraint);
        bG.add(pointConstraint);
        bG.add(slopeConstraint);
        
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
        
        this.add(noConstraint);
        this.add(pointConstraint);
        this.add(slopeConstraint);
        
        noConstraint.setSelected(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        ConstraintsChoicePanel newContentPane = new ConstraintsChoicePanel(c);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
