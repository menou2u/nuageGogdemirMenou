package pidr.view.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pidr.model.Constraints;


//Ajouter un bouton pour ajouter des contraintes :)
@SuppressWarnings("serial")
public class ConstraintsPanel extends JPanel {
    
    public ConstraintsPanel(Constraints c) {
        super(new GridLayout(1,0));
        //Add the scroll pane to this panel.
        add(c.getScrollPane());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        ConstraintsPanel newContentPane = new ConstraintsPanel(c);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
