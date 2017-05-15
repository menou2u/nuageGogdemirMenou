package view.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.swing.Constraints;

@SuppressWarnings("serial")
public class OneConstraintChoicePanel extends JPanel {
	
	private CardLayout cl;
	
	private ButtonGroup bG;
	private ButtonModel bm;
	
	private JRadioButton pointChoice;
	private JRadioButton slopeChoice;
	
	private JPanel constraintDatas;
	private JPanel constraintChoice;
	private JPanel pointChosen;
	private VertexConstraintChoice vertexChosen;
	
	private JTextField x;
	private JTextField y;
	private JTextField z;
	
	public OneConstraintChoicePanel(){
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		cl = new CardLayout();
		
		constraintDatas = new JPanel(cl);
		constraintChoice = new JPanel(new GridLayout(2,1));
		
		initPanelDatas();
		
		bG = new ButtonGroup();
		pointChoice = new JRadioButton("Contraintes sur les coordonnées d'un point");
		slopeChoice = new JRadioButton("Contraintes sur pente selon un vecteur d'un plan");
		
		bG.add(pointChoice);
		bG.add(slopeChoice);
		
		pointChoice.setSelected(true);
		
		bm = bG.getSelection();
		
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));

        constraintChoice.add(pointChoice,"Point");
        constraintChoice.add(slopeChoice,"Slope");
        
        addCustomListener(pointChoice);
        addCustomListener(slopeChoice);
        
        this.add(constraintChoice,gbc);
        gbc.gridx=1;
        gbc.weightx=1;
        this.add(constraintDatas);
		
	}
	
	public void initPanelDatas(){
		pointChosen = new JPanel(new GridLayout(3,2));
		
		x = new JTextField();
		y = new JTextField();
		z = new JTextField();
		
		pointChosen.add(new JLabel("Xw1 brut = "));
		pointChosen.add(x);
		pointChosen.add(new JLabel("Yw1 brut = "));
		pointChosen.add(y);
		pointChosen.add(new JLabel("Zw1 brut = "));
		pointChosen.add(z);
		
		constraintDatas.add(pointChosen,"Point");
		
		vertexChosen = new VertexConstraintChoice();
		
		constraintDatas.add(vertexChosen,"Slope");
	}
	
	public void addCustomListener(JRadioButton bouton){
		bouton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		if (!bm.equals(bG.getSelection())){
        			bm = bG.getSelection();
        			if (bm.equals(pointChoice.getModel()))
        			{
        				cl.show(constraintDatas,"Point");
        			}
        			if (bm.equals(slopeChoice.getModel())){
        				cl.show(constraintDatas, "Slope");
        			}
        		}

        	}
        });
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("OneConstraintChoicePanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        OneConstraintChoicePanel newContentPane = new OneConstraintChoicePanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
