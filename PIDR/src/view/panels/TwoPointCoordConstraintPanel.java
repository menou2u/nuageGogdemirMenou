package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.swing.Constraints;

@SuppressWarnings("serial")
public class TwoPointCoordConstraintPanel extends JPanel{
	
	private JTextField xw1;
	private JTextField yw1;
	private JTextField zw1;
	private JTextField xw2;
	private JTextField yw2;
	private JTextField zw2;
	
	private JLabel xw1Lab;
	private JLabel yw1Lab;
	private JLabel zw1Lab;
	private JLabel xw2Lab;
	private JLabel yw2Lab;
	private JLabel zw2Lab;

	public TwoPointCoordConstraintPanel(){
		super(new GridBagLayout());
		initComp();
		fillWithComp();
	}
	
	public void initComp(){
		xw1 = new JTextField(8);
		yw1 = new JTextField(8);
		zw1 = new JTextField(8);
		xw2 = new JTextField(8);
		yw2 = new JTextField(8);
		zw2 = new JTextField(8);
		
		xw1Lab = new JLabel("Xw1 brut = ");
		yw1Lab = new JLabel("Yw1 brut = ");
		zw1Lab = new JLabel("Zw1 brut = ");
		xw2Lab = new JLabel("Xw2 brut = ");
		yw2Lab = new JLabel("Yw2 brut = ");
		zw2Lab = new JLabel("Zw2 brut = ");
	}
	
	public void fillWithComp(){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(xw1Lab,gbc);
		
		gbc.gridx=1;
		add(xw1,gbc);
		
		gbc.gridx=2;
		add(xw2Lab,gbc);
		
		gbc.gridx=3;
		add(xw2,gbc);

		gbc.gridy=1;
		gbc.gridx=0;
		add(yw1Lab,gbc);
		
		gbc.gridx=1;
		add(yw1,gbc);
		
		gbc.gridx=2;
		add(yw2Lab,gbc);
		
		gbc.gridx=3;
		add(yw2,gbc);
		
		gbc.gridy=2;
		gbc.gridx=0;
		add(zw1Lab,gbc);
		
		gbc.gridx=1;
		add(zw1,gbc);
		
		gbc.gridx=2;
		add(zw2Lab,gbc);
		
		gbc.gridx=3;
		add(zw2,gbc);
	}
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        @SuppressWarnings("unused")
		Constraints c = new Constraints();
        TwoPointCoordConstraintPanel newContentPane = new TwoPointCoordConstraintPanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
	}
}
