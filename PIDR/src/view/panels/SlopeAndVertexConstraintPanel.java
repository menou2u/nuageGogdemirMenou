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
public class SlopeAndVertexConstraintPanel extends JPanel {
	private JPanel v1XoYV2XoY;
	private JPanel v1ZoXV2ZoX;
	private JPanel v1YoZV2YoZ;
	private JPanel v1XoYV2ZoX;
	private JPanel v1XoYV2YoZ;
	private JPanel v1YoZV2ZoX;
	private JPanel cardDisplayer;
	private JPanel constraintChoser;

	private ButtonGroup bG;

	private ButtonModel bm;

	private JRadioButton v1XoYV2XoYButton;
	private JRadioButton v1ZoXV2ZoXButton;
	private JRadioButton v1YoZV2YoZButton;
	private JRadioButton v1XoYV2YoZButton;
	private JRadioButton v1XoYV2ZoXButton;
	private JRadioButton v1YoZV2ZoXButton;
	
	private CardLayout cl;

	public SlopeAndVertexConstraintPanel() {
		super(new GridBagLayout());
		initField();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(constraintChoser,gbc);
		
		gbc.weightx=1;
		gbc.gridx=1;
		add(cardDisplayer,gbc);
	}

	private void initField() {
		v1XoYV2XoY = new SlopeAndVertexConstraintPanelHelper("ij", "ij");
		v1ZoXV2ZoX = new SlopeAndVertexConstraintPanelHelper("ki", "ki");;
		v1YoZV2YoZ = new SlopeAndVertexConstraintPanelHelper("jk", "jk");;
		v1XoYV2ZoX = new SlopeAndVertexConstraintPanelHelper("ij", "ki");;
		v1XoYV2YoZ = new SlopeAndVertexConstraintPanelHelper("ij", "jk");;
		v1YoZV2ZoX = new SlopeAndVertexConstraintPanelHelper("jk", "ki");;
		
		v1XoYV2XoYButton = new JRadioButton("V1 et V2 dans (xoy)");
		v1ZoXV2ZoXButton = new JRadioButton("V1 et V2 dans (zox)");
		v1YoZV2YoZButton = new JRadioButton("V1 et V2 dans (yoz)");
		v1XoYV2YoZButton = new JRadioButton("V1 dans (xoy) et V2 dans (yoz)");
		v1XoYV2ZoXButton = new JRadioButton("V1 dans (xoy) et V2 dans (zox)");
		v1YoZV2ZoXButton = new JRadioButton("V1 dans (yoz) et V2 dans (zox)");
		
		bG = new ButtonGroup();
		bG.add(v1XoYV2XoYButton);
		bG.add(v1ZoXV2ZoXButton);
		bG.add(v1YoZV2YoZButton);
		bG.add(v1XoYV2YoZButton);
		bG.add(v1XoYV2ZoXButton);
		bG.add(v1YoZV2ZoXButton);
		
		addCustomListener(v1XoYV2XoYButton);
		addCustomListener(v1ZoXV2ZoXButton);
		addCustomListener(v1YoZV2YoZButton);
		addCustomListener(v1XoYV2YoZButton);
		addCustomListener(v1XoYV2ZoXButton);
		addCustomListener(v1YoZV2ZoXButton);

		v1XoYV2XoYButton.setSelected(true);
		bm = bG.getSelection();
		
		cl = new CardLayout();
		
		cardDisplayer = new JPanel(cl);
		cardDisplayer.add(v1XoYV2XoY,"v1XoYV2XoY");
		cardDisplayer.add(v1ZoXV2ZoX,"v1ZoXV2ZoX");
		cardDisplayer.add(v1YoZV2YoZ,"v1YoZV2YoZ");
		cardDisplayer.add(v1XoYV2ZoX,"v1XoYV2ZoX");
		cardDisplayer.add(v1XoYV2YoZ,"v1XoYV2YoZ");
		cardDisplayer.add(v1YoZV2ZoX,"v1YoZV2ZoX");
		
		constraintChoser = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		constraintChoser.add(v1XoYV2XoYButton,gbc);
		gbc.gridx=1;
		constraintChoser.add(v1XoYV2YoZButton,gbc);
		
		gbc.gridy=1;
		gbc.gridx=0;
		constraintChoser.add(v1ZoXV2ZoXButton,gbc);
		gbc.gridx=1;
		constraintChoser.add(v1XoYV2ZoXButton,gbc);
		
		gbc.gridy=2;
		gbc.gridx=0;
		constraintChoser.add(v1YoZV2YoZButton,gbc);
		gbc.gridx=1;
		constraintChoser.add(v1YoZV2ZoXButton,gbc);
	}
	
	private void addCustomListener(JRadioButton bouton) {
		bouton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		if (!bm.equals(bG.getSelection())){
        			bm = bG.getSelection();
        			if (bm.equals(v1XoYV2XoYButton.getModel())){
        				cl.show(cardDisplayer,"v1XoYV2XoY");
        			}
        			if (bm.equals(v1XoYV2YoZButton.getModel())){
        				cl.show(cardDisplayer, "v1XoYV2YoZ");
        			}
        			if (bm.equals(v1ZoXV2ZoXButton.getModel())){
        				cl.show(cardDisplayer,"v1ZoXV2ZoX");
        			}
        			if (bm.equals(v1XoYV2ZoXButton.getModel())){
        				cl.show(cardDisplayer,"v1XoYV2ZoX");
        			}
        			if (bm.equals(v1YoZV2YoZButton.getModel())){
        				cl.show(cardDisplayer, "v1YoZV2YoZ");
        			}
        			if (bm.equals(v1YoZV2ZoXButton.getModel())){
        				cl.show(cardDisplayer,"v1YoZV2ZoX");
        			}
        		}

        	}
        });
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        SlopeAndVertexConstraintPanel newContentPane = new SlopeAndVertexConstraintPanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

}
