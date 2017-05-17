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

import model.swing.Constraints;

@SuppressWarnings("serial")
public class PlaneConstraintsChoicePanel extends JPanel {
	
	private ButtonGroup bG;
	private ButtonModel bm;
	private JRadioButton noConstraint;
	private JRadioButton oneConstraint;
	private JRadioButton twoConstraint;
	
	private JPanel constraintChoice;
	private JPanel constraintData;
	private JPanel noConstraintPane;
	private OneConstraintChoicePanel oneConstraintPane;
	private TwoConstraintChoicePanel twoConstraintPane;
	
	private CardLayout cl;
	
	public PlaneConstraintsChoicePanel()
	{
		super(new GridBagLayout());	
		initPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(constraintChoice,gbc);
		gbc.gridx=1;
		gbc.weightx=1;
		add(constraintData,gbc);
    }

	private void initPanel() {
		bG = new ButtonGroup();
		noConstraint = new JRadioButton("Aucune contrainte");
		oneConstraint = new JRadioButton("Une contrainte");
		twoConstraint = new JRadioButton("Deux contraintes");
		bG.add(noConstraint);
		bG.add(oneConstraint);
		bG.add(twoConstraint);
		noConstraint.setSelected(true);
		bm = bG.getSelection();
		
		constraintChoice = new JPanel(new GridLayout(3,1));
		constraintChoice.add(noConstraint,"noConstraint");
		constraintChoice.add(oneConstraint,"oneConstraint");
		constraintChoice.add(twoConstraint,"twoConstraint");
		
		addCustomListener(noConstraint);
		addCustomListener(oneConstraint);
		addCustomListener(twoConstraint);
		
		cl = new CardLayout();
		
		constraintData = new JPanel(cl);
		noConstraintPane = new JPanel();
		oneConstraintPane = new OneConstraintChoicePanel();
		twoConstraintPane = new TwoConstraintChoicePanel();
		
		constraintData.add(noConstraintPane,"noConstraint");
		constraintData.add(oneConstraintPane,"oneConstraint");
		constraintData.add(twoConstraintPane,"twoConstraint");
		
	}

	private void addCustomListener(JRadioButton bouton) {
		bouton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		if (!bm.equals(bG.getSelection())){
        			bm = bG.getSelection();
        			if (bm.equals(noConstraint.getModel()))
        			{
        				cl.show(constraintData,"noConstraint");
        			}
        			if (bm.equals(oneConstraint.getModel())){
        				cl.show(constraintData, "oneConstraint");
        			}
        			if (bm.equals(twoConstraint.getModel())){
        				cl.show(constraintData,"twoConstraint");
        			}
        		}

        	}
        });
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        @SuppressWarnings("unused")
		Constraints c = new Constraints();
        PlaneConstraintsChoicePanel newContentPane = new PlaneConstraintsChoicePanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
