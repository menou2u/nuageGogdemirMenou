package view.panels;

import java.awt.GridLayout;

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
		super(new GridLayout(3,4));
		initComp();
		fillWithComp();
	}
	
	public void initComp(){
		xw1 = new JTextField();
		yw1 = new JTextField();
		zw1 = new JTextField();
		xw2 = new JTextField();
		yw2 = new JTextField();
		zw2 = new JTextField();
		
		xw1Lab = new JLabel("Xw1 brut = ");
		yw1Lab = new JLabel("Yw1 brut = ");
		zw1Lab = new JLabel("Zw1 brut = ");
		xw2Lab = new JLabel("Xw2 brut = ");
		yw2Lab = new JLabel("Yw2 brut = ");
		zw2Lab = new JLabel("Zw2 brut = ");
	}
	
	public void fillWithComp(){
		add(xw1Lab);
		add(xw1);
		
		add(xw2Lab);
		add(xw2);

		add(yw1Lab);
		add(yw1);
		
		add(yw2Lab);
		add(yw2);
		
		add(zw1Lab);
		add(zw1);
		
		add(zw2Lab);
		add(zw2);
	}
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        TwoPointCoordConstraintPanel newContentPane = new TwoPointCoordConstraintPanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
	}
}
