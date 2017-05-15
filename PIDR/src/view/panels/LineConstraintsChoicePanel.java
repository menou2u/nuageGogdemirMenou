package view.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.swing.Constraints;


//Ajouter un bouton pour ajouter des contraintes :)
@SuppressWarnings("serial")
public class LineConstraintsChoicePanel extends JPanel {
    
	private JPanel chosenPanel;
	private CardLayout cl;
	private JPanel noConstraintPanel;
	private PointConstraint pointConstraintPanel;
	private SlopeConstraint slopeConstraintPanel;
	private Constraints constraints;
	private JPanel selectionPanel;
	private ButtonModel bm;
	private ButtonGroup bG;
	private JRadioButton noConstraint;
    private JRadioButton pointConstraint;
    private JRadioButton slopeConstraint;
	
    public LineConstraintsChoicePanel(Constraints c) {
        super(new GridLayout(1,2));
     
        selectionPanel = new JPanel(new GridLayout(3,1));
        bG = new ButtonGroup();
        noConstraint = new JRadioButton("Sans contrainte");
        pointConstraint = new JRadioButton("Droite passe par (Xw;Yw)");
        slopeConstraint = new JRadioButton("Fixer la pente de la droite");
        
		cl = new CardLayout();
		chosenPanel = new JPanel(cl);
		
		constraints = new Constraints();
		
		noConstraintPanel = new JPanel();
		pointConstraintPanel = new PointConstraint(constraints);
		slopeConstraintPanel = new SlopeConstraint(constraints);
		
		chosenPanel.add(noConstraintPanel,"Pas de contrainte");
		chosenPanel.add(pointConstraintPanel,"Contrainte sur un point");
		chosenPanel.add(slopeConstraintPanel,"Contrainte sur la pente");
		
		cl.first(chosenPanel);
		
        bG.add(noConstraint);
        bG.add(pointConstraint);
        bG.add(slopeConstraint);
        noConstraint.setSelected(true);
        
        bm = bG.getSelection();
        
        addCustomListener(noConstraint);   
        addCustomListener(pointConstraint);
        addCustomListener(slopeConstraint);
        
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
        
        selectionPanel.add(noConstraint);
        selectionPanel.add(pointConstraint);
        selectionPanel.add(slopeConstraint);
        
        this.add(selectionPanel);
        this.add(chosenPanel);
    }
    
    public void addCustomListener(JRadioButton bouton){
    	bouton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		if (!bm.equals(bG.getSelection())){
        			bm = bG.getSelection();
        			if (bm.equals(noConstraint.getModel()))
        			{
        				cl.first(chosenPanel);
        			}
        			if (bm.equals(pointConstraint.getModel())){
        				cl.show(chosenPanel, "Contrainte sur un point");
        			}
        			if (bm.equals(slopeConstraint.getModel())){
        				cl.show(chosenPanel,"Contrainte sur la pente");
        			}
        		}

        	}
        });
    }
    
    public ButtonModel getBM(){
    	return bm;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        LineConstraintsChoicePanel newContentPane = new LineConstraintsChoicePanel(c);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
