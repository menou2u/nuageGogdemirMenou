package view.panels;

import java.awt.CardLayout;
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
public class TwoConstraintChoicePanel extends JPanel{
	
	private ButtonModel bm;
	private ButtonGroup bG;
	private JRadioButton twoPointCoord;
	private JRadioButton coordAndVertex;
	private JRadioButton slopeAndVertex;
	
	private JPanel constraintChoice;
	private JPanel constraintData;
	private TwoPointCoordConstraintPanel twoPointCoordPane;
	private CoordAndVertexConstraintPanel coordAndVertexPane;
	private SlopeAndVertexConstraintPanel slopeAndVertexPane;
	
	private CardLayout cl;
	
	public TwoConstraintChoicePanel(){
		super(new GridLayout(1,2));	
		initPanel();
		
		add(constraintChoice);
		add(constraintData);
	}

	private void initPanel() {
		bG = new ButtonGroup();
		twoPointCoord = new JRadioButton("Coordonnées de deux points");
		coordAndVertex = new JRadioButton("Coordonnées et pente selon un vecteur d'un plan");
		slopeAndVertex = new JRadioButton("Contrainte sur deux pentes selon deux vecteurs");
		bG.add(twoPointCoord);
		bG.add(coordAndVertex);
		bG.add(slopeAndVertex);
		twoPointCoord.setSelected(true);
		bm = bG.getSelection();
		
		constraintChoice = new JPanel(new GridLayout(3,1));
		constraintChoice.add(twoPointCoord,"twoPointCoord");
		constraintChoice.add(coordAndVertex,"coordAndVertex");
		constraintChoice.add(slopeAndVertex,"slopeAndVertex");
		
		addCustomListener(twoPointCoord);
		addCustomListener(coordAndVertex);
		addCustomListener(slopeAndVertex);
		
		cl = new CardLayout();
		
		constraintData = new JPanel(cl);
		twoPointCoordPane = new TwoPointCoordConstraintPanel();
		coordAndVertexPane = new CoordAndVertexConstraintPanel();
		slopeAndVertexPane = new SlopeAndVertexConstraintPanel();
		
		constraintData.add(twoPointCoordPane,"twoPointCoord");
		constraintData.add(coordAndVertexPane,"coordAndVertex");
		constraintData.add(slopeAndVertexPane,"slopeAndVertex");

		
	}

	private void addCustomListener(JRadioButton bouton) {
		bouton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		if (!bm.equals(bG.getSelection())){
        			bm = bG.getSelection();
        			if (bm.equals(twoPointCoord.getModel()))
        			{
        				cl.show(constraintData,"twoPointCoord");
        			}
        			if (bm.equals(coordAndVertex.getModel())){
        				cl.show(constraintData, "coordAndVertex");
        			}
        			if (bm.equals(slopeAndVertex.getModel())){
        				cl.show(constraintData,"slopeAndVertex");
        			}
        		}

        	}
        });
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        TwoConstraintChoicePanel newContentPane = new TwoConstraintChoicePanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
