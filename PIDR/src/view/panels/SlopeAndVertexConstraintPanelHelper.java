package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.swing.Constraints;

@SuppressWarnings("serial")
public class SlopeAndVertexConstraintPanelHelper extends JPanel{
	
	private JTextField v1x;
	private JTextField v1y;
	private JTextField v2x;
	private JTextField v2y;
	
	private JLabel v1xLab;
	private JLabel v1yLab;
	private JLabel v2xLab;
	private JLabel v2yLab;
	
	public SlopeAndVertexConstraintPanelHelper(String axev1,String axev2)
	{
		super(new GridBagLayout());
		
		initField(axev1,axev2);
		fillWithFields();

	}

	private void fillWithFields() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(v1xLab,gbc);
		gbc.gridx=1;
		add(v1x,gbc);
		
		gbc.gridx=2;
		add(v2xLab,gbc);
		gbc.gridx=3;
		add(v2x,gbc);
		
		gbc.gridy=1;
		gbc.gridx=0;
		add(v1yLab,gbc);
		gbc.gridx=1;
		add(v1y,gbc);
		
		gbc.gridx=2;
		add(v2yLab,gbc);
		gbc.gridx=3;
		add(v2y,gbc);
	}

	private void initField(String axev1,String axev2) {
		v1x = new JTextField(8);
		v2x = new JTextField(8);
		v1y = new JTextField(8);
		v2y = new JTextField(8);
		
		v1xLab = new JLabel("V1x"+axev1+" = ");
		v1yLab = new JLabel("V1y"+axev1+" = ");
		v2xLab = new JLabel("V2x"+axev2+" = ");
		v2yLab = new JLabel("V2y"+axev2+" = ");
	}

    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        @SuppressWarnings("unused")
		Constraints c = new Constraints();
        SlopeAndVertexConstraintPanelHelper newContentPane = new SlopeAndVertexConstraintPanelHelper("ij","ij");
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
