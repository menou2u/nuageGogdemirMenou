package view.panels;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.swing.PointConstraint;
import model.swing.SlopeConstraint;


//Ajouter un bouton pour ajouter des contraintes :)
@SuppressWarnings("serial")
public class LineConstraintsChoicePanel extends JPanel {
    
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
	
    public LineConstraintsChoicePanel() {
        super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
     
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
        
        addCustomListener(noConstraint);   
        addCustomListener(pointConstraint);
        addCustomListener(slopeConstraint);
        
        
        selectionPanel.add(noConstraint);
        selectionPanel.add(pointConstraint);
        selectionPanel.add(slopeConstraint);
        
        this.add(selectionPanel,gbc);
        
        gbc.gridx+=gbc.gridwidth;
        this.add(chosenPanel,gbc);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LineConstraintsChoicePanel newContentPane = new LineConstraintsChoicePanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
