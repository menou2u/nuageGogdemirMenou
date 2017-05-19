package model.swing;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LineConstraintsChoice extends Observable {

	private JPanel chosenPanel;
	private CardLayout cl;
	private JPanel noConstraintPanel;
	private PointConstraint pointConstraintPanel;
	private SlopeConstraint slopeConstraintPanel;
	private JPanel selectionPanel;
	private ButtonModel bm;
	private ButtonGroup bG;
	private JRadioButton noConstraint;
    private JRadioButton pointConstraint;
    private JRadioButton slopeConstraint;
    private int commutateur;
    
    public LineConstraintsChoice() {
    	selectionPanel = new JPanel(new GridLayout(3,1));
        bG = new ButtonGroup();
        noConstraint = new JRadioButton("Sans contrainte");
        pointConstraint = new JRadioButton("Droite passe par (Xw;Yw)");
        slopeConstraint = new JRadioButton("Fixer la pente de la droite");
        
		cl = new CardLayout();
		chosenPanel = new JPanel(cl);
		
		noConstraintPanel = new JPanel();
		pointConstraintPanel = new PointConstraint();
		slopeConstraintPanel = new SlopeConstraint();
		
		chosenPanel.add(noConstraintPanel,"Pas de contrainte");
		chosenPanel.add(pointConstraintPanel,"Contrainte sur un point");
		chosenPanel.add(slopeConstraintPanel,"Contrainte sur la pente");
		
		cl.first(chosenPanel);
		
        bG.add(noConstraint);
        bG.add(pointConstraint);
        bG.add(slopeConstraint);
        noConstraint.setSelected(true);
        bm = bG.getSelection();
        
        selectionPanel.add(noConstraint);
        selectionPanel.add(pointConstraint);
        selectionPanel.add(slopeConstraint);
        
        addCustomListener(noConstraint);   
        addCustomListener(pointConstraint);
        addCustomListener(slopeConstraint);
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
        				commutateur = 0;
        				cl.first(chosenPanel);
        			}
        			if (bm.equals(pointConstraint.getModel())){
        				commutateur = 1;
        				cl.show(chosenPanel, "Contrainte sur un point");
        			}
        			if (bm.equals(slopeConstraint.getModel())){
        				commutateur = 2;
        				cl.show(chosenPanel,"Contrainte sur la pente");
        			}
        		}

        	}
        });
    }
    /**
	 * @return the commutateur
	 */
	public int getCommutateur() {
		return commutateur;
	}

	public ButtonModel getBM(){
    	return bm;
    }

	/**
	 * @return the chosenPanel
	 */
	public JPanel getChosenPanel() {
		return chosenPanel;
	}

	/**
	 * @return the cl
	 */
	public CardLayout getCl() {
		return cl;
	}

	/**
	 * @return the noConstraintPanel
	 */
	public JPanel getNoConstraintPanel() {
		return noConstraintPanel;
	}

	/**
	 * @return the pointConstraintPanel
	 */
	public PointConstraint getPointConstraintPanel() {
		return pointConstraintPanel;
	}

	/**
	 * @return the slopeConstraintPanel
	 */
	public SlopeConstraint getSlopeConstraintPanel() {
		return slopeConstraintPanel;
	}

	/**
	 * @return the selectionPanel
	 */
	public JPanel getSelectionPanel() {
		return selectionPanel;
	}

	/**
	 * @return the bm
	 */
	public ButtonModel getBm() {
		return bm;
	}

	/**
	 * @return the bG
	 */
	public ButtonGroup getbG() {
		return bG;
	}

	/**
	 * @return the noConstraint
	 */
	public JRadioButton getNoConstraint() {
		return noConstraint;
	}

	/**
	 * @return the pointConstraint
	 */
	public JRadioButton getPointConstraint() {
		return pointConstraint;
	}

	/**
	 * @return the slopeConstraint
	 */
	public JRadioButton getSlopeConstraint() {
		return slopeConstraint;
	}
	
    
}
